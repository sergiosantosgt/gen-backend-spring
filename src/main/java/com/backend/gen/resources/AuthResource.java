package com.backend.gen.resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.backend.gen.dto.EmailDTO;
import com.backend.gen.security.JWTUtil;
import com.backend.gen.security.UserSS;
import com.backend.gen.services.SmtpEmailService;
import com.backend.gen.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.gen.services.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	private static final Logger logger = LoggerFactory.getLogger(AuthResource.class);

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthService service;
	
	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
		service.sendNewPassword(objDto.getEmail());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/logout", method = RequestMethod.DELETE)
	public ResponseEntity getLogoutPage(HttpServletRequest request, HttpServletResponse response){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		logger.info("auth ** : " + authentication.toString());
		try {
			if (authentication != null) {
				new SecurityContextLogoutHandler().logout(request, response, authentication);
				authentication.setAuthenticated(false);
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
