package com.example.entrance_task_chat_app.controller;

import com.example.entrance_task_chat_app.entity.Admin;
import com.example.entrance_task_chat_app.repository.AdminRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/admins")
    Iterable<Admin> all() {
        return adminRepository.findAll().orElseThrow();
    }

    @PostMapping("/addAdmin")
    Admin newAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public boolean deleteUserFromChatRoom(@PathVariable int id) {
        adminRepository.deleteById(id);
        return true;
    }
}
