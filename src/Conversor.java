import java.util.Scanner;


    import java.util.Scanner;

    public class Conversor {
        public static void eleccionUserMenu() {

            System.out.println("\n");
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║              CONVERSOR DE MONEDAS - MENÚ               ║");
            System.out.println("╠════════════════════════════════════════════════════════╣");
            System.out.println("║ Monedas Mas Solicitadas:*                              ║");
            System.out.println("║  [INR]  Rupia india         [CNY]  Yuan chino          ║");
            System.out.println("║  [COP]  Peso colombiano     [USD]  Dólar USA           ║");
            System.out.println("║  [MXN]  Peso mexicano       [CAD]  Dólar canadiense    ║");
            System.out.println("║  [AUD]  Dólar australiano   [BRL]  Real brasileño      ║");
            System.out.println("║  [PLN]  Złoty polaco        [EUR]  Euro                ║");
            System.out.println("║  [GBP]  Libra esterlina     [JPY]  Yen japonés         ║");
            System.out.println("║  [KRW]  Won surcoreano      [RUB]  Rublo ruso          ║");
            System.out.println("║  *Tambien puedes buscar otras monedas diferentes.      ║");
            System.out.println("╠════════════════════════════════════════════════════════╣");
            System.out.println("║ Ejemplos de conversión:                                ║");
            System.out.println("║ • USD → EUR  (Dólar a Euro)                            ║");
            System.out.println("║ • COP → USD  (Peso colombiano a Dólar)                 ║");
            System.out.println("║ • MXN → EUR  (Peso mexicano a Euro)                    ║");
            System.out.println("╚════════════════════════════════════════════════════════╝\n");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa la moneda origen (ej. USD): ");
            String from = scanner.nextLine().toUpperCase();
            System.out.println("Ingresa la moneda destino (ej. EUR): ");
            String to = scanner.nextLine().toUpperCase();
            System.out.println("Ingresa la cantidad(sin puntos ni comas): ");
            double amount = scanner.nextDouble();

            try {
                double rate = ConvierteMoneda.obtenerTasa(from, to);
                double result = amount * rate;
                System.out.println(amount + " " + from + " = " + result + " " + to);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

