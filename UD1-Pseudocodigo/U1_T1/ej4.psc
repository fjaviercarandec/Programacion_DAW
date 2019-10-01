Algoritmo ejercicio4
	eleccion Es Entero
	Dimension matriz[20]
	Para i<-0 Hasta 18 Hacer
		matriz[i]=AZAR(401)
		Escribir Sin Saltar matriz[i]," "
	Fin Para
	Escribir "¿Que numeros quiere resaltar? (1-Multiplos de 5) o (2-Multiplos de 7)"
	Leer eleccion
	Si eleccion=1 Entonces
		Para i<-0 Hasta 18 Hacer
			Si matriz[i]%5=0 Entonces
				Escribir matriz[i]," "
			FinSi
		Fin Para
	SiNo
		Si eleccion=2 Entonces
			Para i<-0 Hasta 18 Hacer
				Si matriz[i]%7=0 Entonces
					Escribir matriz[i]
				FinSi
			Fin Para
		FinSi
	FinSi
FinAlgoritmo
