package com.example.auditoria.usecase;

import com.example.auditoria.domain.port.HallazgoRepositoryPort;

public class CerrarHallazgoUseCase {
    private final HallazgoRepositoryPort repository;

    public CerrarHallazgoUseCase(HallazgoRepositoryPort repository) {
        this.repository = repository;
    }

    public void ejecutar(String id) {
        var hallazgo = repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Hallazgo no encontrado: " + id));
        hallazgo.cerrar();
        repository.guardar(hallazgo);
    }
}
