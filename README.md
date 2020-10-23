# Calculadora
_Autor: José Luis Ganfornina García_

### Resumen
- [Contenido](#Contenido)
- [Metodología](#Metodología)
- [Notas](#Notas)
- [Stack tecnológico](#Stack)
- [Documentación](#Documentación)
- [Instrucciones](#Instrucciones)

## Contenido

Esta es la prueba de concepto de una calculadora capaz de realizar operaciones aritméticas. Actualmente solo se han implementado las operaciones de suma y resta, pero se ha dejado preparado para que pueda ser ampliado con más operaciones fácilmente.
Para hacer las operaciones se ha implementado un único endpoint que dada una operación y los dos números devuelve el resultado esperado.

Dado que los cálculos son idempotentes y no realiza modificaciones de estado, se ha optado por el uso del verbo GET para el endpoint. Además el verbo GET nos ofrece las siguientes ventajas: 
- tamaño suficiente para permitir operaciones de gran precisión (más 8000 dígitos) 
- las llamadas por método GET pueden ser cacheadas

En el caso de querer enviar números con un tamaño superior se podría plantear el uso del verbo POST. Para usar el verbo POST se tendría que recibir los parámetros en el body de la petición, deserializándolo en un DTO.


## Metodología

Para la realización de la prueba he usado TDD como metodología de desarrollo.
He comenzado creando un test para la suma de dos números y luego implementando el servicio correspondiente.
Después se ha seguido la misma dinámica para la implementación de los tests y el servicio de operación resta.

Una vez finalizada la implementación de las dos operaciones y teniendo el respaldo de los tests, se ha realizado una refactorización para extraer el comportamiento común y unificarlo en un único servicio.

Por último se han implementado los tests de la API y el controlador que expone un único endpoint capaz de realizar las operaciones soportadas.


## Notas

En la librería de traceo proporcionada se ha encontrado un error. La clase TraceImpl no implementa la interfaz TraceAPI, lo que me ha obligado a usar directamente la implementación.


## Stack

El stack tecnológico que he usado para la implementación de esta calculadora es:

- JDK 8
- Spring Boot 2.3.4
- Maven
- Junit 5
- Mockito
- Jacoco


## Documentación

Para generar la documentación necesaria para hacer uso de la API-REST se ha añadido y configurado la librería de Swagger que expone una interfaz web que permite consultar la documentación y realizar pruebas. 
Swagger está disponible en:

http://localhost:8080/swagger-ui.html


## Instrucciones
    
Ejecutar los tests:
    
    mvnw clean test
    

El resultado de la cobertura de tests se puede ver en: 

    /target/site/jacoco 


Ejecutar el microservicio:

    mvnw clean spring-boot:run
    

Crear el jar:

    mvnw clean package
