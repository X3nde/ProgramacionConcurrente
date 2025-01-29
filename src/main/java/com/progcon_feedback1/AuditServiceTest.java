package com.progcon_feedback1;

import com.progcon_feedback1.service.AuditService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuditServiceTests {

    @Autowired
    private AuditService auditService;

    @Test
    public void testAuditLog() {
        auditService.log("Test audit log");

        // Aquí podrías verificar manualmente la base de datos para validar la auditoría.



        assertThat(true).isTrue(); // Placeholder para un test más robusto.
    }
}
