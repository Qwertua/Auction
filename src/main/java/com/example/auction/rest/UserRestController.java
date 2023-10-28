package com.example.auction.rest;

import com.example.auction.models.Users;
import com.example.auction.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserRestController {

    private final UsersService usersService;

    @Autowired
    public UserRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/all/users")
    public List<Users> getAllLots(){
        return usersService.getAllUsers();
    }

    @GetMapping("/search/user")
    public Users searchById(@RequestParam Long id){
        return usersService.findById(id);
    }

    @PostMapping("/save/user")
    public Users saveUser(Users users){
        return usersService.saveUsers(users);
    }
}
