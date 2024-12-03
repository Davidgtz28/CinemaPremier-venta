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
        // Si la venta tiene un ID, actualizamos la venta existente
        if (venta.getId() != null) {
            Venta ventaExistente = ventaService.obtenerPorId(venta.getId());
            if (ventaExistente != null) {
                // Actualizamos los campos de la venta
                ventaExistente.setCliente(venta.getCliente());
                ventaExistente.setProductos(venta.getProductos());
                ventaExistente.setTotal(venta.getTotal());
                // Guardamos los cambios de la venta
                ventaService.guardar(ventaExistente);
            }
        } else {
            // Si no tiene ID, es una nueva venta, la creamos
            ventaService.guardar(venta);
        }
    }

    // Editar una venta
    @PutMapping("/{id}")
    public void editarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        Venta ventaExistente = ventaService.obtenerPorId(id);
        if (ventaExistente != null) {
            // Actualizamos los campos de la venta
            ventaExistente.setCliente(venta.getCliente());
            ventaExistente.setProductos(venta.getProductos());
            ventaExistente.setTotal(venta.getTotal());
            // Guardamos los cambios de la venta
            ventaService.guardar(ventaExistente);
        }
    }

    // Eliminar una venta
    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Long id) {
        ventaService.eliminar(id);
    }
}
