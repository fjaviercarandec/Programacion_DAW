Funcion res <- Ocurrencia ( matriz, num )
	totalocurrencia Es Entero
	Para i<-0 Hasta 9 Hacer
		Si matriz[i]=num Entonces
			totalocurrencia=totalocurrencia+1
		FinSi
	Fin Para
	res=totalocurrencia	
Fin Funcion

Funcion res <- Contiene ( matriz, num )
	sol Es Logico
	sol=falso
	Para i<-0 Hasta 9 Hacer
		Si matriz[i]=num Entonces
			sol=Verdadero
		FinSi
	Fin Para
	res=sol
Fin Funcion

Algoritmo ejercicio5
	num1,num2 Es Entero
	Dimension matriz[10]
	matriz[0]=2
	matriz[1]=2
	matriz[2]=5
	matriz[3]=2
	matriz[4]=2
	matriz[5]=6
	matriz[6]=7
	matriz[7]=2
	matriz[8]=2
	matriz[9]=10
	num1=5
	num2=2
	Escribir Contiene(matriz,num1)
	Escribir Ocurrencia(matriz,num2)
	
	
FinAlgoritmo
