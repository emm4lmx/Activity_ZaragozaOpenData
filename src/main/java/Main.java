import java.util.List;

public class Main {
    public static void main(String[] args) {
        //start the application
        MonumentApp app = new MonumentApp();

        try {
            //fetch all the data from the JSON (50 items)
            MonumentResponse response = app.obtenerMonumentos(50);
            List<Monument> monuments = response.getResult();

            //header
            System.out.println("ZARAGOZA MONUMENTS");
            System.out.println("------------------------------------");

            System.out.println("total monuments reported by the API: " + response.getTotalCount());
            System.out.println("records received: " + monuments.size());
            System.out.println();

            int count = 0;
            Monument maxLatitude = null;
            Monument minLatitude = null;

            /**
             * @description: goes through all the monuments to display their information
             */
            for (int i = 0; i < monuments.size(); i++) {
                //object at position i
                Monument monument = monuments.get(i);

                System.out.println((i+1) + "." + monument.getTitle());
                System.out.println();
                System.out.println("opening information: " + monument.getHorario());

                if (monument.getGeometry() != null && monument.getGeometry().getCoordinates() != null) {
                    double latitud = monument.getGeometry().getLatitud();
                    System.out.println("coordinates: [" + monument.getGeometry().getLongitud() + ", " + latitud + "]");


                    //checks for the greatest latitude and store the corresponding monument

                    if (maxLatitude == null || latitud > maxLatitude.getGeometry().getLatitud()) {
                        maxLatitude = monument;
                    }

                    //store the monument with the smallest latitude in "minLatitude"
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
             * @description: prints the final summary:
             * number of monuments that contain the word "museo" on its title
             * museum with the greatest latitude
             * museum with the smallest latitude
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
