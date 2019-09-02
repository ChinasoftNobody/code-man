package com.chinasoft.lgh.codeman.service.config;

import com.chinasoft.lgh.codeman.service.model.MUser;
import com.chinasoft.lgh.codeman.service.util.TokenStore;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class IamAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        MUser user = TokenStore.currentUser.get();
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user.getId());
    }
}
