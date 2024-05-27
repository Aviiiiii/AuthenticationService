package com.avi.authenticationservice.Service;

import com.avi.authenticationservice.Dto.UserResult;
import com.avi.authenticationservice.Entities.User;
import com.avi.authenticationservice.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserResult> getAllUsers() {

        List<UserResult> userList = null;
        List<User> users = userRepository.findAll();

        for ( UserResult userDto :userList){
            userDto =new UserResult();
            userDto.getEmail();
            userDto.getId();
            userDto.getName();
            userDto.getUserId();
            userList.add(userDto);
        }
        return userList;
    }
}
