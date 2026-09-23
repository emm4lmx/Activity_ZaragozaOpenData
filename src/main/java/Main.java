import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //inicio la aplicacion
        MonumentApp app = new MonumentApp();

        try {
            //saco todos los datos del json (50)
            MonumentResponse response = app.obtenerMonumentos(50);
            List<Monument> monuments = response.getResult();

            //cabecera
            System.out.println("ZARAGOZA MONUMENTS");
            System.out.println("------------------------------------");

            System.out.println("total monuments reported by the API: " + response.getTotalCount());
            System.out.println("records received: " + monuments.size());
            System.out.println();

            int count = 0;
            Monument maxLatitude = null;
            Monument minLatitude = null;

            /**
             * @description: recorre monumentos para mostrar información
             */
            for (int i = 0; i < monuments.size(); i++) {
                //objeto en la posicion i
                Monument monument = monuments.get(i);

                System.out.println((i+1) + "." + monument.getTitle());
                System.out.println();
                System.out.println("opening information: " + monument.getHorario());

                if (monument.getGeometry() != null && monument.getGeometry().getCoordinates() != null) {
                    double latitud = monument.getGeometry().getLatitud();
                    System.out.println("coordinates: [" + monument.getGeometry().getLongitud() + ", " + latitud + "]");


                    //comprobacion de maxima latitud y min lat (variables)

                    if (maxLatitude == null || latitud > maxLatitude.getGeometry().getLatitud()) {
                        maxLatitude = monument;
                    }

                    //almaceno el objeto que tiene menor latitud en la veriable minLatitude
                    if (minLatitude ==  null || latitud < minLatitude.getGeometry().getLatitud()){
                        minLatitude = monument;
                    }

                } else {
                    System.out.println("Coordenadas introducidas no válidas.");
                }

                if (monument.getTitle().toLowerCase().contains("museo")){
                    count++;
                }
                System.out.println();
            }

            /**
             * @description: musestra un resumen final con los datos:
             * numero de monumentos que contienen la palabra "museo" en su título
             * museo con la mayor latitud
             * museo con la menor latitud
             */
            System.out.println("-----------------------------------");
            System.out.println("Monuments containing 'Museo' in the title: " + count);
            System.out.println();
            System.out.println("Greatest second coordinate: \n>>>> Monument: " + maxLatitude.getTitle() + " --> Latitud: " + maxLatitude.getGeometry().getLatitud());
            System.out.println("Smallest second coordinate: \n>>>> " + minLatitude.getTitle() + " --> Latitud: " + minLatitude.getGeometry().getLatitud());


        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            e.printStackTrace();
        }
    }
}
