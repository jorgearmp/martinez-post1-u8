package com.example.auditoria.domain.entity;

public class HallazgoAuditoria {
    private final String id;
    private final String descripcion;
    private final String criticidad; // ALTA, MEDIA, BAJA
    private EstadoHallazgo estado;
    private String planAccion;

    public HallazgoAuditoria(String id, String descripcion, String criticidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.criticidad = criticidad;
        this.estado = EstadoHallazgo.ABIERTO;
        this.planAccion = "";
    }

    public String getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public String getCriticidad() { return criticidad; }
    public EstadoHallazgo getEstado() { return estado; }
    public String getPlanAccion() { return planAccion; }

    // Transiciones estrictas de la máquina de estados
    public void iniciarRemediacion(String plan) {
        if (estado != EstadoHallazgo.ABIERTO && estado != EstadoHallazgo.REABIERTO) {
            throw new IllegalStateException("Solo un hallazgo ABIERTO o REABIERTO puede entrar en remediación.");
        }
        if (plan == null || plan.isBlank()) {
            throw new IllegalArgumentException("Debe especificarse un plan de acción para iniciar remediación.");
        }
        this.planAccion = plan;
        this.estado = EstadoHallazgo.EN_REMEDIACION;
    }

    public void cerrar() {
        if (estado != EstadoHallazgo.EN_REMEDIACION) {
            throw new IllegalStateException("Transición inválida: No se puede cerrar un hallazgo que no esté EN_REMEDIACION.");
        }
        this.estado = EstadoHallazgo.CERRADO;
    }

    public void reabrir(String motivo) {
        if (estado != EstadoHallazgo.CERRADO) {
            throw new IllegalStateException("Solo un hallazgo previamente CERRADO puede ser reabierto.");
        }
        this.estado = EstadoHallazgo.REABIERTO;
    }
}
