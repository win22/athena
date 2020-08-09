package com.isi.athena.dao;

import com.isi.athena.model.Role;
import com.isi.athena.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(RoleName name);
}
