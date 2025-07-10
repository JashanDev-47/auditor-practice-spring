package com.example.auditor.auditaware;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class CustomAuditAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Jashan Preet Singh");
    }
}
