Algoritmo ejercicio3
	altura Es Entero
	Escribir "Por favor, introduzca la altura del reloj de arena: "
	Leer altura
	Si altura%2=0 O altura<3 Entonces
		Escribir "ERROR. El numero debe ser impar y mayor o igual que 3."
	SiNo
		Para cont<-1 Hasta altura Con Paso 2 Hacer
			Escribir ""
			Para cont2<-altura Hasta cont Con Paso -1 Hacer
				Escribir Sin Saltar "*"
			Fin Para
		Fin Para
		Para cont<-3 Hasta altura Con Paso 2 Hacer
			Escribir ""
			Para cont2<-1 Hasta cont Con Paso 1 Hacer
				Escribir Sin Saltar "*"
			Fin Para
		Fin Para
		Escribir ""
	FinSi

FinAlgoritmo
