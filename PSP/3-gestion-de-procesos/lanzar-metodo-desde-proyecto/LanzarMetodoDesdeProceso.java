package com.marcdevelopez.lanzarmetododesdeproceso;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LanzarMetodoDesdeProceso {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            int numero1, numero2;
            System.out.println("Dame un primer número inicial para el intervalo");
            numero1 = scanner.nextInt();
            System.out.println("Dame el número final del intervalo");
            numero2 = scanner.nextInt();
            /**
             * Ejecutamos el proceso con el método ejecutarClaseProceso,
             * definido en esta misma clase, abajo, y obtenemos el valor de
             * salida recuperado en una variable. Este método hará 2 cosas:
             * Ejecutará el proceso, y obtendrá el resultado del proceso
             * (resultado satisfactorio con valor 0).
             */
            int valorSalidaProceso = ejecutarClaseProceso(Sumador.class,
                    numero1, numero2);
            if (valorSalidaProceso == 0) {
                System.out.println("Proceso ejecutado correctamente");
            } else {
                System.out.println("Ocurrió un error al ejecutar el proceso...");
            }
        } catch (IOException | InterruptedException ex) {
            System.err.println("Error: " + ex.toString());
            System.exit(-1);
        }

    }

    /**
     * Como podemos ver, al método de la clase principal le pasamos 3 atributos:
     *
     * @param clase El nombre de la clase que queremos ejecutar. Parámetros de
     * tipo int, que serán los parámetros que necesite la clase para ejecutar su
     * método. Estos parámetros podrán cambiar y podrán ser tantos como
     * necesitemos, en este ejemplo serán 2, para hacer una suma:
     * @param n1
     * @param n2
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static int ejecutarClaseProceso(Class clase, int n1, int n2)
            throws IOException, InterruptedException {
        // defino en la variable javaHome dónde está el home de java
        String javaHome = System.getProperty("java.home");
        /**
         * defino en la variable javaBin dónde está el binario ejecutable de la
         * màquina virtual java
         */
        String javaBin = javaHome
                + File.separator + "bin"
                + File.separator + "java";
        /**
         * Defino la variable classPath que es el nombre completo de la clase
         * java
         */
        String classPath = System.getProperty("java.class.path");
        // obtengo el nombre canónico de la clase que se ejecutará
        String ClassName = clase.getCanonicalName();
        /**
         * Creamos el proceso a ejecutar Los dos últimos parámetros son los
         * parámetros de la clase main de la clase.
         *
         * Cuando estamos creando el proceso con ProcessBuilder, los dos últimos
         * parámetros que pasamos son los dos enteros citados, ya que son los
         * que necesitará la clase que queremos ejecutar. Aquí podremos pasarle
         * todos los parámetros que necesitemos (o ninguno, si se da el caso),
         * que deben ser, obligatoriamente, del tipo String, ya que, en el main
         * de la clase, utilizaremos el array de Strings que recibe para
         * recuperar todos los parámetros que estamos pasando en este punto.
         */
        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp",
                classPath, ClassName, String.valueOf(n1),
                String.valueOf(n2));

        // Indicaremos las redirecciones de salida, para mostrar resultados
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        /**
         * Si deseamos redireccionar a un archivo: builder.redirectError(new
         * File("errores.txt"));
         */
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        Process proceso = builder.start();
        // con waitFor espero a que se ejecute el proceso
        proceso.waitFor();
        // devolvemos el valor de salida del proceso, si es 0 será ejecutado ok
        return proceso.exitValue();

    }
}
