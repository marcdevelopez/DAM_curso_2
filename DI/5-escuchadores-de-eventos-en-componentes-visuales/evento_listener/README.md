# Simple controlador de evento en un Button

Controlamos el evento producido en un botón JBeans.

En primer lugar, se crea una nueva clase JFrame y se inserta un panel JPanel para ubicar encima el resto de elementos. 
Se coloca una etiqueta y un botón, en la distribución que se desee, desde la vista de diseño. En la parte del código, de forma automática, se habrá generado:

~~~
// Se coloca una etiqueta en Panel
JLabel lblNewLabel = new JLabel("...");
// Se añade al panel
contentPane.add(lblNewLabel);
// Se crea un nuevo botón y añade al panel
JButton btnNewButton = new JButton("Pulsa aquí");
contentPane.add(btnNewButton);
~~~
Desde la vista de diseño, hacemos doble clic sobre el botón, lo que nos lleva al código, donde ahora aparecen algunas líneas nuevas. 

~~~
btnNewButton.addActionListener(new ActionListener({
~~~

De forma automática, se implementa tanto el escuchador vinculado al botón (ActionListener) como el método dentro del cual se desarrollan las acciones desencadenadas por el evento (actionPerformed), que recibe por parámetro un ObjectEvent de tipo ActionEvent. 
Finalmente, solo quedará colocar el código que envía a la etiqueta de texto creada en el inicio el mensaje «Hola Mundo» y la muestra por pantalla. 

~~~
public void actionPerformed(ActionEvent e) {
	lblNewLabel.setText("Hola mundo");
}
});
~~~