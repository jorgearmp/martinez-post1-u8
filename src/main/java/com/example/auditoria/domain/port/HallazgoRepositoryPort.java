package com.example.auditoria.domain.port;

import com.example.auditoria.domain.entity.HallazgoAuditoria;
import java.util.Optional;

public interface HallazgoRepositoryPort {
    void guardar(HallazgoAuditoria hallazgo);
    Optional<HallazgoAuditoria> buscarPorId(String id);
}
