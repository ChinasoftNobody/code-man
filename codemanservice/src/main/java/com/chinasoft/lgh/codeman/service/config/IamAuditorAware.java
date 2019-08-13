package com.chinasoft.lgh.codeman.service.config;

import com.chinasoft.lgh.iam.core.model.MUser;
import com.chinasoft.lgh.iam.core.util.TokenStore;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class IamAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        MUser user = TokenStore.currentUser.get();
        if (user == null){
            return Optional.empty();
        }
        return Optional.of(user.getId());
    }
}
