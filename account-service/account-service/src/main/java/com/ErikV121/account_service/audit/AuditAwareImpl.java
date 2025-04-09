package com.ErikV121.account_service.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // You can implement your logic to fetch the current auditor (user) here
        // For example, you might want to fetch it from the security context or session
        return Optional.of("ACCOUNTS_MS");
    }
}
