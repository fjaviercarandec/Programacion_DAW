# U9_T2_MYSQL_Trabajando_con_la_base_de_datos_ClassicModels

U9_T2_Trabajando_con_la_base_de_datos_ClassicModels
---------------------------------------------------

Crea un programa que se conecte a esta BD

Debe tener:

* Una clase Employee
* Una clase Office
* Una clase ConexionBD que siga el patrón Singleton. Consulta este enlace:

https://hypsoftware.wordpress.com/2014/10/03/conexion-a-base-de-datos-mysql-con-singleton-pattern-java/

* Una clase de Acceso a Datos (clases AD) que se llame ADClassicModels. Esta clase tendrá:

    * Un constructor por defecto. (podemos no indicarlo expresamente y lo tendrá por defecto)
    * Tantos métodos como sean necesarios para acceder/modificar varios registros de las tablas, por ahora, para este ejercicio en concreto necesitaremos dos métodos con los siguientes prototipos:
        * public List<Employee> getEmpleados()
        * public List<Office> getOffices()

Cada uno de estos métodos obtendrá una variable Connection y tras obtener la conexión  ejecutará la query correspondiente, y tratará los resultados para devolver lo estipulado en el prototipo.

* Una clase Principal desde la que hagas las llamadas a los métodos que se necesiten de la clase anterior. Cuando termines de hacer acceso a datos, debes cerrar la conexión llamando al método close() de la clase ConexionBD.
