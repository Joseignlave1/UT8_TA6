# UT8_TA5

UNIDAD TEMÁTICA 8 – GRAFOS NO DIRIGIDOS– Trabajo de Aplicación 5
EJERCICIO 1 – otra aplicación de la búsqueda en Amplitud–
ESCENARIO
El objeto del juego Kevin Bacon consiste en vincular a un actor con Kevin Bacon a través de películas en las que
hayan trabajado juntos. El número mínimo de vínculos es el número de Bacon de un actor. Por ejemplo, Tom Hanks
tiene un número de Bacon de 1, pues trabajó con Kevin Bacon en Apolo 13. Sally Field tiene un número de Bacon 2
porque trabajó en Forest Gump con Tom Hanks, que a su vez trabajó en Apolo 13 con Kevin Bacon. Casi todos los
actores más conocidos tienen un número de Bacon de 1 o 2. Supongamos que hemos decidido representar estas
relaciones mediante un grafo no dirigido, y contamos con una lista de actores y otra de relaciones entre los mismos
(la relación entre dos actores directa sería una película y, para simplificar, añadiremos la restricción que dos actores
sólo pueden estar directamente relacionados en una película).
PREPARACION - trabajaremos en sub-equipos, separados
1. Descarga de la webasignatura el proyecto completo “TA5.zip” y descomprímelo en una carpeta del disco
duro local.
2. Abre el Proyecto. Verifica que las referencias internas a los paquetes sean correctas.
3. Observa todas las clases e interfaces provistas en el Proyecto.
4. Observa el archivo principal “Programa.java”, contiene prácticamente todas las invocaciones que serán
necesarias.
5. La implementación requerida ha de cumplir con la interfaz entregada.
SE REQUIERE:
Dado un TDA GrafoNoDirigido con las características y operaciones habituales, y en el cual has de representar
actores (la etiqueta es una string) y relaciones (arcos que indican películas en que trabajan juntos), deberás
1. Implementar un método del grafo numBacon (String Actor) que, dado un cierto Actor (identificado por su
nombre) encuentre su número de Bacon (existe un actor representado en el grafo con nombre
“Kevin_Bacon”). Implementar el método del vértice correspondiente.
2. Desarrolla los casos de prueba (“test cases”) necesarios para verificar la corrección de los métodos
implementados.
3. Implementa un programa principal que:
a. Cargue el Grafo con los Vértices contenidos en el archivo “actores.csv”.
b. Cargue las Aristas contenidas en el archivo “en_películas.csv”.
c. Invoque la operación “numBacon” del grafo, con los parámetros indicados más abajo, emitiendo por
consola el resultado.
4. Ejecuta el programa y anota en esta hoja el resultado de las invocaciones. Registra este mismo resultado en
el archivo “salida.txt” que has de adjuntar al código completo.
Número de Bacon para los siguientes actores:
• John_Goodman
• Tom_Cruise
• Jason_Statham
• Lukas_Haas
• Djimon_Hounsou
EJERCICIO 2 –
REVISION POR PARES DEL CODIGO DESARROLLADO E INTEGRACION EN GITHUB – 15 minutos
