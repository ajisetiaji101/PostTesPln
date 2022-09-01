package com.example.posttestpln.services.Impl;

import com.example.posttestpln.dto.UserDto;
import com.example.posttestpln.models.User;
import com.example.posttestpln.repository.UserRepository;
import com.example.posttestpln.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> get() {

        List<User> user = userRepository.findAll();

        if(user != null){
            return user;
        }
        return null;
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setIsActive(false);

        User user1 = userRepository.save(user);

        return user1;
    }

    @Override
    public User update(User user) {
        User user1 = new User();

        user1.setId(user.getId());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setIsActive(user.getIsActive());

        User user2 = userRepository.save(user1);

        return  user2;
    }

    @Override
    public String delete(Integer id) {

        User user = userRepository.findById(id).get();

        if(user != null){
            userRepository.delete(user);
        }else{
            return "Data tidak ditemukan";
        }

        return "Data berhasil dihapus";
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository.findById(id).get();

        if(user != null){
            return user;
        }else {
            return null;
        }
    }
}
