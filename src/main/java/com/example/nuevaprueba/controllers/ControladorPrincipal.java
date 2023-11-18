package com.example.nuevaprueba.controllers;

import com.example.nuevaprueba.entitys.Carrera;
import com.example.nuevaprueba.entitys.NMateria;
import com.example.nuevaprueba.entitys.NprogramaAnalitico;
import com.example.nuevaprueba.entitys.Temario;
import com.example.nuevaprueba.enums.Carreras;
import com.example.nuevaprueba.repository.RepositoryCarrera;
import com.example.nuevaprueba.repository.RepositoryNprogramaAnalitico;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
@Controller
@Slf4j
@RequestMapping("/controladorPrincipal")
public class ControladorPrincipal {
    @Autowired
    RepositoryCarrera carreras;
    @Autowired
    RepositoryNprogramaAnalitico repositoryNprogramaAnalitico;
    @GetMapping("/materias/{carrera}")
    @ResponseBody
    public ArrayList<NMateria> materias(@PathVariable("carrera")Carreras carrera){
        ArrayList<NMateria> materias=new ArrayList<>();
        Carrera carreraSeleccion = carreras.findById(carrera).get();
        materias=carreraSeleccion.getMaterias();
        return materias;
    }
    @GetMapping("/materiasT/{carrera}")
    @ResponseBody
    public ArrayList<NMateria> materiasT(@PathVariable("carrera")String carrera){
        ArrayList<NMateria> materias=new ArrayList<>();
        Carrera carr=(carreras.findById(carrera).isEmpty())?new Carrera():carreras.findById(carrera).stream().findFirst().get();
        Carrera carreraSeleccion = carreras.findById(carrera).stream().findFirst().get();
        materias=carreraSeleccion.getMaterias();
        return carr.getMaterias();
    }
    @GetMapping("/materias/{carrera}/{materia}")
    @ResponseBody
    public NMateria materia(@PathVariable("carrera") @NonNull Carreras carrera,@PathVariable("materia") @NonNull String materia){
        Carrera carreras1=carreras.findById(carrera).get();
        for(NMateria tmp:carreras1.getMaterias()){
            if (tmp.getId().equals(materia)){
                return tmp;
            }}
        return new NMateria();
    }
    @GetMapping("/programa/{carrera}/{id}")
    @ResponseBody
    public NprogramaAnalitico programaAnalitico(@PathVariable("carrera")  Carreras carrera, @PathVariable("id")  String id){
        Carrera carreras1=carreras.findById(carrera).get();
        NprogramaAnalitico buf=new NprogramaAnalitico();
        for(NMateria tmp:carreras1.getMaterias()){
            if (tmp.getId().equals(id)){
                buf=(tmp.getProgramaAnalitico());
            }}
        return buf;
    }
    @GetMapping("/correlativas/{carrera}/{id}")
    @ResponseBody
    public ArrayList<String> correlativas(@PathVariable("carrera")  Carreras carrera, @PathVariable("id")  String id){
        Carrera carreras1=carreras.findById(carrera).get();
        ArrayList<String> buf=new ArrayList<String>();
        for(NMateria tmp:carreras1.getMaterias()){
            if (tmp.getId().equals(id)){
                buf=(tmp.getCorrelativas());
            }}
        return buf;
    }

}
