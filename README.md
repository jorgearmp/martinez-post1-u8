# ACTIVIDAD POST-CONTENIDO — UNIDAD 8
## CLEAN ARCHITECTURE Y ANÁLISIS COSTO-BENEFICIO DE CQRS/EVENT SOURCING
**Estudiante:** Jorge Armando Martínez Peinado (Cód. 1152162)  
**Curso:** Patrones de Diseño de Software (1156701-A)  
**Institución:** Universidad Francisco de Paula Santander (UFPS)  

---

## 1. IMPLEMENTACIÓN DE LOS CÍRCULOS DE CLEAN ARCHITECTURE
1. **Entidades (Dominio Puro):** `HallazgoAuditoria` implementa una máquina de estados con transiciones estrictas (ABIERTO -> EN_REMEDIACION -> CERRADO) libre de cualquier framework.
2. **Casos de Uso (Aplicación):** `RegistrarHallazgoUseCase` y `CerrarHallazgoUseCase` orquestan la lógica interactuando con el puerto abstracto `HallazgoRepositoryPort`.
3. **Adaptadores de Interfaz:** `InMemoryHallazgoAdapter` y `AuditoriaController` canalizan los datos hacia los casos de uso.

---

## 2. INSTRUCCIONES DE EJECUCIÓN
```bash
mvn clean compile
mvn exec:java
```
