package com.cinePremier.dulceria.CRUD_Dulceria.controller;

import com.cinePremier.dulceria.CRUD_Dulceria.model.Venta;
import com.cinePremier.dulceria.CRUD_Dulceria.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "https://cinemapremier-venta-fxfrcegeb3b6gdb5.mexicocentral-01.azurewebsites.net/")  // Habilita CORS solo para este controlador
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // Listar todas las ventas
    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarTodas();
    }

    // Obtener una venta por su ID
    @GetMapping("/{id}")
    public Venta obtenerVentaPorId(@PathVariable Long id) {
        return ventaService.obtenerPorId(id);
    }

    // Crear o actualizar una venta
    @PostMapping
    public void guardarVenta(@RequestBody Venta venta) {
        if (venta.getId() != null) {
            Venta ventaExistente = ventaService.obtenerPorId(venta.getId());
            if (ventaExistente != null) {
                ventaExistente.setCliente(venta.getCliente());
                ventaExistente.setProductos(venta.getProductos());
                ventaExistente.setTotal(venta.getTotal());
            }
        }
    }

    // Editar una venta (por simplicidad, usa el mismo método POST/PUT)
    @PutMapping("/{id}")
    public void editarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        Venta ventaExistente = ventaService.obtenerPorId(id);
        if (ventaExistente != null) {
            ventaExistente.setCliente(venta.getCliente());
            ventaExistente.setProductos(venta.getProductos());
            ventaExistente.setTotal(venta.getTotal());
        }
    }

    // Eliminar una venta
    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Long id) {
        ventaService.eliminar(id);
    }
}
