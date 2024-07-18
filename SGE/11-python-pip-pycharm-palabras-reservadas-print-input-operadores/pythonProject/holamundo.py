print('Hola Mundo')
# Este es un comentario mono-línea
"""
Y este es un comentario multi-línea
"""
varObj = 'Hola'
varObjInt = 0

print(type(varObj))
print(type(varObjInt))

# Casting
varInt = 2
varFloat = 2.0
varStr = "2"

print("tipo str " + varStr)
print(type(int(varStr))) # casting a int desde String
print("tipo int " + str(varInt))
print(type(float(varInt))) # casting a float desde int
print("tipo float " + str(varFloat))
print(type(str(varFloat))) # casting a String desde float

test = input("¿Cual es tu nombre? \n")
# f string
print(f"Te llamas {test}")

print(test, ", ¿tienes ", 46, " años?")
edad = int(input("¿Qué edad tienes? \n"))
print(f"Te quedan {100 - edad} años para llegar a los 100")

fruta = "manzana"
precio = 2.0
cantidad = 8

print(f"El coste de la {fruta} es {precio}. \n"
      f"Precio total de 8 {fruta}s: {precio * cantidad}")

"""
La función Print tiene parámetros 
como end y sep. Por ejemplo, 
podemos especificar un separador y un finalizador.
"""
print("Hola", "Adiós", sep="...", end="---")
print("\n")

"""
F-Strings:
Desde la versión 3.6, se introdujo el fstring. 
Se coloca una F antes del texto y permite incluir 
expresiones directamente dentro del string.
"""

# Tipado dinámico
var = 1 # aquí la variable es de tipo numérico
var = "Hola mundo" # aquí la variable pasa a ser de tipo cadena

# CONSTANTES
CONSTANTE = 3

# otro ejemplo de print con fstring y operandos
op1 = int(input("Operando 1: "))
op2 = int(input("Operando 2: "))

print(f"{op1}+{op2}=",(op1 + op2))
print(f"{op1}*{op2}=",(op1 * op2))


EDAD_A_ALCANZAR = 100
edad = int(input("¿Cuál es su edad?"))
falta = EDAD_A_ALCANZAR - edad
print("Le faltan", falta, "años para alcanzar los", EDAD_A_ALCANZAR)