import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaAPI {

    public Moneda buscaMoneda (String monedaBase, String monedaFinal, int monto){

        //Obtenemos el valor de la apiKey desde las variables de entorno
        String apiKey = System.getenv("EXCHANGE_API_KEY");

        //Corroboramos que se haya guardado correctamente
        if (apiKey == null || apiKey.isEmpty()){
            throw new RuntimeException("La clave de la API no esta configurada en las variables de entorno");
        }

        //Declaración de la URL a realizar la consulta
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"+monedaBase+"/"+monedaFinal+"/"+monto);

        //Construyendo el cliente para solicitudes
        HttpClient client = HttpClient.newHttpClient();

        //Construyendo la solicitud
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            //Construyendo la respuesta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //Devuelve la info json de la respuesta de la API trasnformada en el Record "Moneda" para rescatar los datos de interes.
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
