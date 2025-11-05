package org.e_Banking.service;

import java.time.Duration;

import org.e_Banking.dto.UserDto;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisService {

	private final RedisTemplate<String, Object> redisTemplate;

	public void saveUserDto(UserDto dto) {
		redisTemplate.opsForValue().set("dto:" + dto.getEmail(), dto, Duration.ofSeconds(40));
	}

	public void saveUserOtp(String email, int otp) {
		redisTemplate.opsForValue().set("otp:" + email, otp, Duration.ofSeconds(22));
	}

	public int fetchOtp(String email) {
		Object otp = redisTemplate.opsForValue().get("otp:" + email);
		if (otp != null)
			return (int) otp;
		else
			return 0;
	}

	public UserDto fetchUserDto(String email) {
		return (UserDto) redisTemplate.opsForValue().get("dto:" + email);
	}

	public void deleteUserDto(String email) {
		redisTemplate.delete("dto:" + email);
	}

	public void deleteUserOtp(String email) {
		redisTemplate.delete("otp:" + email);
	}

}