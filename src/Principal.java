import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        boolean condicion = true;
        EnvioConsulta envio = new EnvioConsulta();
        ConversionExtraOrigen conversionExtra = new ConversionExtraOrigen();

        System.out.println("Bienvenido al Conversor de monedas de Facundo Costamagna.\n");

        //bucle while para finalizar el programa solo si lo desea el usuario
        while (condicion){

            System.out.println("*********************************\n");
            System.out.println("""
                    1) Dolar ===> Peso Argentino
                    2) Peso Argentino ===> Dolar
                    3) Dolar ===> Real Brasileño
                    4) Real Brasileño ===> Dolar
                    5) Dolar ===> Peso Colombiano
                    6) Peso Colombiano ===> Dolar
                    7) Otra conversión
                    8) Salir
                    """);
            System.out.println("Elija una opción valida:");
            System.out.println("*********************************");

            try {
                //ingresar la opción deseada
                var conversion = escaner.nextInt();

                //corroborar que el entero sea correspondiente a las opciones disponibles
                if (conversion < 1 || conversion > 8) {
                    System.out.println("Opción inválida, por favor elige un número entre 1 y 8.\n");
                    continue;
                }

                //usar una conversion u otra dependiendo de la opción elegida
                switch (conversion) {
                    case 1:
                        envio.enviarConsulta("USD", "ARS");
                        break;
                    case 2:
                        envio.enviarConsulta("ARS", "USD");
                        break;
                    case 3:
                        envio.enviarConsulta("USD", "BRL");
                        break;
                    case 4:
                        envio.enviarConsulta("BRL", "USD");
                        break;
                    case 5:
                        envio.enviarConsulta("USD", "COP");
                        break;
                    case 6:
                        envio.enviarConsulta("COP", "USD");
                        break;
                    case 7:
                        conversionExtra.convertirAEleccion();
                        break;
                    //opcion para finalizacion de programa
                    case 8:
                        condicion = false;
                        System.out.println("Finalizando programa, muchas gracias.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            //manejo de errores
            }catch (InputMismatchException e){
                System.out.println("Debes introducir un número.\n");
                escaner.next();
            }catch(Exception e){
                System.out.println("Hubo un error.\n");
            }
        }
        escaner.close();
    }
}
