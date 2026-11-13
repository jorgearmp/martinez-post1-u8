package com.example.auditoria.adapter.persistence;

import com.example.auditoria.domain.entity.HallazgoAuditoria;
import com.example.auditoria.domain.port.HallazgoRepositoryPort;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryHallazgoAdapter implements HallazgoRepositoryPort {
    private final Map<String, HallazgoAuditoria> store = new ConcurrentHashMap<>();

    @Override
    public void guardar(HallazgoAuditoria hallazgo) {
        store.put(hallazgo.getId(), hallazgo);
    }

    @Override
    public Optional<HallazgoAuditoria> buscarPorId(String id) {
        return Optional.ofNullable(store.get(id));
    }
}
