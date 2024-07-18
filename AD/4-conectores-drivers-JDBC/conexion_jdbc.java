public static void main(String args[]) throws SQLException {

    /*
	Se definen  variables de tipo String que nos van a servir para realizar la conexión con la 
    base de datos más tarde.
    Instanciamos el usuario y la contraseña de nuestra conexión y también una variable de 	
    tipo Connection y otra Statement. 
    Normalmente se definen los literales de usuario y password en una capa DAO
	*/ 
final String usuario = “user_db”; 
final String password = “password_db”; 
Connection dbConnection = null; 
Statement statement = null; 

    /**
     *1- El primer paso: sería descargar el driver (suele ser “.jar”) de conexión de la base
     de datos que vamos a utilizar ...
      2- y, a continuación, añadirlo a nuestro proyecto Java o nuestro aplicativo. 
      Será nuestro literal DRIVER:
      El primer paso para la conexión de una base de datos externa por medio de un driver de 
      conexión es definir algunos literales que nos van a hacer falta, como el literal “Driver”, 
      que hace referencia a la librería que hemos añadido a nuestro aplicativo, y la 
      “URL CONEXION”, que hace referencia a la URL donde se alojará la información. 
      Estas, podemos definirlas como variables estáticas generales, ya que accederemos a ellas 
      más tarde. 
     */
    private static final String DRIVER = “org.mysql.jdbc.Driver”; 
	private static final String URL_CONEXION = “jdbc:mysql://localhost:3306/Pruebas”; 

try {
    /**
     * Registramos el driver que anteriormente hemos indicado en la variable estática “DRIVER”. 
     * Con esta instrucción cargamos la librería "org.mysql.jdbc.Driver".
     * Con Class.forName estaremos dando de alta un driver en nuestra aplicación:
     */ 
    Class.forName(DRIVER);
    /**
     * El objetivo de la clase DriverManager, realmente, es gestionar los drivers que 
     * poseemos en nuestra aplicación y permitir en una misma capa el acceso a todos 
     * y cada uno de ellos. Algo que debemos tener en cuenta es que DriverManager 
     * necesita que todos y cada uno de los drivers estén registrados antes de su uso. 
     * Las conexiones deben quedar almacenadas antes de acceder a la base de datos. 
     * Después de haber registrado el driver, se pueden usar los métodos estáticos 
     * para hacer “getConnection”, usándolo directamente para establecer conexiones. 
     * Al método “getConnection” le pasamos por parámetro la URL de conexión previamente 
     * definida: usuario y contraseña. 
     * Nos devolverá objeto de tipo Connection, en nuestro caso lo hemos llamado 
     * dbConnection. De modo que en dbConnection tendríamos la conexión.
     */
    dbConnection = DriverManager.getConnection(URL_CONEXION, usuario, password);
    /**
     * Y ahora ya podemos usar la Base de Datos con sentencias, etc...
     */
    String selectTableSQL = "SELECT ID,USERNAME,PASSWORD,NOMBRE FROM Usuarios";
    /**
     * Y creamos el Statement (declaración SQL) en nuestra conexión a la BDD:
     * El resultado de la petición a la BDD se almacenará en un ResultSet:
     * Con la variable Connection, ejecutamos el método “createStatement” y lo asignamos 
     * a la variable definida al principio del ejercicio de tipo Statement. 
     * Realizamos la consulta con el método “executeQuery” 
     * pasándole como parámetro la query previamente definida en la variable de tipo String. 
     */
    statement = dbConnection.createStatement();
    /**
     * El resultado de la query se asignará a una variable de tipo ResultSet (rs). 
     * La lectura del ResultSet está envuelto en un bucle “while”, 
     * ya que por cada fila que nos devuelva esta tabla, podremos ir dando una vuelta más 
     * al bucle y seguir mostrando los resultados. 
     * Mostraremos por pantalla tanto el ID, el USERNAME, el PASSWORD y el NOMBRE, 
     * que son columnas de la tabla Usuarios que hemos consultado de prueba. 
     */
    ResultSet rs = statement.executeQuery(selectTableSQL);
    while (rs.next()) {
        String id = rs.getString("ID");
        String usr = rs.getString("USERNAME");
        String psw = rs.getString("PASSWORD");
        String nombre = rs.getString("NOMBRE");
        System.out.println("userid : " + id);
        System.out.println("usr : " + usr);
        System.out.println("psw : " + psw);
        System.out.println("nombre : " + nombre);
    }
} catch (SQLException e) {
    /**
     * Excepción capturada si a la hora de ejecutar el método “executeQuery” 
     * algo va mal en base de datos, ya sea gramaticalmente, sintácticamente, etc. 
     */
    System.out.println(e.getMessage());
} catch (ClassNotFoundException e) {
    /**
     * Excepción lanzada y capturada en este punto si en nuestra línea: 
     * “Class. forName(DRIVER)”
     * el fichero del driver que le estamos indicando no encontrara la librería. 
     */
    System.out.println(e.getMessage());
} finally {
    /**
     * La sentencia finally se ejecutará siempre, hayamos capturado excepción o no. 
     * En esta, simplemente, se realizan los cierres de la clase Statement y del 
     * objeto Connection que, a su vez, en este punto pueden lanzar una excepción 
     * que será recogida y lanzada a la capa superior a través de la palabra clave 
     * “Throws” en la definición de nuestro método. 
     */
    if (statement != null) {
        statement.close();
    }
    if (dbConnection != null) {
        dbConnection.close();
    }
}
    
}
