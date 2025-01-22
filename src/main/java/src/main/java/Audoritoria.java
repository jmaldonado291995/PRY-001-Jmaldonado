package src.main.java;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;
    private String operacion;
    private LocalDateTime fecha;

    // Getters y Setters
}
