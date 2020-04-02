# U8_T1_Entregable_1920:Recorrido_XML_con_SAX_y_DOM

U8_T1_RECORRIDO_XML_SAX_Y_DOM
-----------------------------

Siguiendo el vídeo y los materiales debéis hacer lo siguiente:

* Construir un XML que tenga  al menos 3 niveles, es decir, un nodo raíz, etiquetas hijas y etiquetas nietas. Debe haber al menos 5 etiquetas hijas y 3 etiquetas nietas para cada una   de esas etiqueta hijas (todas ellas con contenido). Todas las etiquetas hijas deben tener algún atributo. Algo similar al ejemplo de personasXML.xml
* Crear una clase RecorridoSax en cuyo método main se recorra ese fichero utilizando Sax y lo muestre por pantalla.
* Crear una clase RecorridoDOM que desde su main invoque a los siguiente métodos (que debéis también crear):
    * numNodosHijos() que mostrará por pantalla el número de nodos hijos (descendientes directos del nodo raíz) y el tipo de cada uno de esos nodos (etiqueta, texto, comentario)
    * mostrarXMLDom() que mostrará por pantalla el contenido del fichero XML llegando únicamente al primer nivel. A partir de ahí puedo mostrar el contenido completo de los nodos.
    * mostrarContenidoEtiqueta(Element e) que recibe como parámetro un element (etiqueta) y recorrerá los hijos de todas y cada una de las ocurrencias de esas etiquetas mostrando el contenido de los mismos. Si no hay ninguna ocurrencia de esa etiqueta (element) deberá mostrar un mensaje de aviso


