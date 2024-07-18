# Proyecto Hilos con prioridades

setPriority es un método de Thread que hará que nuestros hilos tengan cierta prioridad con respecto al resto de hilos. Esto no será lo mismo que join(), ya que no estamos planificando lo que sucederá, sólo será una prioridad que pasaremos al planificador, pero será el planificador del sistema el que finalmente otorgue el orden de ejecución dependiendo de los recursos del sistema.

Al lío codificadores!