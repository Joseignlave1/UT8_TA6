Ejercicio 1:
Una empresa constructora se encuentra desarrollando un barrio suburbano residencial, en el que las casas se
encuentran dispersas en forma no estructurada sobre un área relativamente extensa. El subcontratista eléctrico ha
presentado un plano de conexión eléctrica de las residencias con un costo que ha sido juzgado demasiado alto, ya
que, a juicio del CEO de la empresa constructora, no optimiza la cantidad de cable necesaria.
Consultado el Gerente de Sistemas de Información, dice tener la solución necesaria para resolver el problema,
solución conocida por cualquier ingeniero o licenciado en informática, y nos encarga el desarrollo de esa
funcionalidad. Solamente necesita tener un plano del terreno en el que se puedan medir las distancias entre todas
las casas y la sub estación de energía eléctrica.
1. Describe en lenguaje natural la solución al problema (solución general y modelo)
2. Define las estructuras de datos necesarias para representar el TDA y eventualmente las auxiliares
necesarias para la resolución.
3. Escribe un seudocódigo de alto nivel sobre las estructuras definidas.
4. Analiza el orden del tiempo de ejecución de la aplicación escrita.


1-Representando los datos en un TGrafoNoDirigido y Dado que lo que queremos saber es la distancia de la sub estación eléctrica a todas las otras casas del vecindario, creo que lo óptimo es aplicar el algoritmo de Prim, empezando desde el vértice que representa la sub estación eléctrica, para encontrar el camino más corto entre la sub estación eléctrica y todas las otras casas del vecindario.


2-Estructuras de datos necesarias
-Un conjunto de vértices V

-Un conjunto de aristas T, en este conjunto vamos a almacenar las aristas que forman el AAM

-un conjunto de vértices U, en este conjunto voy a ir agregando un vértice de V tal que V - U 


3-Pseudocódigo:


V = Conjunto de vértices representados por la subestación eléctrica y todas las otras casas del vecindario.

T = Conjunto de aristas, al principio vacío. utilizadas para almacenar las aristas que van a ser incluídas en el AAM

U = nuevoConjuntoVertices()  // Conjunto de vértices incluidos en el AAM

aristaMenorCosto = null

U.añadir(VerticeSubEstacionElectrica)  

mientras U <> V hacer
  menorCosto = maximoValorDouble  // Utilizar un valor grande para la primera iteración

  para cada arista a en obtenerAristas()  // Obtener todas las aristas del grafo
    origen = buscarVertice(a.etiquetaOrigen)
    destino = buscarVertice(a.etiquetaDestino)

    si origen está en U y destino no está en U y el costo de a es menor a menorCosto entonces
      menorCosto = a.ObtenerCosto()
      aristaMenorCosto = a
    fin si
  fin para cada

  T.añadir(aristaMenorCosto)  // Añadir la arista de menor costo al conjunto T
  U.añadir(buscarVertice(aristaMenorCosto.etiquetaDestino))  // Añadir el vértice de destino al conjunto U

fin mientras

devolver nuevoGrafoNoDirigido(U, T)  


// Función auxiliar para buscar un vértice dado su etiqueta
función buscarVertice(unaEtiqueta)
  devolver vertices.obtener(unaEtiqueta)
fin función



Tiempo de ejecución = O(V * E)





ALGORITMO CON MEJOR TIEMPO DE EJECUCIÓN UTILIZANDO UNA COLA DE PRIORIDADES:


V = Conjunto de vértices representados por la subestación eléctrica y todas las otras casas del vecindario.

T = Conjunto de aristas, al principio vacío.

U = nuevoConjuntoVertices()  // Conjunto de vértices incluidos en el AAM

colaDePrioridad = nuevaColaDePrioridad()  // Cola de prioridad para seleccionar aristas de menor costo

U.añadir(VerticeSubEstacionElectrica)
para cada arista a conectada a VerticeSubEstacionElectrica hacer
  colaDePrioridad.insertar(a, a.ObtenerCosto())
fin para cada

mientras U ≠ V hacer
  aristaMenorCosto = colaDePrioridad.extraerMin()  // Extraer la arista de menor costo

  si aristaMenorCosto.destino no está en U entonces
    T.añadir(aristaMenorCosto)  // Añadir la arista de menor costo al conjunto T
    U.añadir(aristaMenorCosto.destino)  // Añadir el vértice de destino al conjunto U

    para cada arista a conectada a aristaMenorCosto.destino hacer
      si a.destino no está en U entonces
        colaDePrioridad.insertar(a, a.ObtenerCosto())
      fin si
    fin para cada
  fin si
fin mientras

devolver nuevoGrafoNoDirigido(U, T)  // Crear y devolver el nuevo grafo con los vértices y aristas del AAM

// Función auxiliar para buscar un vértice dado su etiqueta
función buscarVertice(unaEtiqueta)
  devolver vertices.obtener(unaEtiqueta)
fin función


Tiempo de ejecución: O((V + E) log V),
