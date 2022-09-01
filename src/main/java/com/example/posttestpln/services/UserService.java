package com.example.posttestpln.services;

import com.example.posttestpln.dto.UserDto;
import com.example.posttestpln.models.User;
import org.hibernate.sql.Update;

import java.util.List;

public interface UserService {
    public List<User> get();
    public User save(UserDto userDto);
    public User update(User user);
    public String delete(Integer id);
    public User getUser(Integer id);
}
