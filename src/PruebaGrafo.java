import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class PruebaGrafo {

    public static void main(String[] args) {
        /*

              TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos_1.txt","./src/conexiones_1.txt",
                false, TGrafoDirigido.class);

            Object[] etiquetasarray = gd.getEtiquetasOrdenado();

            Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
            UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
            Double[][] mfloyd = gd.floyd();
            UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
            for (int i = 0; i < etiquetasarray.length; i++) {
                System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
            }
            System.out.println();
            System.out.println("Centro del grafo: " + gd.centroDelGrafo());
         */

              //Ejercicio 1
              TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos.txt","./src/conexiones.txt",
                false, TGrafoDirigido.class);

            Object[] etiquetasarray = gd.getEtiquetasOrdenado();

            Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
            UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
            Double[][] mfloyd = gd.floyd();
            UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
            for (int i = 0; i < etiquetasarray.length; i++) {
                System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
            }
            System.out.println();
            System.out.println("Centro del grafo: " + gd.centroDelGrafo());
        /*

        ArrayList<TVertice> vertices = new ArrayList<>();
        ArrayList<TArista> aristas = new ArrayList<>();

        TVertice vertice1 = new TVertice("Artigas");
        TVertice vertice2 = new TVertice("Canelones");
        TVertice vertice3 = new TVertice("Durazno");

        TVertice vertice4 = new TVertice("Florida");
        TVertice vertice5 = new TVertice("Montevideo");
        TVertice vertice6 = new TVertice("Punta del Este");
        TVertice vertice7 = new TVertice("Rocha");
        vertices.add(vertice1);
        vertices.add(vertice2);
        vertices.add(vertice3);
        vertices.add(vertice4);
        vertices.add(vertice5);
        vertices.add(vertice6);
        vertices.add(vertice7);

        TArista arista = new TArista("Artigas", "Rocha", 400);
        TArista arista1 = new TArista("Canelones", "Artigas", 500);
        TArista arista2 = new TArista("Canelones", "Colonia", 200);
        TArista arista3 = new TArista("Canelones", "Durazno", 170);
        TArista arista4 = new TArista("Canelones", "Punta del Este", 90);
        TArista arista5 = new TArista("Colonia", "Montevideo", 180);
        TArista arista6 = new TArista("Montevideo", "Artigas", 700);
        TArista arista7 = new TArista("Montevideo", "Canelones", 30);
        TArista arista8 = new TArista("Montevideo", "Punta del Este", 130);
        TArista arista9 = new TArista("Punta del Este", "Rocha", 90);
        TArista arista10 = new TArista("Rocha", "Montevideo", 270);
        TArista arista11 = new TArista("Florida", "Durazno", 60);

        aristas.add(arista);
        aristas.add(arista1);
        aristas.add(arista2);
        aristas.add(arista3);
        aristas.add(arista4);
        aristas.add(arista5);
        aristas.add(arista6);
        aristas.add(arista7);
        aristas.add(arista8);
        aristas.add(arista9);
        aristas.add(arista10);
        aristas.add(arista11);

        TGrafoDirigido grafoDirigido = new TGrafoDirigido(vertices, aristas);
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(grafoDirigido.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafoDirigido.getVertices(), "matriz Ejercicio 1");

        Double[][] matrizFloyd = grafoDirigido.floyd();
        UtilGrafos.imprimirMatrizMejorado(matrizFloyd, grafoDirigido.getVertices(), "Matriz de costos mínimos FLOYD");
         */

        /*
            Preguntas ejercicio1:

            El costo de volar de Montevideo a Rio de Janeiro es:
            a. 1980.
            b. 3780.-Correcto
            c. 1000.
            d. 980.

            El costo de volar de Montevideo a Curitiba es:
            a. 2580-Correcto
            b. 3780.
            c. 1980.
            d. Ninguna de las anteriores

            3. Los servicios de mantenimiento se instalan en:
            a. Montevideo
            b. Punta del Este
            c. Curitiba -Correcto
            d. Porto Alegre

            Supongo que se referirá al centro el grafo
         */
    }
}
