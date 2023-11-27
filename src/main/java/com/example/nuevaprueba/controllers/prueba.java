package com.example.nuevaprueba.controllers;
import com.example.nuevaprueba.entitys.*;
import com.example.nuevaprueba.enums.Carreras;
import com.example.nuevaprueba.enums.Cuatrimestres;
import com.example.nuevaprueba.enums.Modalidad;
import com.example.nuevaprueba.enums.Sedes;
import com.example.nuevaprueba.repository.*;
import com.example.nuevaprueba.security.Credenciales;
import com.example.nuevaprueba.services.EnvioCorreos;
import com.example.nuevaprueba.utils.Generales;
import jakarta.mail.MessagingException;
import lombok.NonNull;
import org.thymeleaf.context.Context;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Controller
@Slf4j

//@RestController
@RequestMapping("")
public class prueba {
@Autowired
    RepositoryMateria repositoryMateria;
@Autowired
    ReposotoryMateriaCursando reposotoryMateriaCursando;
@Autowired
    RepositoryProfile repositoryProfile;
@Autowired
    RepositoryProgramaElectronica repositoryProgramaElectronica;
@Autowired
    RepositoryPerfil repositoryPerfil;
@Autowired
RepositoryNprogramaAnalitico repositoryNprogramaAnalitico;
@Autowired
RepositoryCarrera carreras;
@Autowired
RepositoryFechasExamenes repositoryFechasExamenes;
    @GetMapping("/mostrar")
    public String inicio(){

    return "inicio";
}
/*
    Obtencion de las materias asociadas a una carrera   <--
 */
@PutMapping("/obtenerPrograma")
@ResponseBody
public ArrayList<NMateria> ObtenerPrograma(@RequestBody @NonNull  Carreras carrera)
{
log.error("ACA","ERROR PROGRAMA");
   // ArrayList<NprogramaAnalitico> salida=new ArrayList<>();
    return carreras.findById(carrera).get().getMaterias();
}
@GetMapping("obtenerFechas")
@ResponseBody
public ArrayList<FechasExamenes> ObtenFechasExamenes(){
    ArrayList<FechasExamenes> salida=new ArrayList<>(repositoryFechasExamenes.findAll());
    //salida=repositoryFechasExamenes.findAll();
    return salida;
}
@GetMapping("ipconfig/{carrera}/{materia}")
@ResponseBody
public Materia ObtenerMateria(@PathVariable @NonNull String carrera,@PathVariable @NonNull String materia){
   AtomicReference<Materia> materiaretorna= new AtomicReference<>(new Materia());
    if(carrera.equals(Carreras.Electronica.getValorAsociado())){
        repositoryProgramaElectronica.findById(Carreras.Electronica.getValorAsociado()).get().getMaterias().forEach(materia1 -> {
            if(materia1.getNombre().equals(materia)){
                materiaretorna.set(materia1);
            }
        });
    }
    return materiaretorna.get();
    }
    @GetMapping("")
    @ResponseBody
    public String CargaInicial(){
        NMateria informatica= new NMateria();
        NMateria am1= new NMateria();
        NMateriasCursando am1Cursando= new NMateriasCursando();
        NMateria am2= new NMateria();
        NMateria F1= new NMateria();
        NMateriasCursando F1Cursando= new NMateriasCursando();
        ArrayList<Materia> materiaArrayList=new ArrayList<>();
        ArrayList<Temario>temarios= new ArrayList<>();
        ArrayList<Temario>temariosAM2= new ArrayList<>();
        ArrayList<String> CorrelativasAM2=new ArrayList<>();
        ArrayList<NMateria> materiasCursadas=new ArrayList<>();
        Temario temarioAm2=new Temario();

        Temario temarioGenerico=new Temario();
        ArrayList<Temario> temarioArrayListGenerico=new ArrayList<>();
        for(int i=0;i<5;i++){
            temarioGenerico.setApunte("https://www.google.com.ar");
            temarioGenerico.setTema("Tema : "+i);
            temarioArrayListGenerico.add(temarioGenerico);
        }
        Profile profileTest=new Profile();
        ArrayList<NMateriasCursando> materiaCursando=new ArrayList<>();
        ArrayList<MateriaCursando> materiaCursandosAprobadas=new ArrayList<>();
        informatica.setName("Informatica 1");
        informatica.setId("Informatica 1");
        am1.setName("Analisis matematico 1");
        am2.setName("Analisis matematico 2");
        F1.setName("Fisica 1");
        CorrelativasAM2.add("Analisis 1");
        am2.setCorrelativas(CorrelativasAM2);
        am1.setAnio("1");
        informatica.setAnio("1");
        am1.setId("AM1");
        profileTest.setId("FEDE");
        temariosAM2.add(temarioAm2);
        am2.setProgramaAnalitico(new NprogramaAnalitico(temarios));
        am1.setProgramaAnalitico(new NprogramaAnalitico(temarios));
        informatica.setProgramaAnalitico(new NprogramaAnalitico(temarios));
        F1.setProgramaAnalitico(new NprogramaAnalitico(temarioArrayListGenerico));

        Perfil perfil=new Perfil();
        perfil.setId("TS");
        perfil.setLegajo("5555");
        perfil.setCarrea(Carreras.Electronica);
        perfil.setPassword("ASS");
        perfil.setName("FEDETS");
        perfil.setProfilePic("https://static.vecteezy.com/system/resources/thumbnails/002/318/271/small/user-profile-icon-free-vector.jpg");
        perfil.setUserSIU("fabian3117");
        perfil.setCorreoInstitucional("fabian3117@frba.utn.edu.ar");
        informatica.setCuatrimestre(Cuatrimestres.PrimerCuatrimestre);
        am1.setCuatrimestre(Cuatrimestres.PrimerCuatrimestre);

        //profileTest.setMateriaCursandos(materiaCursandos);
        ArrayList<Materia> materiasaprobadas=new ArrayList<>();

        //-->   NOTE: Materias que ESTOY CURSANDO<--
        profileTest.setMateriasCursadasAprobadas(materiasaprobadas);
        am1Cursando.setHorario(new Horarios("lunes","15:00","17:00","S05", Sedes.Campus));
        am1Cursando.setMateria(am1);
        F1Cursando.setMateria(F1);
        F1Cursando.setHorario(new Horarios("Martes","15:00","17:00","S05", Sedes.Campus));
        materiaCursando.add(F1Cursando);
        materiaCursando.add(am1Cursando);
        perfil.setMateriasCursando(materiaCursando);
        //-->   NOTE: Materias que CURSE    <--
        materiasCursadas.add(F1);
        perfil.setMateriasCursadas(materiasCursadas);
        perfil.setUserName("USERNAME");
        //repositoryPerfil.save(perfil);
        repositoryPerfil.save(perfil);
        //repositoryProfile.save(profileTest);

        Carrera carreraElectronica=new Carrera();
        carreraElectronica.setId(Carreras.Electronica);
        NMateria materia=new NMateria();
        materia.setName("AGA");
        materia.setId("AGA");
        materia.setCorrelativas(new ArrayList<>());
        materia.setAnio("1");
        materia.setCuatrimestre(Cuatrimestres.PrimerCuatrimestre);
        materia.setModalidad(Modalidad.Hibrido);
        NMateria material=new NMateria();
        material.setName("AGA");
        material.setId("AGA");
        materia.setCorrelativas(new ArrayList<>());
        materia.setAnio("1");
        materia.setCuatrimestre(Cuatrimestres.PrimerCuatrimestre);
        materia.setModalidad(Modalidad.Hibrido);
        NprogramaAnalitico nprogramaAnalitico=new NprogramaAnalitico();
        nprogramaAnalitico.setTemas(temarioArrayListGenerico);
       // nprogramaAnalitico.setTemas(temarioGenerico);
        ArrayList<NMateria> materiasCarrera=new ArrayList<>();
        materia.setProgramaAnalitico(nprogramaAnalitico);

        materiasCarrera.add(materia);
        materiasCarrera.add(F1);
        materiasCarrera.add(am1);
        materiasCarrera.add(am2);
        carreraElectronica.setId(Carreras.Electronica);

        carreraElectronica.setMaterias(materiasCarrera);

        carreras.save(carreraElectronica);
        Carrera carreraMecanica=new Carrera();
        carreraElectronica.setId(Carreras.Mecanica);
        NMateria materiall=new NMateria();
        materiall.setName("AGA");
        materiall.setId("AGA");
        materiall.setCorrelativas(new ArrayList<>());
        materiall.setAnio("1");
        materiall.setCuatrimestre(Cuatrimestres.PrimerCuatrimestre);
        materiall.setModalidad(Modalidad.Hibrido);
        ArrayList<NMateria> materiasCarrerall=new ArrayList<>();
        materiasCarrerall.add(materiall);

        materiall.setProgramaAnalitico(nprogramaAnalitico);
        carreraMecanica.setId(Carreras.Mecanica);
        carreraMecanica.setMaterias(materiasCarrera);
        carreras.save(carreraMecanica);
        FechasExamenes fechaProxima=new FechasExamenes();
        fechaProxima.setFecha("29/10/2023");
        NMateria materia1=new NMateria();
        materia1.setName("Finales");
        materia1.setAnio("1");
        fechaProxima.setMateria(materia1);
        repositoryFechasExamenes.save(fechaProxima);
        return "saludo";
}
@GetMapping("obtenerMateriasCursadas/{profile}")
@ResponseBody
public ArrayList<Materia> ObtenerMateriasCursadas(@PathVariable @NonNull String profile){
    return repositoryProfile.findById(profile).get().getMateriasCursadasAprobadas();
}
@GetMapping("puedeCursar/{profile}")
@ResponseBody
public ArrayList<String> PuedeCursar(@PathVariable @NonNull String profile){
    //-->   Obtencion de materias que se pueden cursar  <--
    //-->   Obtengo la carrera asociada a el perfil <--
    Perfil perfil=repositoryPerfil.findById(profile).get();
    perfil.getCarrea();
    Carrera carrera=carreras.findById(perfil.getCarrea()).get();
    ArrayList<String> salida=new ArrayList<>();
    for(NMateria materia:carrera.getMaterias()){
        if(materia.getCorrelativas().containsAll(perfil.getMateriasCursadas())){
            salida.add(materia.getName());
        }
    }
    return salida;
}
@GetMapping("Ver")
    @ResponseBody
    public String muestra(){
        ArrayList<String> salida=new ArrayList<>();
        repositoryMateria.findAll().forEach(materia -> {
            salida.add(materia.getNombre());
        });
        return  salida.toString();
    }

