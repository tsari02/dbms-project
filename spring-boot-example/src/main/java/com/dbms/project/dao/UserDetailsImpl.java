package com.dbms.project.dao;

import com.dbms.project.model.Employee;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(int id, String username, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Employee employee) {
        String designation = employee.getDesignation();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (designation == "Employee") {
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        } else if (designation == "Manager") {
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        } else if (designation == "Admin") {
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return new UserDetailsImpl(
                employee.getId(),
                employee.getUsername(),
                employee.getPassword(),
                authorities);
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
