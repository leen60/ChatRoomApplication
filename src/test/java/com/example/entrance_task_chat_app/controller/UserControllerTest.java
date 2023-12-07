package com.example.entrance_task_chat_app.controller;

import com.example.entrance_task_chat_app.entity.Chat;
import com.example.entrance_task_chat_app.service.UserManagementService;
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
@WebMvcTest(UserController.class)
class UserControllerTest {
    @MockBean
    private UserManagementService userManagementService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void postMessageTest() throws Exception {
        String text = "test message";
        Chat chat = new Chat();
        chat.setBody(text);
        when(userManagementService.manageMessageWriting(any(String.class), any(Integer.class))).thenReturn(chat);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/user/writeMessage/{id}", 2)
                        .content(text)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }
}