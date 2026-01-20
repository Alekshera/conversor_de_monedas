import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConvierteMoneda {
    // Espacio para la API key (reemplaza con tu clave real)
    private static final String API_KEY = "e2912f7f4b63bfc597d0c020";

    // URI base de la API
    private static final String BASE_URI = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) throws IOException, InterruptedException {
        Conversor.eleccionUserMenu();
    }

    public static double obtenerTasa(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        // Construir la URI completa
        String urlFinal = BASE_URI + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency;

        // Setting URL
        URL url = new URL(urlFinal);

        // Making Request (HTTP client y request integrados)
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // HTTP response: obtener el contenido
        try (InputStream inputStream = (InputStream) request.getContent()) {
            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader(inputStream));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            double tasa = jsonobj.get("conversion_rate").getAsDouble();
            return tasa;
        }
    }
}
