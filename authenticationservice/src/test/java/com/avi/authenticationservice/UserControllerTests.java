package com.avi.authenticationservice;

import com.avi.authenticationservice.Controller.UserController;
import com.avi.authenticationservice.Dto.UserResult;
import com.avi.authenticationservice.Entities.User;
import com.avi.authenticationservice.Service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService mockUserService;

    @Test
    public void testGetAllUsers() throws Exception {
        // Mocking the service layer to return expected data
        UserResult user1 = new UserResult();
        user1.setId(1);
        user1.setUserId(1);
        user1.setName("John Doe");
        user1.setEmail("john.doe@example.com");

        UserResult user2 = new UserResult();
        user2.setId(2);
        user2.setUserId(2);
        user2.setName("Jane Smith");
        user2.setEmail("jane.smith@example.com");

        when(mockUserService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

      mockMvc.perform(get("/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$[0].id").value(1))
              .andExpect(jsonPath("$[0].userId").value(1))
              .andExpect(jsonPath("$[0].name").value("John Doe"))
              .andExpect(jsonPath("$[0].email").value("john.doe@example.com"));
    }

}
