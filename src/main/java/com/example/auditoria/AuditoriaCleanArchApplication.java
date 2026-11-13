package com.example.auditoria;

import com.example.auditoria.adapter.controller.AuditoriaController;
import com.example.auditoria.adapter.persistence.InMemoryHallazgoAdapter;
import com.example.auditoria.domain.entity.HallazgoAuditoria;
import com.example.auditoria.usecase.CerrarHallazgoUseCase;
import com.example.auditoria.usecase.RegistrarHallazgoUseCase;

public class AuditoriaCleanArchApplication {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" CLEAN ARCHITECTURE EN AUDITORÍA INTERNA - UNIDAD 8 (UFPS)");
        System.out.println(" Estudiante: Jorge Martínez");
        System.out.println("==================================================================");

        // Cableado de Clean Architecture (Inversión de dependencias hacia el centro)
        var repoAdapter = new InMemoryHallazgoAdapter();
        var registrarUseCase = new RegistrarHallazgoUseCase(repoAdapter);
        var cerrarUseCase = new CerrarHallazgoUseCase(repoAdapter);
        var controller = new AuditoriaController(registrarUseCase, cerrarUseCase);

        // 1. Crear hallazgo
        HallazgoAuditoria h1 = controller.crearHallazgo("AUD-2026-01", "Fuga potencial de claves en logs de producción", "ALTA");
        System.out.printf("Hallazgo creado: %s - Estado inicial: %s%n", h1.getId(), h1.getEstado());

        // 2. Intentar cerrar directamente (Debe fallar por regla de la máquina de estados)
        System.out.println("Intentando cerrar directamente sin remediación previa...");
        try {
            controller.cerrarHallazgo(h1.getId());
        } catch (IllegalStateException ex) {
            System.out.println("  [BLOQUEO EXITOSO POR DOMINIO]: " + ex.getMessage());
        }

        // 3. Flujo válido: Remediación -> Cierre
        h1.iniciarRemediacion("Implementar máscara criptográfica en filtros de Logback.");
        System.out.printf("Estado actualizado: %s (Plan: %s)%n", h1.getEstado(), h1.getPlanAccion());

        controller.cerrarHallazgo(h1.getId());
        System.out.printf("Estado final tras remediación: %s%n", h1.getEstado());

        System.out.println("Demostración de Clean Architecture finalizada con éxito.");
    }
}
