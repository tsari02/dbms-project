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
    @Size(min=1, max=255, message="Length of username must be between 1 and 255 characters")
    @NotBlank(message="Username cannot be blank")
    private String username = null;
    @NotEmpty(message="Password cannot be empty")
    @Size(min = 8, max=255, message="Password must have at least 8 characters")
    private String password = null;
    @Size(min=1, max=25, message="Length of First Name must be between 1 and 25 characters")
    @NotBlank(message = "First name is mandatory")
    private String firstName = null;
    @Size(min=0, max=50, message="Length of Middle Name must be between 0 and 50 characters")
    private String middleName;
    @Size(min=0, max=25, message="Length of Last Name must be between 0 and 25 characters")
    private String lastName;
    @NotBlank(message="Designation cannot be blank")
    private String designation; 
    @NotNull(message="Salary cannot be empty")
    @Min(value = 0, message = "Salary must be positive")
    private int salary;
    @Size(min=1, max=20, message="Length of Contact Number must be between 1 and 20 characters")
    @NotBlank(message="Contact number cannot be blank")
    private String contactNumber;
    @NotNull(message = "Date cannot be empty")
    private java.sql.Date dateOfBirth;
    @Size(min=1, max=255, message="Length of Email Address must be between 1 and 255 characters")
    @NotBlank(message="Email id cannot be blank")
    @Email(message="Email id must be valid")
    private String emailId;
    @Size(min=1, max=50, message="Length of City must be between 1 and 50 characters")
    @NotBlank(message = "City cannot be blank")
    private String city;
    @Size(min=1, max=50, message="Length of State must be between 1 and 50 characters")
    @NotBlank(message = "State cannot be blank")
    private String state;
    @Size(min=1, max=10, message="Length of Postal Code must be between 1 and 10 characters")
    @NotBlank(message = "Postal code cannot be blank")
    private String postalCode;
    @Size(min=1, max=50, message="Length of Country must be between 1 and 50 characters")
    @NotBlank(message = "Country cannot be blank")
    private String country;
    @Size(min=1, max=50, message="Length of Street Address must be between 1 and 50 characters")
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
