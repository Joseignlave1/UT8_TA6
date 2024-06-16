
import java.lang.reflect.Array;
import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido,IGrafoKevinBacon {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        LinkedList<TArista> conjuntoAristas = PrimAuxiliar();
        Collection<TVertice> v = getVertices().values();
        TGrafoNoDirigido grafoMenorCosto = new TGrafoNoDirigido(v,conjuntoAristas);
        return grafoMenorCosto;
    }
    public LinkedList<TArista> PrimAuxiliar() {
        Set<TVertice> V = new HashSet<>(this.getVertices().values());
        LinkedList<TArista> T = new LinkedList<>();
        Set<TVertice> U = new HashSet<>();
        for(TVertice v : getVertices().values()) {
            U.add(v);
            break;
        }
        while(U.size() != V.size()) {
            double menorCosto = Double.MAX_VALUE;
            TArista aristaDeMenorCosto = null;
            LinkedList<TArista> todasLasaristasDelGrafo = this.getLasAristas();
            for(TArista a : todasLasaristasDelGrafo) {
                Set<TVertice> diferencia = new HashSet<>(V);
                diferencia.removeAll(U);
                TVertice origen = buscarVertice(a.etiquetaOrigen);
                TVertice destino = buscarVertice(a.etiquetaDestino);
                if(U.contains(origen) && diferencia.contains(destino) && a.getCosto() < menorCosto && !T.contains(a)) {
                    menorCosto = a.getCosto();
                    aristaDeMenorCosto = a;
                }
            }
            T.add(aristaDeMenorCosto);
            TVertice ver = buscarVertice(aristaDeMenorCosto.etiquetaDestino);
            U.add(ver);
        }
        return T;
    }


    @Override
    public TGrafoNoDirigido Kruskal() {
        return kruskalAuxiliar();
    }

    public TGrafoNoDirigido kruskalAuxiliar() {
        //Creamos el AAM(Arbol abarcador de costo mínimo)
        TGrafoNoDirigido AAM = new TGrafoNoDirigido(getVertices().values(), new TAristas());
        TAristas aristasSinOrdenar = lasAristas;

        //Primero ordenamos las aristas de menor a mayor por costo, así no tenemos que estár siempre buscando la menor en cada iteracción

        aristasSinOrdenar.sort((TArista arista1, TArista arista2) -> {
            if(arista1.costo < arista2.costo) {
                return -1;
            } else if(arista1.costo > arista2.costo) {
                return 1;
            } else {
                return 0;
            }
        });

        TAristas aristasOrdenadas = new TAristas();
        aristasOrdenadas.addAll(aristasSinOrdenar);

        int aristasAgregadasAlAMM = 0;

        //Arbol de N VERTICES, n - 1 aristas, SI NO SE AGREGARON TODAS LAS ARISTAS AL AAM
        while(aristasAgregadasAlAMM != getVertices().size() - 1) {
            TArista aristaMinima = aristasOrdenadas.removeFirst();
            TVertice verticeOrigen = AAM.getVertices().get(aristaMinima.getEtiquetaOrigen());
            TVertice verticeDestino = AAM.getVertices().get(aristaMinima.getEtiquetaDestino());
            if(!AAM.estanConectados(verticeOrigen.getEtiqueta(), verticeDestino.getEtiqueta())) {
                AAM.insertarArista(aristaMinima);
                //Agrego también la inversa de la arista mínima ya qué para representar una conexión entre dos vértices en un
                //Grafo no dirigido es bidireccional de B a A se representa como B -> A Y A -> B
                AAM.getLasAristas().add(aristaMinima.aristaInversa());
                aristasAgregadasAlAMM++;
            }
        }
        return AAM;
    }

    private boolean estanConectados(Comparable etiquetaVertice1, Comparable etiquetaVertice2) {
        TVertice v = buscarVertice(etiquetaVertice1);
        //Si son  adyacentes(están conectados)
        if(v.buscarAdyacencia(etiquetaVertice2) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<TVertice> bea() {
        return List.of();
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	 
	@Override
	public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	@Override
    public boolean esConexo(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numBacon(Comparable actor) {
        desvisitarVertices();
        TVertice kevinBacon = getVertices().get("Kevin_Bacon");
        if(kevinBacon != null) {
            return kevinBacon.numBacon(actor.toString());
        } else {
            return -1;
        }
    }
}
