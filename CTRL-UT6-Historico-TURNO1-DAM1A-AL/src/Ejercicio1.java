import java.util.*;


public class Ejercicio1 {




    /*    Este método devuelve un array cuyos valores
       serán los strings con más longitud
       de cada valor clave correspondiente del parámetro HashMap*/
    public static String[] metodo1(HashMap<String, HashSet<String>> coleccion){
        String[] miArray = new String[coleccion.size()];
        int cont = 0;
        for(String clave : coleccion.keySet())
        {
            String aux = "";


            for (String value : coleccion.get(clave))
            {
                if (aux.length() > value.length())
                {
                    aux = value;
                }
            }
            miArray[cont] = aux;
            cont++;
        }
        return miArray;
    }




    public static void main(String[] args){


        HashMap<String, HashSet<String>> coleccionGenerica = new HashMap<>();
        HashSet<String> colorset = new HashSet<>();
        colorset.add("rojo");
        colorset.add("Amarillo");
        colorset.add("Azul");
        colorset.add("Verde");
        coleccionGenerica.put("Colores", colorset);
    }


}

