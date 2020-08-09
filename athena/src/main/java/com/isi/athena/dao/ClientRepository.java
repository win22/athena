package com.isi.athena.dao;

import com.isi.athena.model.Client;
import com.isi.athena.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "SELECT max(idCli) FROM Client ",nativeQuery = true)
    int maxIdFromClient();

    @Query(value = "SELECT CNI FROM Client ",nativeQuery = true)
    List<String> allCIN();

    @Query(value = "SELECT username FROM users ",nativeQuery = true)
    List<String> Usernames();
}
