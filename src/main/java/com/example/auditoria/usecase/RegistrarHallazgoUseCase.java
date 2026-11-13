package com.example.auditoria.usecase;

import com.example.auditoria.domain.entity.HallazgoAuditoria;
import com.example.auditoria.domain.port.HallazgoRepositoryPort;

public class RegistrarHallazgoUseCase {
    private final HallazgoRepositoryPort repository;

    public RegistrarHallazgoUseCase(HallazgoRepositoryPort repository) {
        this.repository = repository;
    }

    public HallazgoAuditoria ejecutar(String id, String descripcion, String criticidad) {
        var h = new HallazgoAuditoria(id, descripcion, criticidad);
        repository.guardar(h);
        return h;
    }
}
