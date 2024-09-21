package com.athlon.athlon.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    /*Atributos de la tabla factura*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facturaID;
    
    private String fechaF;
    private String precioF;

    @ManyToOne
    private Cliente clienteID;
    
    @ManyToOne
    private Planes planID;
}
