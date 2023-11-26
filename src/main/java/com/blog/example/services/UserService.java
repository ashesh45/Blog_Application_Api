package com.blog.example.services;

import java.util.List;



import com.blog.example.payloads.UserDto;


public interface UserService {
	
	 UserDto createUser(UserDto user);
	 UserDto updateUser(UserDto userDto,Integer userId);
	 UserDto getUserbyId(Integer userId);
	 List<UserDto> getAllUsers();
	 void deleteUser(Integer userId);

}
