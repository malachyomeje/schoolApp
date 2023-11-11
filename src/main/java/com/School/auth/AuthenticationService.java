package com.School.auth;

import com.School.config.JwtService;
import com.School.dto.response.BaseResponse;
import com.School.repository.SchoolRepository;
import com.School.schoolModel.School;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AuthenticationService {




    private final SchoolRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public BaseResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            // Authentication failed, return "wrong password" response
            return new BaseResponse<>("Wrong password  or email");
        }

        Optional<School> school = repository.findByEmail(request.getEmail());
        if (school.isEmpty()) {
            return new BaseResponse<>("user not found", school);
        }
        School school1 = school.get();
        var jwtToken = jwtService.generateToken(school1);
        return new BaseResponse<>("Successful", jwtToken);

    }
}


