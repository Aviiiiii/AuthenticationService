package com.avi.authenticationservice.Controller;

import com.avi.authenticationservice.Dto.Response;
import com.avi.authenticationservice.Dto.UserResult;
import com.avi.authenticationservice.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final  UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Operation(
            summary = "Get all users",
            description = "Retrieve a list of all users",
            operationId = "getAllUsers",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation",
                            content = @Content(schema = @Schema(implementation = UserResult.class))),
                    @ApiResponse(responseCode = "405", description = "Invalid Input")
            }
    )
    @GetMapping(produces = "application/json")

    public ResponseEntity<List<UserResult>> getAllUsers() {
        List<UserResult> result = userService.getAllUsers();
        Response<List<UserResult>> response = new Response<>(HttpStatus.OK.value(), "Success",result);
        return ResponseEntity.ok(result);
    }

}
