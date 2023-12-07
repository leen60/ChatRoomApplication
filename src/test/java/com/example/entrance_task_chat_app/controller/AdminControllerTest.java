package com.example.entrance_task_chat_app.controller;
import com.example.entrance_task_chat_app.entity.User;
import com.example.entrance_task_chat_app.service.AdminManagementService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
class AdminControllerTest {
    @MockBean
    private AdminManagementService adminManagementService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void newUserTest() throws Exception {
        String name = "TestName";
        User user = new User();
        user.setName(name);
        when(adminManagementService.manageUserCreation(any(String.class))).thenReturn(user);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/admin/addUser")
                        .content(name)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL_VALUE))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void deleteUserFromChatRoomTest() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders.delete("/api/admin/deleteUser/{id}", 1) )
                .andExpect(status().isAccepted());
    }
}