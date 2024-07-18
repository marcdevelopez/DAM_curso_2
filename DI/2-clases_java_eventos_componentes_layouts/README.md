# **Confección de interfaces intro**:

**ClasesYComponentes.java**: Esta clase abrirá un JDialog "DialogHola" desde un JButton, y además practicaremos con JLabel, JCheckBox, JRadioButton y ButtonGroup, y por último con un JComboBox.


**DialogHola.java**: Creamos en esta clase un molde para nuestro DialogHola, que hereda de JDialog, modificando su constructor para que pueda ser un JDialog modal o no.

**DisenioCalculadora.java**: Diseñamos, sin ninguna funcionalidad, una calculadora. Habría que modificarla para haber añadido la pantalla arriba a la izquierda. ¿Te animas a incluirle esa pantalla? Puedes enviarme un PullRequest si lo deseas, así practicamos Git y GitHub. 

**EjemploFlowLayout.java**: Si lo ejecutas, podrá ver cómo al cambiar las dimensiones de la ventana, cambia su disposición para seguir ocupando toda la ventana los tres JLabels. De ahí su nombre, FlowLayout, el diseño fluye dentro del JFrame, amoldándose a las dimensiones que le demos a su contenedor.

**EjemploGridLayout.java**: Creamos un GridLayout de 2x2, establecemos el Layout del JPanel a GridLayout en la línea 51, en el constructor, después de establecer el ContentPane.

**InicioSesionUsuario.java**: Esta clase es el molde de InicioSesionUsuario, que es un JFrame que se abrirá después de pulsar el botón "Inicio" en la ventana que abre la clase InicioUsuarioContrasenia.java. Lo normal sería abrir un JDialog, pero he querido demostrar que también es posible abrir otros JFrame, según sea nuestra necesidad.

**InicioUsuarioContrasenia.java**: Este JFrame no abrirá un InicioSesionUsuario a menos que introduzcamos el usario y contraseña correctos.

**VentanaPago1.java**: Este es un JFrame, que simula un pago. Recordarás como abrir otro JFrame, conectando dos ventanas.

**VentanaPago2.java**: Esta es la ventana que se abre al pulsar "pagar" en VentanaPago1, y usamos JLabel, JRadioButton, ButtonGroup y JButton. Puedes seguir desarrollando el proyecto si lo deseas...
