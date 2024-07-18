# Proyecto "conficguración de ratón"

En este proyecto se implementará una interfaz para configurar la velocidad de desplazamiento del ratón; también se configurará cuál de los dos botones será el principal. Para ello, se utilizarán los componentes gráficos:

• Un JSpinner, para poder seleccionar los valores 0, 25 y 50. 

• Un JComboBox, con la opción izquierdo y derecho. 
• Una barra de progreso que muestre la velocidad. 

• Un ratón que indique el botón seleccionado. 

Para implementar los eventos escuchadores asociados al JSpinner y al JComboBox será necesario utilizar:

• En el caso del JSpinner. para capturar la velocidad establecida por el usuario. se utilizará el evento de cambio de estado:

~~~
 spinner1.addChangeListener(new ChangeListener() {
 	@Override
 	public void stateChanged(ChangeEvent e) {
~~~
• Para el JComboBox se utilizará el evento de ítem seleccionado: 
~~~
combo1.addItemListener(new ItemListener() {
	public void itemStateChanged(ItemEvent e) {
~~~
• Cuando se detecte el cambio de estado del componente JSpinner, se llamará al método de ‘pintar’ para dibujar la barra de progreso con el color y longitud apropiados. Si la velocidad seleccionada es 0, la longitud de la barra será de 20px y el color será el rojo. Si es 25, será de color naranja y longitud 40px. Por último, en el caso de ser velocidad 50, la barra será de longitud 60px y de color verde.
~~~
if (spinner1.getValue().equals(0)) {
	g.setColor(Color.red);
	g.fillRect(50, 120, 20, 20);
~~~
• Con la detección del evento del botón seleccionado en el JComboBox, se llamará también al método ‘pintar’, que dibujará el botón del ratón seleccionado. En el caso de que sea el botón izquierdo, dibujará desde el píxel 215 del eje ‘x’, que es donde empieza el rectángulo del botón. Si es el botón derecho, se dibujará ese mismo círculo desde la coordenada ‘x’ de 275 px. 
~~~
 if (combo1.getSelectedItem().toString().equals("Izquierdo")) {
            g.fillRect(215, 120, 60, 60);
            g.setColor(Color.gray);
            g.fillOval(215, 120, 60, 60);
        } else {
            g.fillRect(275, 120, 60, 60);
            g.setColor(Color.gray);
            g.fillOval(275, 120, 60, 60);
        }
~~~