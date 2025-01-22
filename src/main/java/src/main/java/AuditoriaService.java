package src.main.java;

import src.main.java.Auditoria;
import src.main.java.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditoriaService {
    @Autowired
    private AuditoriaRepository repository;

    public void registrarOperacion(String usuario, String operacion) {
        Auditoria auditoria = new Auditoria();
        auditoria.setUsuario(usuario);
        auditoria.setOperacion(operacion);
        auditoria.setFecha(LocalDateTime.now());
        repository.save(auditoria);
    }
}