    @GetMapping("obtenerMaterias/{profile}")
    @ResponseBody
    public ArrayList<MateriaCursando> obtenerMateriasCursando(@PathVariable @NonNull String profile){
    ArrayList<MateriaCursando> materiaCursandos=new ArrayList<>();
    //-->   Connection to db and obtein date of matery currently studying
   return  repositoryProfile.findById(profile).get().getMateriaCursandos();

//    return materiaCursandos;
    }
    @GetMapping("obtenerMaterias/{profile}/{dia}")
    @ResponseBody
    public ArrayList<MateriaCursando> TestFiltrado(@PathVariable @NonNull String profile,@PathVariable @NonNull String dia){

        ArrayList<MateriaCursando> materiasHoy=new ArrayList<>();
        Profile test=repositoryProfile.findById(profile).get();
        test.getMateriaCursandos().forEach(materiaCursando -> {
            if(materiaCursando.getDia().equals(dia)){
                materiasHoy.add(materiaCursando);
            }
            //(materiaCursando.getDia().equals("Lunes"))?materiasHoy.add(materiaCursando):continue;
        });
return materiasHoy;
    }

    @PostMapping("CargaPerfil")
    @ResponseBody
    public boolean CargaPerfil(@RequestBody Perfil perfil){
    log.error("MIRA",perfil.getName());
        repositoryPerfil.save(perfil);
    return  true;
    }
    @GetMapping("descargarPerfil/{perfilId}")
    @ResponseBody
    public Perfil enviaPerfil(@PathVariable("perfilId") String perfilId){
    Optional<Perfil> perfil=repositoryPerfil.findById(perfilId);
    log.error("ENTRAMOS","ESTAN DESCARGANDO");
    return perfil.get();
    }

