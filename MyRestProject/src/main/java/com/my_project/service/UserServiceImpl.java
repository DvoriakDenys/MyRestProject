package com.my_project.service;

import com.my_project.dto.UserDto;
import com.my_project.entity.User;
import com.my_project.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDto userDto) {
        return userRepository.save(builderUser(userDto));
    }

    public User updateUser(UserDto userDto) {
        return userRepository.save(builderUser(userDto));
    }

    public void deleteUser(UserDto userDto) {
        userRepository.delete(builderUser(userDto));
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public User builderUser(UserDto userDto){
        return User.builder()
                .age(userDto.getAge())
                .id(userDto.getId())
                .name(userDto.getName())
                .build();
    }
}
