package com.example.nuevaprueba.controllers;

import com.example.nuevaprueba.Archivos;
import com.example.nuevaprueba.enums.CategoriaArchivos;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/archivos")
@Controller
public class ControlerFiles {
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> descarga(@PathVariable String id){
        String fileContent =Archivos.StringFileAsociado(id, CategoriaArchivos.archivosMarkdown);
        //String fileContent = "Este es el contenido del archivo en formato de cadena.";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "nombre-del-archivo.txt");
        return ResponseEntity.ok()
                .headers(headers)
                .body(fileContent);
    }
}
