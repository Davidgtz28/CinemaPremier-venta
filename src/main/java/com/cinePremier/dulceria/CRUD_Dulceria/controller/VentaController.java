/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinePremier.dulceria.CRUD_Dulceria.controller;

import com.cinePremier.dulceria.CRUD_Dulceria.model.Venta;
import com.cinePremier.dulceria.CRUD_Dulceria.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jezuz
 */
@Controller
@RequestMapping("/ventas")
public class VentaController {

@Autowired
private VentaService ventaService;

@GetMapping
public String listarPersonas(Model model) {
model.addAttribute("ventas", ventaService.listarTodas() );
return "venta-list";

}

@GetMapping("/nuevo")
public String mostrarFormularioNuevaVenta(Model model) {
model.addAttribute("venta", new Venta());
return "venta-form";

}

@PostMapping
public String guardarVenta(Venta venta) {
    if (venta.getId() != null) {
        // Si el ID no es nulo, actualizamos la venta existente
        Venta ventaExistente = ventaService.obtenerPorId(venta.getId());
        if (ventaExistente != null) {
            ventaExistente.setCliente(venta.getCliente());
            ventaExistente.setProductos(venta.getProductos());
            ventaExistente.setTotal(venta.getTotal());
            ventaService.guardar(ventaExistente);
        }
    } else {
        // Si el ID es nulo, creamos una nueva venta
        ventaService.guardar(venta);
    }
    return "redirect:/ventas";
}




@GetMapping("/editar/{id}")
public String mostrarFormularioEditarVenta(@PathVariable Long id, Model model) {
model.addAttribute("venta", ventaService.obtenerPorId(id));
return "venta-form";

}

@GetMapping("/eliminar/{id}")
public String eliminarVenta(@PathVariable Long id) {
ventaService.eliminar(id);
return "redirect:/ventas";
}
}


