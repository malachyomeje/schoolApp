package com.School.auth;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AuthenticationRequest {
    private  String email;
    private String password;

}
