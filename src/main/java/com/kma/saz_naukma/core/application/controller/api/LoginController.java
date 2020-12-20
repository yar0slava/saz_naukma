package com.kma.saz_naukma.core.application.controller.api;

import com.kma.saz_naukma.config.util.JwtUtil;
import com.kma.saz_naukma.core.application.dto.LoginRequestDto;
import com.kma.saz_naukma.core.application.dto.LoginResponseDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    //    @PostMapping
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) throws Exception {
        authenticate(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDto.getEmail());
        final String token = jwtUtil.generateToken(userDetails);
        return new LoginResponseDto(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}