package com.example.nuevaprueba;

import com.example.nuevaprueba.enums.CategoriaArchivos;
import com.example.nuevaprueba.utils.Generales;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/** Esta clase es la encargada de gestionar los accesos internos a los archivos
 * Clase encargada del manejo de los archivos
 */
public class Archivos {
    static public ClassPathResource ObtenerPathArchivo(CategoriaArchivos categoriaArchivos, String id){

        //String resourceName="archivosMarkdown/"+id;
        String resourceName=categoriaArchivos.getValorAsociado()+id;
        ClassPathResource resource = new ClassPathResource(resourceName);
        return resource;
    }
    static public String convertirStringArchivo(ClassPathResource path) throws IOException {
        String markdownContent=StreamUtils.copyToString(path.getInputStream(), StandardCharsets.UTF_8);
        return markdownContent;
    }

    static public String StringFileAsociado(String id,CategoriaArchivos categoriaArchivos){
        String direccion= Generales.Direccion+categoriaArchivos+Generales.Separador+id;

    StringBuilder contenido = new StringBuilder();
    try{
        FileInputStream archivoEntrada = new FileInputStream(direccion);
        InputStreamReader lector = new InputStreamReader(archivoEntrada);
        BufferedReader bufferedReader = new BufferedReader(lector);
        int caracter;
        while ((caracter = bufferedReader.read()) != -1) {
            contenido.append((char) caracter);
        }
        bufferedReader.close();
        lector.close();
        archivoEntrada.close();

        return contenido.toString();
    }
    catch (IOException e){
        e.printStackTrace();
        return "";
    }

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
    public static String MarkdownToHtml(String markdownContent){
        Parser parser = Parser.builder().build();
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
    static public File obtainFile(CategoriaArchivos categoriaArchivos,String id) throws IOException {
        String rutaAbsoluta = Generales.Direccion + categoriaArchivos + Generales.Separador + id;
        File archivo = new File(rutaAbsoluta);
    return  archivo;
    }
    static public String nameFilePDF(String id){
        return ObtenerPathArchivo(CategoriaArchivos.archivosPDF,id).getFilename();
    }
}
