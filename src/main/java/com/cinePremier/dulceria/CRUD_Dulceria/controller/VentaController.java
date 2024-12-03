package com.cinePremier.dulceria.CRUD_Dulceria.controller;

import com.cinePremier.dulceria.CRUD_Dulceria.model.Venta;
import com.cinePremier.dulceria.CRUD_Dulceria.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "http://localhost:8080https://cinemapremier-venta-fxfrcegeb3b6gdb5.mexicocentral-01.azurewebsites.net") // Habilita CORS para todo el controlador
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // Listar todas las ventas
    @GetMapping
    public ResponseEntity<List<Venta>> listarVentas() {
        List<Venta> ventas = ventaService.listarTodas();
        return ResponseEntity.ok(ventas);
    }

    // Obtener una venta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Long id) {
        Venta venta = ventaService.obtenerPorId(id);
        if (venta != null) {
            return ResponseEntity.ok(venta);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear o registrar una nueva venta
    @PostMapping("/nuevo")
    public ResponseEntity<String> registrarVenta(@RequestBody Venta venta) {
        try {
            // Guardar la venta en la base de datos
            ventaService.guardar(venta);
            return ResponseEntity.ok("Venta registrada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar la venta: " + e.getMessage());
        }
    }

    // Editar una venta existente
    @PutMapping("/{id}")
    public ResponseEntity<String> editarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        Venta ventaExistente = ventaService.obtenerPorId(id);
        if (ventaExistente != null) {
            // Actualizar los campos de la venta
            ventaExistente.setCliente(venta.getCliente());
            ventaExistente.setProductos(venta.getProductos());
            ventaExistente.setTotal(venta.getTotal());
            // Guardar la venta actualizada
            ventaService.guardar(ventaExistente);
            return ResponseEntity.ok("Venta actualizada correctamente");
        }
        return null;
    }

    // Eliminar una venta por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVenta(@PathVariable Long id) {
        Venta venta = ventaService.obtenerPorId(id);
        if (venta != null) {
            ventaService.eliminar(id);
            return ResponseEntity.ok("Venta eliminada correctamente");
        }
        return null;
    }
}
