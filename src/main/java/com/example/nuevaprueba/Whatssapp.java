package com.example.nuevaprueba;

import lombok.Data;

@Data
public class Whatssapp {
    private String nombre;
    private String numero;

    @Override
    public String toString() {
        return "{\n" +
                "   \"recipient_type\": \"individual\",\n" +
                "    \"messaging_product\": \"whatsapp\",\n" +
                "    \"to\": \""+numero+"\",\n" +
                "    \"type\":\"template\",\n" +
                "    \"template\": {\n" +
                "        \"name\": \"hello_world\",\n" +
                "        \"language\":{\n" +
                "            \"code\":\"en_US\"\n" +
                "        }\n" +
                "        }\n" +
                "    }'";
    }
}
