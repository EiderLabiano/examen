import java.util.*;

/**
 *
 *
 *  La clase guarda en una colección map el histórico de puntuaciones obtenidas
 *  por una serie de jugadores en varias partidas de un juego
 *  La colección asocia el nombre de un jugador (la clave) con la relación
 *  de puntuaciones obtenidas por ese jugador (valores enteros)
 *
 *  Por ejemplo, para la clave "ANTIGOAL" se asocian los valores [44, 44, 125, 89, 23, 12, 78, 89]
 *  que son los puntos obtenidos por ese jugador en 7 partidas
 *
 *  Las claves se recuperan en orden alfabético. Los puntos asociados a cada
 *  jugador se recuperan en el orden en que se introducen 
 *
 */

public class Historico {
    TreeMap<String, ArrayList<Integer>> historicoPuntos = new TreeMap<>();

    /**
     * Constructor de objetos de la clase Historico
     */
    public Historico() {
       historicoPuntos = new TreeMap<>();
    }

    /**
     * Se registra en el map los puntos obtenidos por el
     * jugador en una partida 
     * Si el jugador ya existe únicamente solo hay que añadir
     * la nueva puntuación a las ya existentres
     * Si no existe se creará una nueva entrada con el nombre del jugador
     * y los puntos indicados 
     *
     * Las claves  siempre se añaden en mayusculas
     *
     */
    public void registrarPuntos(String jugador, int puntos) {
        jugador = jugador.toUpperCase();
        if (historicoPuntos.containsKey(jugador))
        {
            historicoPuntos.get(jugador).add(puntos);
        }
        else
        {
            ArrayList<Integer> aux = new ArrayList<>();
            aux.add(puntos);
            historicoPuntos.put(jugador, aux);
        }

    }

    /**
     * Devuelve una representación textual del map con
     * los nombres de los jugadores y la relación de puntos obtenidos
     * (leer enunciado)
     * En la representación textual observa que las puntuaciones están ordenadas
     * (pero la colección original no se modifica)
     *
     *
     * Usar el conjunto de entradas 
     * De forma eficiente ya que hay muchas concatenaciones
     *
     */
    public String toString() {
        //TODO

        return null;
    }

    /**
     *  Dado un jugador se devuelve su puntuación media
     *  Si no existe el jugador el valor devuelto es -1
     *
     */
    public double puntuacionMediaDe(String jugador) {
        String jugadores = jugador.toUpperCase();
        double media = 0;
        if (historicoPuntos.containsKey(jugadores))
        {

            for (Integer punto : historicoPuntos.get(jugadores)){
                media += punto;
            }
        } else{
            return -1;
        }
        return media/historicoPuntos.get(jugadores).size();
    }
    
    /**
     * Devuelve una colección que asocia nombres
     * de jugadores y su puntuación media
     * No importa el orden en que se obtengan los nombres
     * de jugadores
     *
     */
    public HashMap<String, Double> puntuacionesMedias() {
//        TreeMap<String, Double> listaMedias = new TreeMap<>();
//        Set<Map.Entry<String, ArrayList<Integer>>> entradas = historicoPuntos.entrySet();
//        Iterator<Map.Entry<String, ArrayList<Integer>>> it = entradas.iterator();
//        while (it.hasNext())
//        {
//            double a = puntuacionMediaDe(it.next().getKey());
//            listaMedias.put(it.next().getKey(), a);
//        }
//        return listaMedias;

//        Map<String, Double> medias = new HashMap<>();
//        for (String clave : historicoPuntos.keySet()) {
//            double listaMedia = puntuacionMediaDe(clave);
//            medias.put(clave, listaMedia);
//        }
//        return medias;
        HashMap<String, Double> mapMedias = new HashMap<>();
        for (String jugador : historicoPuntos.keySet())
        {
            mapMedias.put(jugador, puntuacionMediaDe(jugador));
        }
        return mapMedias;
    }


    /**
     *  Hay que borrar de las entradas correspondientes a los jugadores indicados
     *  aquellas puntuaciones menores a la proporcionada.
     *  Si después de borrar el jugador no tiene puntos asociados se elimina la entrada
     *  del map. El método devuelve el conjunto (no importa el orden) de
     *  jugadores cuyas entradas se han eliminado
     *
     *  Asumimos que los jugadores existen (no hay que comprobarlo)
     *
     *
     */
    public void borrarMenoresA(String[] jugadores, int puntos) {
        //TODO - deduce tipo de valor de retorno

    }

   

    /**
     *  Lee de un fichero de texto los datos de las jugadores y puntuaciones
     *  obtenidas y los añade al map
     */
    public void leerPuntuacionesDeFichero() {

        Scanner sc = null;
        try {
            sc = new Scanner(this.getClass().getResourceAsStream("/puntos.txt"));
            while (sc.hasNext()) {
                String linea = sc.nextLine().trim();
                String[] datos = linea.trim().split(":");
                for (String strPuntos : Arrays.copyOfRange(datos, 1, datos.length)) {
                    this.registrarPuntos(datos[0].trim(), Integer.parseInt(strPuntos.trim()));
                }

            }
        } finally {
            sc.close();

        }

    }
}
