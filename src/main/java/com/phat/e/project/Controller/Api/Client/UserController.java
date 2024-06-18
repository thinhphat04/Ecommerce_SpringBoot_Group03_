package com.phat.e.project.Controller.Api.Client;

import com.phat.e.project.Entity.User;
import com.phat.e.project.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
     private IUserService userService;

        @Autowired
        public UserController(IUserService userService) {
            this.userService = userService;
        }

     @GetMapping
     public List<User> getAllUsers() {
         return userService.getAllUsers();
     }


}