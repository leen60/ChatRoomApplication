package com.example.entrance_task_chat_app.controller;

import com.example.entrance_task_chat_app.entity.User;
import com.example.entrance_task_chat_app.projection.Statistics;
import com.example.entrance_task_chat_app.service.AdminManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final AdminManagementService adminManagementService;

    public AdminController(AdminManagementService adminManagementService) {
        this.adminManagementService = adminManagementService;
    }

    @DeleteMapping("/deleteUser/{id}")
    ResponseEntity<?> deleteUserFromChatRoom(@PathVariable int id) {
        try {
            adminManagementService.manageUserDeletion(id);
        } catch (Exception notFound) {
            return new ResponseEntity<>(notFound.getMessage(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Deleted successfully, all messages will be marked as from anonymous sender", HttpStatus.OK);
    }
    @PostMapping("/addUser")
    ResponseEntity<?> newUser(@RequestBody String name) {
        User newUser;
        try {
            newUser = adminManagementService.manageUserCreation(name);
        } catch (Exception notFound) {
            return new ResponseEntity<>(notFound.getMessage(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @GetMapping("/stats/{id}")
    ResponseEntity<?> stats(@PathVariable int id) {
        Statistics stats;
        try {
            stats = adminManagementService.manageUserStatistics(id);
        } catch (Exception notFound) {
            return new ResponseEntity<>(notFound.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }
}
