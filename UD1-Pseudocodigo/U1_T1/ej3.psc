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

Algoritmo ejercicio3corregido
	tam Es Entero
	
	Escribir "Introduce el tamaño del reloj de arena: "
	Leer tam
	
	Mientras tam%2=0 o tam<3 Hacer
		Escribir "Error. Vuelve a introducir el tamaño del reloj: "
		Leer tam
	Fin Mientras
	
	Para cont<-tam Hasta 1 Hacer
		Para i<-1 Hasta (tam-cont)/2 con paso 1 Hacer
			Escribir sin saltar " "
		Fin Para
		Para i<-cont Hasta 1 Hacer
			Escribir sin saltar "*"
		Fin Para
		Escribir ""
	Fin Para
	Para cont<-3 Hasta tam Con Paso 2 Hacer
		Para i<-1 Hasta (tam-cont)/2 con paso 1 Hacer
			Escribir sin saltar " "
		Fin Para
		Para i<-cont Hasta 1 Hacer
			Escribir sin saltar "*"
		Fin Para
		Escribir ""
	Fin Para
Fin Algoritmo
