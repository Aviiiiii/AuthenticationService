package com.avi.authenticationservice.Service;

import com.avi.authenticationservice.Dto.UserResult;
import com.avi.authenticationservice.Entities.User;
import com.avi.authenticationservice.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserResult> getAllUsers() {

        List<UserResult> userList = userRepository.findAll().stream()
                .map(user -> {
                    UserResult userResult = new UserResult();
                    userResult.setId(user.getId());
                    userResult.setName(user.getName());
                    userResult.setEmail(user.getEmail());
                    userResult.setUserId(user.getUserId());
                    return userResult;
                }).collect(Collectors.toList());

        return userList;
    }
}
