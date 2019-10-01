Algoritmo ejercicio1
	horas,sueldo Es Entero
	Escribir "Introduzca el número de horas trabajadas durante la semana: "
	Leer horas
	Si horas<=40 Entonces
		sueldo=horas*10
	SiNo
		sueldo=40*10
		sueldo=(horas-40)*15+sueldo
	FinSi
	Escribir "El sueldo semanal que le corresponde es de ",sueldo
	
FinAlgoritmo
