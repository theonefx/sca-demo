package com.example.demo.demos.provider.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demos.api.User;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@RestController("/feign")
public class FeignController {

	@Autowired
	private UserServiceFeigClient userServiceFeigClient;

	@RequestMapping("/users")
	@ResponseBody
	public List<User> getUser() {
		return userServiceFeigClient.listUsers();
	}

	@FeignClient("demo-provider")
	private interface UserServiceFeigClient {

		@GetMapping(path = "/listUsers", produces = MediaType.APPLICATION_JSON_VALUE)
		List<User> listUsers();
	}
}
