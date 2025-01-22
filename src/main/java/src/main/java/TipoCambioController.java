package src.main.java;

import src.main.java.TipoCambio;
import src.main.java.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {
    @Autowired
    private TipoCambioService tipoCambioService;

    @PostMapping("/calcular")
    public BigDecimal calcularCambio(@RequestParam String origen, @RequestParam String destino, @RequestParam BigDecimal monto) {
        return tipoCambioService.calcularCambio(origen, destino, monto);
    }

    @PostMapping
    public TipoCambio guardarTipoCambio(@RequestBody TipoCambio tipoCambio) {
        return tipoCambioService.guardarTipoCambio(tipoCambio);
    }

    @PutMapping("/{id}")
    public TipoCambio actualizarTipoCambio(@PathVariable Long id, @RequestBody TipoCambio tipoCambio) {
        return tipoCambioService.actualizarTipoCambio(id, tipoCambio);
    }
}
