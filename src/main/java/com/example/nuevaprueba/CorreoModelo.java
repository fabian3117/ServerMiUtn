package com.example.nuevaprueba;

import lombok.*;

import java.io.Serializable;


@Data
public class CorreoModelo implements Serializable {
    private String correo;
    private String nombre;
}
