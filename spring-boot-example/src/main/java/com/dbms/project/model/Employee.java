package com.dbms.project.model;


import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import javax.validation.constraints.*;

@Data
public class Employee implements UserDetails {
    private static final long serialVersionUID = 1L;
    private int id;
    @NotBlank(message="Username cannot be blank")
    private String username = null;
    @NotEmpty(message="Password cannot be empty")
    @Size(min = 8, message="Password must have atleast 8 characters")
    private String password = null;
    @NotBlank(message = "First name is mandatory")
    private String firstName = null;
    private String middleName;
    private String lastName;
    @NotBlank(message="Designation cannot be blank")
    private String designation; 
    @NotNull(message="Salary cannot be empty")
    @Min(value = 0, message = "Salary must be positive")
    private int salary;
    @NotBlank(message="Contact number cannot be blank")
    private String contactNumber;
    @NotNull(message = "Date cannot be empty")
    private java.sql.Date dateOfBirth;
    @NotBlank(message="Email id cannot be blank")
    @Email(message="Email id must be valid")
    private String emailId;
    @NotBlank(message = "City cannot be blank")
    private String city;
    @NotBlank(message = "State cannot be blank")
    private String state;
    @NotBlank(message = "Postal code cannot be blank")
    private String postalCode;
    @NotBlank(message = "Country cannot be blank")
    private String country;
    @NotBlank(message = "Street address cannot be blank")
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
