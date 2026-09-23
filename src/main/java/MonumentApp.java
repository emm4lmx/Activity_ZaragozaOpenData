import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MonumentApp {
        /**
         * @description: this program has to:
         * - store the URL
         * - create HttpClient
         * - create HttpRequest with GET
         * - send the request
         * - receive HttpResponse<String>
         * - check status code
         * - capture body as text
         * - show the error if it fails
         * @author: Emma Lamadrid Cruz
         */

        private final String URL = "https://www.zaragoza.es/sede/servicio/monumento.json?rows=50&fl=title,horario,geometry";
        HttpClient client;
        private ObjectMapper mapper;

        /**
         * initializes the ObjectMapper and the HttpClient.
         */
        public MonumentApp() {
            //inicio el objectmapper y el client
            mapper = new ObjectMapper();
            client = HttpClient.newHttpClient();
        }

        /**
         * @param rows
         * @return MonumentResponse
         * @throws Exception
         * @description: método para obtener los monumentos
         * (las excepciones las manejo en el Main)
         */
        /**
         * @description: fetches the list of monuments from the API.
         * exceptions are handled on the Main class
         * @param rows the number of monuments to request
         * @return the parsed MonumentResponse
         * @throws Exception if the HTTP call fails or the JSON cannot be parsed
         */
        public MonumentResponse obtenerMonumentos(int rows) throws Exception {

            //build the get request GET
            HttpRequest request = HttpRequest.newBuilder(URI.create(URL)).build();

            //send the request and receive the response as a String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("HTTP ERROR: " + response.statusCode());
                //throw so that execution does not continue
                throw new RuntimeException();
            }
            //extract the JSON body
            String json = response.body();
            //deserialize the JSON and map it to a MonumentResponse
            //readValue(File, Class)
            return mapper.readValue(json, MonumentResponse.class);
        }
}
