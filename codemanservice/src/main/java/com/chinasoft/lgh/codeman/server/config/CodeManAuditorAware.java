package com.chinasoft.lgh.codeman.server.config;

import com.chinasoft.lgh.codeman.server.model.MUser;
import com.chinasoft.lgh.codeman.server.util.TokenStore;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class CodeManAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        MUser user = TokenStore.currentUser.get();
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user.getId());
    }
}
