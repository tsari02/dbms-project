package com.dbms.project.model;


import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Employee implements UserDetails {
    private static final long serialVersionUID = 1L;
    private int id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank
    private String designation; 
    @NotNull
    @Min(0)
    private int salary;
    @NotBlank
    private String contactNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private java.sql.Date dateOfBirth;
    @NotBlank
    @Email
    private String emailId;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String country;
    @NotBlank
    private String street;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String designation = getDesignation();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (Objects.equals(designation, "Employee")) {
            authorities.add(new SimpleGrantedAuthority("EMPLOYEE"));
        } else if (Objects.equals(designation, "Manager")) {
            authorities.add(new SimpleGrantedAuthority("EMPLOYEE"));
            authorities.add(new SimpleGrantedAuthority("MANAGER"));
        } else if (Objects.equals(designation, "Admin")) {
            authorities.add(new SimpleGrantedAuthority("EMPLOYEE"));
            authorities.add(new SimpleGrantedAuthority("MANAGER"));
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }
        return authorities;
    }

    public boolean hasRole(String role) {
        return getAuthorities().contains(new SimpleGrantedAuthority(role));
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
