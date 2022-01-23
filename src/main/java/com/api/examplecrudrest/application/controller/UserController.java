package com.api.examplecrudrest.application.controller;

import com.api.examplecrudrest.application.service.UserService;
import com.api.examplecrudrest.domain.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok().body("Created");
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String email) {
        UserDTO userDTO = userService.getUser(email);
        return ResponseEntity.ok().body(userDTO);
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable String email) {
        UserDTO response = userService.updateUser(userDTO, email);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.ok().body("Delete");
    }
}
