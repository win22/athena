package com.isi.athena.controller;

import com.isi.athena.model.Client;
import com.isi.athena.model.Role;
import com.isi.athena.model.RoleName;
import com.isi.athena.model.User;
import com.isi.athena.model.serialization.Compte;
import com.isi.athena.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@EnableAutoConfiguration
@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PreAuthorize("hasAuthority('ROLE_CLIENT') or hasAuthority('ROLE_USER')")
    @PostMapping(value= "/addClient" , consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    public @ResponseBody Client addClient(@RequestBody Client c) {

       try {

           BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
           String hashedPassword = passwordEncoder.encode(c.getUser().getPassword());

           //System.out.println("password "+hashedPassword);

           c.getUser().setPassword(hashedPassword);
           c.getUser().setEmail(c.getEmailCli());

           System.out.println("Email"+c.getUser().getEmail());
           Role r = new Role();
           r.setId(2);
           r.setName(RoleName.ROLE_CLIENT);

           c.getUser().setRole(r);

           System.out.println("Role"+c.getUser().getRole().getId());

            c.getUser().setName(c.getNom()+" "+c.getPrenom());
            int max = clientService.getMaxId();
            User u = new User();

            u=clientService.addClientCompte(c.getUser());
            System.out.println(u.getId());

            c.setUser(u);

           System.out.println("user "+c.getUser().getId());
            c.setNumCli("PT-00"+(max+1));
            return clientService.addClient(c);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @PreAuthorize("hasAuthority('ROLE_CLIENT') or hasAuthority('ROLE_USER')")
    @PostMapping(value= "/login" , consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    public @ResponseBody User log(@RequestBody User u){
        return clientService.login(u.getUsername());
    }


    @PreAuthorize("hasAuthority('ROLE_CLIENT') or hasAuthority('ROLE_USER')")
    @GetMapping("/all")
    @CrossOrigin("*")
    public @ResponseBody List<Client> list(){
        return clientService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_CLIENT') or hasAuthority('ROLE_USER')")
    @GetMapping("/allCNI")
    @CrossOrigin("*")
    public @ResponseBody List<String> ListCni(){
        return clientService.lissCIN();
    }

    @PreAuthorize("hasAuthority('ROLE_CLIENT') or hasAuthority('ROLE_USER')")
    @GetMapping("/allUsernames")
    @CrossOrigin("*")
    public @ResponseBody List<String> ListUsername(){
        return clientService.listUsername();
    }
}
