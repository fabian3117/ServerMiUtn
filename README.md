# ServerMiUtn
# MiUTN 📚 👌👍

Servidor Back-End de aplicativo android:
https://github.com/fabian3117/ProyectoUTN

### Problemática
Durante mi experiencia como estudiante universitario, noté una fragmentación significativa en el material de estudio, así como dificultades para acceder a apuntes para mis materias. Esta no era solo una dificultad personal, sino una situación común entre todos los `estudiantes`. Por ende, decidí abordar este problema mediante la `tecnología`.

>Mi propuesta es `desarrollar una plataforma` que unifique el material de estudio, 
permitiendo a los estudiantes organizarse y gestionarse de manera más eficiente. Además, me propongo enfrentar otra problemática persistente: la deserción universitaria. La idea es proporcionar el material de estudio de manera sincronizada con la cursada, permitiendo a los alumnos avanzar en paralelo e indicar su progreso.

Todo el desarrollo sera codigo libre.
La plataforma incluirá notificaciones periódicas que recomendarán la lectura de apuntes específicos, facilitando así el seguimiento y la mejora continua del aprendizaje. 🎓🚀.
# Build
> Archivo ´src/main/resources/application.properties´
Parametros a ajustar
```
spring.data.mongodb.uri=mongodb://{MongoDB:Port}
spring.data.mongodb.database={dbName}
spring.data.mongodb.username={username}
spring.data.mongodb.password={password}
```
Con esos ajustes se puede conectar a la base de datos mongo.
***Ajustes de envio mails***
Estos ajustes estan referenciados a gmail pero se puede ajustar para outlook
```
spring.mail.host={host en caso de google smtp.gmail.com}
spring.mail.port={port : 587}
spring.mail.username={correo}
spring.mail.password={clave de aplicativo}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.transport.protocol=smtp
spring.mail.properties.mail.smtp.from={nombreemisor}
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
spring.mail.properties.mail.smtp.starttls.required=true
```
### Tecnologias
- Thymeleaft
- Springboot
- Mardown
- Springboot mail
