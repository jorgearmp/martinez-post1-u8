package com.example.auditoria.adapter.controller;

import com.example.auditoria.domain.entity.HallazgoAuditoria;
import com.example.auditoria.usecase.CerrarHallazgoUseCase;
import com.example.auditoria.usecase.RegistrarHallazgoUseCase;

public class AuditoriaController {
    private final RegistrarHallazgoUseCase registrarUseCase;
    private final CerrarHallazgoUseCase cerrarUseCase;

    public AuditoriaController(RegistrarHallazgoUseCase registrarUseCase, CerrarHallazgoUseCase cerrarUseCase) {
        this.registrarUseCase = registrarUseCase;
        this.cerrarUseCase = cerrarUseCase;
    }

    public HallazgoAuditoria crearHallazgo(String id, String descripcion, String criticidad) {
        return registrarUseCase.ejecutar(id, descripcion, criticidad);
    }

    public void cerrarHallazgo(String id) {
        cerrarUseCase.ejecutar(id);
    }
}
