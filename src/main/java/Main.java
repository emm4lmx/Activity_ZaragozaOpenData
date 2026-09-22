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

            //cabezera
            System.out.println("ZARAGOZA MONUMENTS");
            System.out.println("------------------------------------");

            System.out.println("total monuments reported by the API: " + response.getTotalCount());
            System.out.println("records received: " + monuments.size());
            System.out.println();

            int count = 0;
            Monument maxLatitude = null;
            Monument minLatitude = null;

            for (int i = 0; i < monuments.size(); i++) {
                //objeto en la posicion i
                Monument monument = monuments.get(i);

                System.out.println((i+1) + "." + monument.getTitle());
                System.out.println();
                System.out.println("opening information: " + monument.getHorario());

                if (monument.getGeometry() != null && monument.getGeometry().getCoordinates() != null) {
                    System.out.println("coordinates: [" + monument.getGeometry().getLongitud() + ", " + monument.getGeometry().getLatitud() + "]");


                    //comprobacion de maxima latitud y min lat (variables)
                    if (1==1) {

                    }


                } else {

                }




            }
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            e.printStackTrace();
        }
    }
}
