Algoritmo ejercicio2
	num,posicion,nuevonum Es Entero
	numcadena,nuevonumcadena Es Caracter
	Escribir "Introduzca un numero entero positivo: "
	Leer num
	Escribir "Introduzca la posición dentro del número: "
	Leer posicion
	Escribir "Introduzca el nuevo dígito: "
	Leer nuevonum
	numcadena=ConvertirATexto(num)
	Para cont<-0 Hasta Longitud(numcadena) Hacer
		Si cont=posicion-1 Entonces
			Escribir Sin Saltar nuevonum
			cont=cont+1
		FinSi
		subnumero=Subcadena(numcadena,cont,cont)
		Escribir Sin Saltar subnumero
	FinPara
FinAlgoritmo
