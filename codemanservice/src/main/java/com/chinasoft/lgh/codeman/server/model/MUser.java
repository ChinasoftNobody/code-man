package com.chinasoft.lgh.codeman.server.model;

import com.chinasoft.lgh.codeman.server.pojo.UserType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@Document(collection = "users")
public class MUser extends MBaseModel implements UserDetails {

    private String username;
    private String password;
    private String email;
    private String phone;
    private UserType type;

    private Collection<MRole> roles;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;


    public MUser() {
    }

    public MUser(String username, String password, Collection<MRole> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    public MUser(String username, String password) {
        this(username, password, Collections.singleton(new MRole()));
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }
}
