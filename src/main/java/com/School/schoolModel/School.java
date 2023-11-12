package com.School.schoolModel;

import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.enums.Sex;
import com.School.enums.UsersRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class School implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long Id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
    private String registrationNo;
    private String age;
    private String address;
    private String state;
    private String nameOfParent;
    private String parentPhoneNo;
    private String parentAddress;
    @Enumerated(value = EnumType.STRING)
    private Sex sex;
    @Enumerated(value = EnumType.STRING)
    private Department department;
    @Enumerated(value = EnumType.STRING)
    private Faculty faculty;
    @Enumerated(value=EnumType.STRING)
    private UsersRole role;
    @CreationTimestamp
    private Date date;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
