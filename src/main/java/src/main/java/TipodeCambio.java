package src.main.java;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String monedaOrigen;

    @Column(nullable = false)
    private String monedaDestino;

    @Column(nullable = false)
    private BigDecimal tipoCambio;

    // Getters y Setters
}
