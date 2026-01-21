package tasaDeCambio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final List<String> registros = new ArrayList<>();

    public static void agregarRegistro(double amount, String from, String to, double result) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String registro = timestamp + " - " + amount + " " + from + " = " + result + " " + to;
        registros.add(registro);
    }

    public static void mostrarHistorial() {
        if (registros.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
        } else {
            System.out.println("Historial de conversiones:");
            for (String registro : registros) {
                System.out.println(registro);
            }
        }
    }
}
