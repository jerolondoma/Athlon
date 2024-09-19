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
@Table (name = "Planes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planID;

    private String nombreplan;
    private String duracion;
    private String descripcion;
    private String precio;

    @ManyToOne
    private Cliente clienteID;
}
