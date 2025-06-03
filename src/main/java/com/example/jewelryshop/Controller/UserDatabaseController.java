package com.example.jewelryshop.Controller;

import com.example.jewelryshop.Dto.UserRequestDto;
import com.example.jewelryshop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserDatabaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/post")
    public ResponseEntity<?> postUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.post(userRequestDto));
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }
}
