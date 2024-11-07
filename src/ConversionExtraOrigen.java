import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversionExtraOrigen {
    Scanner escaner = new Scanner(System.in);
    boolean condicion = true;
    EnvioConsulta envio = new EnvioConsulta();

    public void convertirAEleccion(){

        while(condicion) {

            //Imprimiendo las monedas disponibles a elegir.
            System.out.println("*******************************\n");
            System.out.println("""
                    1) ----> USD (Dolar)
                    2) ----> ARS (Peso Argentino)
                    3) ----> BRL (Real Brasileño)
                    4) ----> COP (Peso Colombiano)
                    5) ----> UYU (Peso Uruguayo)
                    6) ----> PEN (Sol Peruano)
                    7) ----> CLP (Peso Chileno)
                    8) ----> MXN (Peso Mexicano)
                    9) ----> BOB (Boliviano)
                    10)----> PYG (Guaraní Paraguayo)
                    11)----> Volver al menu principal
                    """);
            System.out.println("*******************************\n");

            String monedaOrigen = "";
            String monedaDestino = "";
            boolean entradaValida = false;

            //Primer ciclo para determinar la moneda origen.
            while(!entradaValida){
                try{
                    System.out.println("Elige la moneda origen(del 1 al 11):");
                    int eleccionOrigen = escaner.nextInt();

                    if (eleccionOrigen == 11){
                        System.out.println("Volviendo al menu principal...");
                        break;
                    }

                    monedaOrigen = obtenerMoneda(eleccionOrigen);

                    if (monedaOrigen.isEmpty()) {
                        System.out.println("Opción invalida, ingrese un número del 1 al 11.");
                    }else {
                        entradaValida = true;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Debe ingresar un valor entero.");
                    escaner.next();
                }catch (Exception e){
                    System.out.println("Hubo un error.");
                    escaner.next();
                }
            }

            //Si el usuario a deseado volver al menu principal, esta opción se ejecutará y volvera al menu principal.
            if(!entradaValida){
                break;
            }

            //Reseteamos la entradaValida para que se ejecute el siguiente ciclo.
            entradaValida=false;

            //Ciclo destinado a determinar la moneda destino para realizar la conversión.
            while(!entradaValida){
                try{
                    System.out.println("Elige la moneda destino:");
                    int eleccionDestino = escaner.nextInt();

                    monedaDestino = obtenerMoneda(eleccionDestino);

                    if (monedaDestino.isEmpty()){
                        System.out.println("Opción invalida, ingrese un número del 1 al 10.");
                    } else if (monedaDestino.equals(monedaOrigen)) {
                        System.out.println("La moneda origen no puede ser igual a la moneda destino.");
                    }else{
                        entradaValida=true;
                    }
                }catch(InputMismatchException e){
                    System.out.println("Debe ingresar un valor entero.");
                    escaner.next();
                }catch (Exception e){
                    System.out.println("Hubo un error.");
                    escaner.next();
                }
            }

            //Se realiza la consulta con los datos solicitados por el usuario
            envio.enviarConsulta(monedaOrigen,monedaDestino);
        }
    }

    //Metodo para determinar la moneda en base a la entrada del usuario
    public static String obtenerMoneda(int opcion){
        return switch (opcion){
            case 1 -> "USD";
            case 2 -> "ARS";
            case 3 -> "BRL";
            case 4 -> "COP";
            case 5 -> "UYU";
            case 6 -> "PEN";
            case 7 -> "CLP";
            case 8 -> "MXN";
            case 9 -> "BOB";
            case 10 ->"PYG";
            default -> "";
        };
    }
}
