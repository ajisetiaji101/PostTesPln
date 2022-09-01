package com.example.posttestpln.controllers;

import com.example.posttestpln.dto.ResponDto;
import com.example.posttestpln.dto.UserDto;
import com.example.posttestpln.models.User;
import com.example.posttestpln.repository.UserRepository;
import com.example.posttestpln.services.UserService;
import com.example.posttestpln.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ResponDto<List<User>>> getAllUser(){
        try {
            List<User> user = userService.get();

            ResponDto responDto = ResponseUtil.responDtoSucces(user,"Get data all user success");

            return new ResponseEntity<>(responDto, HttpStatus.OK);
        }catch (Exception e){
            ResponDto responDto = ResponseUtil.responseDtoFailed(null, "Cannot get all user");

            return new ResponseEntity<>(responDto, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<ResponDto<User>> create(@RequestBody UserDto userDto){
        try{
            User user = userService.save(userDto);

            ResponDto responDto = ResponseUtil.responDtoSucces(user, "Create new user successfully");

            return new ResponseEntity<>(responDto, HttpStatus.OK);
        }catch (Exception e){
            ResponDto responDto = ResponseUtil.responseDtoFailed(null, "Create new user failed");

            return new ResponseEntity<>(responDto, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<ResponDto<User>> update(@RequestBody User user){
        try{
            User user1 = userService.update(user);

            ResponDto responDto = ResponseUtil.responDtoSucces(user1, "Create new user successfully");

            return new ResponseEntity<>(responDto, HttpStatus.OK);
        }catch (Exception e){
            ResponDto responDto = ResponseUtil.responseDtoFailed(null, "Create new user failed");

            return new ResponseEntity<>(responDto, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponDto<String>> delete(@PathVariable("id") Integer id){
        try{
            String user = userService.delete(id);

            ResponDto responDto = ResponseUtil.responDtoSucces(user, "delete user successfully");

            return new ResponseEntity<>(responDto, HttpStatus.OK);
        }catch (Exception e){
            ResponDto responDto = ResponseUtil.responseDtoFailed(null, "Delete user failed");

            return new ResponseEntity<>(responDto, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponDto<User>> getUser(@PathVariable("id") Integer id){
        try {
            User user = userService.getUser(id);

            ResponDto responDto = ResponseUtil.responDtoSucces(user,"Get data user success");

            return new ResponseEntity<>(responDto, HttpStatus.OK);
        }catch (Exception e){
            ResponDto responDto = ResponseUtil.responseDtoFailed(null, "Get data user not found");

            return new ResponseEntity<>(responDto, HttpStatus.BAD_REQUEST);
        }
    }
}
