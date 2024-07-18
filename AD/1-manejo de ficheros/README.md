## **manejo de ficheros**
### Contenido

**LecturaStreamCaracteresFileReader.java**: leeremos desde un archivo, creando un flujo de caracteres desde un archivo de nuestro dispositivo y sacaremos por pantalla el flujo carácter a carácter mediante un bucle while.

**EscrituraStreamCaracteresFileWriter.java**: desde código crearemos y escribiremos en un archivo .txt  con la ayuda de la clase FileWriter, mediante un flujo de caracteres.

**CreacionFicheroBytesFileOutputStream.java**: Crearemos un fichero y le agregaremos un array de bytes como datos mediante FileOutputStream.write(arraybites).

**CreacionEliminacionDeFicheros.java**: Crearemos un fichero con File.createNewFile(), y luego lo eliminaremos con File.delete().

**AccesoADatosMoverFichero.java**: Crearemos dos ficheros y moveremos uno a la posición del otro, sustituyéndolo, mediante File.renameTo(File dest).

**LecturaStreamBytesFileInputStream.java**: Leeremos de un fichero .txt creado por nosotros en el código, mediante un stream de bytes, con la clase FileInputStream y su método read(), y lo sacaremos por pantalla.

**LecturaBytesRandomAccessFile.java**: Leeremos de un fichero .txt un byte correspondiente a la posición 0 del puntero (es decir, el primer carácter (char), utilizando la clase RandomAccessFile en modo lectura ("r").

**EscrituraBytesRandomAccessFile.java**: Escribiremos en un fichero .txt un byte en la posición indicada al puntero. Utilizamos el método RandomAccessFile.seek(long puntero) para indicar el lugar donde escribiremos el byte.

**LecturaBufferBufferedInputStream.java**: Leeremos de un fichero .txt utilizando buffer con la clase BufferedInputStream y lo mostraremos en pantalla mediante un bucle while.
