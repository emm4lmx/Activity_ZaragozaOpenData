import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //inicio la aplicacion
        MonumentApp app = new MonumentApp();

        try {
            //saco todos los datos del json (50)
            MonumentResponse response = app.obtenerMonumentos(50);
            List<Monument> monuments = response.getMonuments();

            System.out.println("ZARAGOZA MONUMENTS");
            System.out.println();

            System.out.println("Total documents: " + response.getMonuments());



        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }
}
