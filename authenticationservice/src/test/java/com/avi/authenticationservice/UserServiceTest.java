package com.avi.authenticationservice;
import com.avi.authenticationservice.Controller.UserController;
import com.avi.authenticationservice.Dto.UserResult;
import com.avi.authenticationservice.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class UserServiceTest{
    @Autowired
    private MockMvc mockMvc;
}
