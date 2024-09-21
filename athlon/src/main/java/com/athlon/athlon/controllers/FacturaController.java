package com.athlon.athlon.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.athlon.athlon.models.Factura;
import com.athlon.athlon.repositories.FacturaRepositorie;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {

    @Autowired
    private FacturaRepositorie facturaRepositorie;

     /*Obtener todos las facturas */
    @GetMapping
    public List <Factura> obtener_todas_facturas() {
        return facturaRepositorie.findAll();
    }

    /*Obtener facturas por medio de la ID */
    @GetMapping ("/{facturaID}")
    public Factura obtener_factura_id(@PathVariable("facturaID") Long facturaID) {
        return facturaRepositorie.findById(facturaID).orElse(null);
    }

    /*Crear una factura  */
    @PostMapping()
    public Factura crear_factura(@RequestBody Factura factura) {
        return facturaRepositorie.save(factura);
    }

    /*Actualizar facturas */
    @PutMapping("/{facturaID}")
    public Factura actualizar_factura(@PathVariable ("facturaID") Long facturaID, @RequestBody Factura factura) {
        factura.setFacturaID(facturaID);
        return facturaRepositorie.save(factura);  
    }
    
    /*Eliminar plan*/
    @DeleteMapping("/{facturaID}")
    public void eliminar_factura(@PathVariable ("facturaID") Long facturaID) { 
        facturaRepositorie.deleteById(facturaID);
    }
}
