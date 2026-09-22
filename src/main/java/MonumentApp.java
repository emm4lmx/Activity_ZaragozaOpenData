import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.PrimitiveIterator;

public class MonumentApp {
        /**
         * @description: El programa tiene que
         * Guardar la URL
         * Crear HttpClient
         * Crear HttpRequest con GET
         * Enviar
         * Recibir HttpResponse<String>
         * Comprobar status code
         * Capturar el body como texto
         * Mostrar error claro si falla
         */
        private final String URL = "https://www.zaragoza.es/sede/servicio/monumento.json?rows=50&fl=title,horario,geometry";

        HttpClient client;
        private ObjectMapper mapper;

        public MonumentApp() {
            //inicio el objectmapper y el client
            mapper = new ObjectMapper();
            client = HttpClient.newHttpClient();
        }

        /**
         *
         * @param rows
         * @return MonumentResponse
         * @throws Exception
         * @description: las excepciones las manejo en el Main
         */
        public MonumentResponse obtenerMonumentos(int rows) throws Exception {

            //construyo la petición GET
            HttpRequest request = HttpRequest.newBuilder(URI.create(URL)).build();

            //envio y recibo la respuesta como String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("HTTP ERROR: " + response.statusCode());
            }
            //saco el cuerpo del json
            String json = response.body();
            //deserializo el json y lo mapeo como MonumentResponse
            //readValue(File, Class)
            return mapper.readValue(json, MonumentResponse.class);
        }
}