    @PostMapping("guardarMateria/{profile}")
    @ResponseBody
    public NMateriasCursando GuardarMateria(@PathVariable("profile") String profile,@RequestBody NMateriasCursando materiaAgrega){
    NMateria nMateria=new NMateria();
        NMateriasCursando salida=new NMateriasCursando();
    //-->   Busco dentro de
        Optional<Perfil> byId = repositoryPerfil.findById(profile);
        Carreras carrera=byId.get().getCarrea(); //-->   Tengo la carrera ahora descargo el programa analitico para machear la materia
        Carrera carrera1=carreras.findById(carrera).get();
        for(NMateria materia : carrera1.getMaterias()){
            if(materia.getName().equals(materiaAgrega.getMateria().getName())){
                //-->   Ahora me agrego esta materia a mi perfil y la envio para guardar en local en celular
                nMateria.setName(materiaAgrega.getMateria().getName());
                nMateria.setCorrelativas(materia.getCorrelativas());
                nMateria.setProgramaAnalitico(materia.getProgramaAnalitico());
                nMateria.setId(materia.getId());
                nMateria.setModalidad(materiaAgrega.getMateria().getModalidad());
                nMateria.setAnio(materia.getAnio());
                nMateria.setCuatrimestre(materia.getCuatrimestre());
                salida.setMateria(nMateria);
            }
        }
        ArrayList<NMateriasCursando> nm=byId.get().getMateriasCursando();
        salida.setHorario(materiaAgrega.getHorario());
        nm.add(salida);
        byId.get().setMateriasCursando(nm);
        repositoryPerfil.save(byId.get());
        return salida;
    }
    @GetMapping("obtenerApuntes/{profile}")
    @ResponseBody
    public ArrayList<Temario> Apuntes(@PathVariable("profile") String profile){
    ArrayList<Temario> salida=new ArrayList<>();
    Carreras carrera=repositoryPerfil.findById(profile).get().getCarrea();
        Optional<Carrera> byId = carreras.findById(carrera);
        Carrera sc= byId.get();
        for(NMateria materia:byId.get().getMaterias()){
            salida=materia.getProgramaAnalitico().getTemas();
        }
        List<NprogramaAnalitico> analitico=repositoryNprogramaAnalitico.findAll();
    return salida;

    }
    @PostMapping("/testRecepcion")
    @ResponseBody
    public String test(){
    return "OK";
    }

