package com.example.nuevaprueba.controllers;

import com.example.nuevaprueba.Whatssapp;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/whatssapp")
public class ControlerWhatssapp {
    @Autowired
    private final RestTemplate restTemplate;

    @Value("${Facebook.Whatssapp.APIKEY}")
    String tockenAuth;
    @Value("${Facebook.Whatssapp.numberServer}")
    String numberServer;
    public ControlerWhatssapp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }


    @GetMapping("/send/{number}")
    public void enviaArchivo(@PathVariable @NonNull String number){
        //-->   Generamos el envio a la API de facebook con los datos   <--


        String urlBase="https://graph.facebook.com/v17.0/"+numberServer+"/messages";
        //String tockenAuth="EAAJs83IXjvEBO2dfpoOG0FvglfbeKk7qYCa2jsB36lSDIcYZA6D6XmO7Fjga5D49qqDalReUQKZCZCmsZCyJfKhxw8xQeIfbAuLIOH2LOZAvZBcHn8YUQNDrWmkJ1de7EOoNkDa0PEVByHTpK7O4Dnn6zoVwUEvZBwQrgxcfaMqhN3qik2mZB48ldSjLsCPp01AaZAp17f9yVa92SzPCZAfvgZD";
        HttpHeaders headers = new HttpHeaders();
        String test="{\n" +
                "   \"recipient_type\": \"individual\",\n" +
                "    \"messaging_product\": \"whatsapp\",\n" +
                "    \"to\": \""+number+"\",\n" +
                "    \"type\":\"template\",\n" +
                "    \"template\": {\n" +
                "        \"name\": \"hello_world\",\n" +
                "        \"language\":{\n" +
                "            \"code\":\"en_US\"\n" +
                "        }\n" +
                "        }\n" +
                "    }";
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + tockenAuth);
        HttpEntity<String> requestEntity = new HttpEntity<>(test, headers);
        restTemplate.exchange(urlBase, HttpMethod.POST,requestEntity,String.class);

    }
}
