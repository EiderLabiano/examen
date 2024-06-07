import java.util.Arrays;

public class TestHistorico {

    /**
     *  Test de la clase Historico
     *
     */
    public static void main(String[] args) {
        Historico historico = new Historico();

        // probando leerPuntuacionesDeFichero() registrarPuntos() y toString()
        testLeerPuntuaciones(historico);

        System.out.println("\n--------------------------------------");

        // test para probar puntuacionMediaDe()        
        //testPuntuacionMediaDe(historico, "Dina Mite");
        //testPuntuacionMediaDe(historico, "Leidi Guga");
        //testPuntuacionMediaDe(historico, "Gerun");

        System.out.println("\n--------------------------------------");
        //testPuntuacionesMedias(historico);

        System.out.println("\n--------------------------------------");
        //       test para probar borrarMenoresA()
        String[] jugadores = {"Dina Mite", "Bilieilisha", "Loboutine"};
        //testBorrarMenoresA(historico, jugadores, 50);


    }

    public static void testLeerPuntuaciones(Historico historico) {
        historico.leerPuntuacionesDeFichero();
        System.out.println(historico);

    }

    public static void testPuntuacionMediaDe(Historico historico, String jugador) {
        double media = historico.puntuacionMediaDe(jugador);
        if (media != -1) {
            System.out.println("Media puntos de " + jugador.toUpperCase() + " = " +
                    String.format("%.2f", historico.puntuacionMediaDe(jugador)));
        } else {
            System.out.println("Jugador " + jugador.toUpperCase() + " no existe");
        }

    }

/*    public static void testBorrarMenoresA(Historico historico, String[] jugadores, int puntos) {
        System.out.println("Borrando puntuaciones menores a " + puntos
                + " de jugadores " + Arrays.asList(jugadores));
        System.out.println("\nSe han borrado las entradas: " +
                historico.borrarMenoresA(jugadores, puntos));
        System.out.println("\nDespués de borrar el histórico queda\n" + historico);

    }

    public static void testPuntuacionesMedias(Historico historico) {
        System.out.println("Puntuaciones medias de todos los jugadores ");
        System.out.println(historico.puntuacionesMedias());


    }*/
}