    @PostMapping("/seccionInicio")
    @ResponseBody
    public ResponseEntity<?> seccionInicio(@RequestBody @NonNull Credenciales credenciales) {
        // Buscar en la base de datos si existe un usuario con ese nombre de usuario
        //Optional<Perfil> optionalPerfil = repositoryPerfil.findById(credenciales.getUsuario());
        Optional<Perfil> optionalPerfil=repositoryPerfil.findByUserName(credenciales.getUsuario());
//todo no tengo que buscar por id si no por username
        if (optionalPerfil.isPresent()) {
            Perfil perfil = optionalPerfil.get();

            // Verificar si la contraseña coincide
            if (perfil.getPassword().equals(credenciales.getClave())) {
                // Autenticación correcta, devolver el perfil
                return new ResponseEntity<>(perfil, HttpStatus.OK);
            } else {
                // Contraseña incorrecta
                return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
            }
        } else {
            // Usuario no encontrado en la base de datos
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/verificaUsuarioExistente")
    @ResponseBody
    public ResponseEntity<?> verificaUsuarioExistente(@RequestBody @NonNull Map<String,String> datos) {
        // Buscar en la base de datos si existe un usuario con ese nombre de usuario
        //TODO Luego ampliar busqueda por correo
        String usuario=datos.get("usuario");
        String carrera=datos.get("carrera");
        Optional<Perfil> optionalPerfil = repositoryPerfil.findById(usuario);
        if (!optionalPerfil.isPresent()) {
            // Usuario puede registrarse
            ArrayList<Carrera> byId = carreras.findById(carrera);
            ArrayList<NMateria> materias = carreras.findById(carrera).get(0).getMaterias();
            //TODO tengo que enviar todo el programa analitico de la carrera para mostrarlo en el sideSheet
                return new ResponseEntity<>(materias, HttpStatus.OK);
        }
            // Usuario no puede registrarse
            log.error("Entramos B","B");
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
    @PostMapping("/nuevoUsuario")
    @ResponseBody
    public ResponseEntity<?> nuevoUsuario(@RequestBody @NonNull Map<String,String> datos) {
        // Buscar en la base de datos si existe un usuario con ese nombre de usuario
        //TODO Luego ampliar busqueda por correo
        String usuario=datos.get("usuario");
        String carrera=datos.get("carrera");
        ArrayList<String> materias=new ArrayList<>();
        ArrayList<NMateria>materiasCursadas =new ArrayList<>();
        Optional<Perfil> optionalPerfil = repositoryPerfil.findById(usuario);
        if (!optionalPerfil.isPresent()) {
            ArrayList<Carrera> byId = carreras.findById(carrera);
           int contador= Integer.parseInt(datos.get("materiasSize"));
           for(int i=0;i<contador;i++){
               materias.add(datos.get("materia"+i));
               log.error(datos.get("materia"+i));
           }
           //TODO link materia string con MATERIA del programa
           Perfil perfil=new Perfil();
           perfil.setId(carrera+usuario);   //-->   El usuario SIU funciona como valor unico asi que "confio en eso por ahora"  <--
           perfil.setName(datos.get("nombre"));
           //TODO TERMINAR ACA PERO PARTE ANDROID
           perfil.setUserName(datos.get("nombre"));
           perfil.setPassword(datos.get("hash"));
           perfil.setCarrea(Carreras.valueOf(carrera));
           perfil.setLegajo(datos.get("legajo"));
           perfil.setUserSIU(usuario);
           perfil.setCorreoInstitucional(datos.get("correo"));
           perfil.setMateriasCursadas(materiasCursadas);
           perfil.setMateriasCursando(new ArrayList<>());
           repositoryPerfil.save(perfil);
            //TODO tengo que enviar todo el programa analitico de la carrera para mostrarlo en el sideSheet
                return new ResponseEntity<>(perfil, HttpStatus.OK);
        }
            // Usuario no puede registrarse
            log.error("Entramos B","B");
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
    @Autowired
    EnvioCorreos envioCorreos;
    @PostMapping("/restaurarClave")
    @ResponseBody
    public ResponseEntity<?> restaurarClave(@RequestBody @NonNull String correo) throws MessagingException, javax.mail.MessagingException {
        // Buscar en la base de datos si existe un usuario con ese nombre de usuario
        // Verifico si esta en db y en caso de estar envio el correo y retorno ok
        correo=correo.replaceAll("^\"|\"$", "");
        if(!correo.contains("@frba.utn.edu.ar")){
            correo=correo.concat(Generales.dominioCorreos);
        }
        Optional<Perfil> usuario=repositoryPerfil.findPerfilByCorreoInstitucional(correo);
        if(usuario.isEmpty()){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }

        //todo envio el mail    <--
        envioCorreos.sendEmail(correo, Generales.asuntoMailRestauracion,"HOLA");
        Context context=new Context();
        envioCorreos.sendHtmlEmail(correo,Generales.asuntoMailRestauracion,"templateMails",context);
        return new ResponseEntity<>(true, HttpStatus.OK);

    }
private boolean existeCorreo(String correo){
    return false;
}

}

