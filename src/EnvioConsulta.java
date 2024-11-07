import java.util.InputMismatchException;
import java.util.Scanner;

public class EnvioConsulta {

    Scanner escaner = new Scanner(System.in);
    ConsultaAPI consultaAPI = new ConsultaAPI();
    int monto;

    public void enviarConsulta(String monedaBase, String monedaFinal){
        boolean entradaValida = false;

        // Repetir hasta que se ingrese un monto válido
        while (!entradaValida) {
            try {
                System.out.println("Ingrese el monto a convertir:");
                monto = escaner.nextInt();

                if (monto <= 0) {
                    System.out.println("El monto debe ser mayor que cero. Intenta nuevamente.");
                } else {
                    entradaValida = true; // Se ha ingresado un monto válido
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un valor entero. Intenta nuevamente.");
                escaner.next();  // Limpiar el buffer del scanner para permitir una nueva entrada
            }
        }
            //Realiza consulta a la API con los valores capturados
            Moneda consulta = consultaAPI.buscaMoneda(monedaBase, monedaFinal, monto);

            //muestra en pantalla y en limpio la conversión final
            System.out.println("\n------> " + monto + "[" + monedaBase + "] son " + String.format("%.2f", consulta.conversion_result()) + "[" + monedaFinal + "]\n");
    }
}
