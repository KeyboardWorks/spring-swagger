package keyboard.works.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import keyboard.works.request.UserRequest;
import keyboard.works.response.UserResponse;

@RestController
@RequestMapping(
	path = "/users",
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {

	@GetMapping
	public List<UserResponse> getUsers() {
		
		UserResponse userResponse = new UserResponse();
		userResponse.setName("User Name");
		userResponse.setUsername("username");
		
		return List.of(userResponse);
	}
	
	@GetMapping(path = "{id}")
	public UserResponse getUser(@PathVariable("id")String id) {
		
		UserResponse userResponse = new UserResponse();
		userResponse.setName("User Name");
		userResponse.setUsername("username");
		
		return userResponse;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(userRequest, userResponse);
		
		return userResponse;
	}
	
	@PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updateUser(@PathVariable("id") String id, @RequestBody UserRequest userRequest) {
		
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(userRequest, userResponse);
		
		return userResponse;
	}
	
	@DeleteMapping(path = "{id}")
	public UserResponse deleteUser(@PathVariable("id") String id) {
		
		return new UserResponse();
	}
	
}
