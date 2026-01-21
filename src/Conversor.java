import tasaDeCambio.Historial;

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
            boolean continuar = true;
            while (continuar) {
                System.out.println("=========================================" + "\n" +
                        "Ingresa la moneda origen (ej. USD): ");
                String from = scanner.nextLine().toUpperCase();
                System.out.println("Ingresa la moneda destino (ej. EUR): ");
                String to = scanner.nextLine().toUpperCase();
                System.out.println("Ingresa la cantidad (sin puntos ni comas): ");
                double amount = scanner.nextDouble();
                scanner.nextLine();//Siguiente linea


                try {
                    double rate = ConvierteMoneda.obtenerTasa(from, to);
                    double result = amount * rate;
                    Historial.agregarRegistro(amount, from, to, result);
                    System.out.println(amount + " " + from + " = " + result + " " + to + "\n" +
                    "=========================================");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

                boolean respuestaValida = false;
                while (!respuestaValida) {

                    System.out.println("¿Quieres hacer otra conversión? (¿si o no?): " +
                            "\n" + "¿O quieres ver el historial?(escribe 2)");
                    String respuesta = scanner.nextLine().toLowerCase();
                    if (respuesta.equals("si")) {
                        respuestaValida = true;
                    } else if (respuesta.equals("2")) {
                        Historial.mostrarHistorial();
                        respuestaValida = true;
                    } else if (respuesta.equals("no")) {
                        continuar = false;
                        respuestaValida = true;
                    } else {
                        System.out.println("Opción inválida. Ingresa si, no o el numero 2.");
                    }
                }
            }

            scanner.close();
        }

    }