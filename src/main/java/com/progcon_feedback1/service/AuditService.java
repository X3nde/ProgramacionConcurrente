package com.progcon_feedback1.service;

import com.progcon_feedback1.model.AuditLog;
import com.progcon_feedback1.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void log(String message) {
        AuditLog log = new AuditLog();
        log.setMessage(message);
        auditLogRepository.save(log);
    }
}
