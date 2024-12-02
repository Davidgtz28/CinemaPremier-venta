/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinePremier.dulceria.CRUD_Dulceria.services;

import com.cinePremier.dulceria.CRUD_Dulceria.model.Venta;
import com.cinePremier.dulceria.CRUD_Dulceria.repository.VentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jezuz
 */
@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;
    
    public List<Venta> listarTodas(){
        return ventaRepository.findAll(); 
    }
    public void guardar(Venta venta) {
    ventaRepository.save(venta); // JPA manejará la actualización si el ID ya existe
}

    public Venta obtenerPorId(Long id){
        return ventaRepository.findById(id).orElse(null);
    }
    public void eliminar(Long id){
        ventaRepository.deleteById(id);
    }
    
}
