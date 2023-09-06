package com.example.nuevaprueba;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Clase encargada del manejo de los archivos
 */
public class Archivos {
    static public ClassPathResource ObtenerPathArchivo(CategoriaArchivos categoriaArchivos,String id){

        //String resourceName="archivosMarkdown/"+id;
        String resourceName=categoriaArchivos.getValorAsociado()+id;
        ClassPathResource resource = new ClassPathResource(resourceName);
        return resource;
    }
    static public String convertirStringArchivo(ClassPathResource path) throws IOException {
        String markdownContent=StreamUtils.copyToString(path.getInputStream(), StandardCharsets.UTF_8);
        return markdownContent;
    }
    static public String archivoMarkdown(String id) throws IOException {
        String resourceName="archivosMarkdown/"+id;
        ClassPathResource resource = new ClassPathResource(resourceName);
        Parser parser = Parser.builder().build();
        if(!resource.exists()){
            System.out.println("Archivo Markdown no existe");
            return "fileNotFound";
        }
        String markdownContent= StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        Node document = parser.parse(markdownContent);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
    static public File fileMarkdwond(String id) throws IOException{
        String resourceName="archivosMarkdown/"+id;
        ClassPathResource resource = new ClassPathResource(resourceName);
        //TODO Corregir problema de si archivo es nullo
        return resource.getFile();
    }
    static public File obtainFile(CategoriaArchivos categoriaArchivos,String id) throws IOException{
        ClassPathResource resource=ObtenerPathArchivo(categoriaArchivos, id);
        if (!resource.exists()) {
            //-->   En caso de no encontrarse el archivo excepcion  <--
            throw new FileNotFoundException("El archivo no se encuentra.");
        }
        try {
            return resource.getFile();
        } catch (IOException e) {
            //-->   En caso de problemas emito excepcion <-- Manejar la excepción de E/S (IOException)
            throw new IOException("Error al obtener el archivo.", e);
        }
    }
    static public String nameFilePDF(String id){
        return ObtenerPathArchivo(CategoriaArchivos.archivosPDF,id).getFilename();
    }
}
