# ORM Object Relational Mappings

# Hibernate

Conoceremos medios para manejar objetos Java en una base de datos relacional, de manera óptima y eficiente, de la mano de los ORM.

El proyecto demoHibernate es un proyecto web con base de datos H2 embebida, creado con Spring Boot. Es el resultado de los pasos seguidos en el pdf adjunto. Ahí podéis ver el archivo application.properties con las configuraciones del proyecto, gracias a las cuales, por ejemplo, podremos ver los resultados de consultas SQL a la base de datos en el log. Está implementado en el IDE Eclipse.

Para abrir el proyecto descomprimido de Spring Boot con Eclipse (en el resto de IDEs es similar el proceso):

Nos vamos al menú superior, en la pestaña File (a la izquiera) -> Import -> Select an import wizard -> abrimos Maven y seleccionamos "Existing Maven Proyects" -> Next -> botón Browse -> y seleccionamos el proyecto, ya descomprimido, que será una carpeta/directorio resultado de extraer el proyecto descargado de https://start.spring.io/

Tambien podemos agregar el plugin de spring en nuestrom IDE Eclipse:
Vamos a menú Help -> Eclipse Marketplace -> buscamos spring e instalamos:

Spring Tools 3 (Standalone Edition)

Spring Tools 3 Add-On for Spring Tools 4

y Spring Tools 4.

Los instalamos a la vez, con la opción "install more", y al terminar y reiniciar ya veremos la cvategoria Spring Boot en File -> New -> Other... y podremos hacer lo mismo que en la página web https://start.spring.io/ pero directamente en nuestro IDE.

Esto lo escribí en diciembre de 2024, de modo que podría cambiar el nombre de algún plugin o la situación de algḉun menú, pero básicamente será lo mismo.

¡A disfrutar se ha dicho!
