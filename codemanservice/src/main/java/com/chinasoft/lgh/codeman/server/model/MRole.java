package com.chinasoft.lgh.codeman.server.model;

import com.chinasoft.lgh.codeman.server.config.auth.RoleEnum;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class MRole implements GrantedAuthority {

    private RoleEnum role;

    public MRole(RoleEnum role) {
        this.role = role;
    }

    public MRole() {
        this(RoleEnum.GUEST);
    }

    @Override
    public String getAuthority() {
        return this.role.name();
    }
}
