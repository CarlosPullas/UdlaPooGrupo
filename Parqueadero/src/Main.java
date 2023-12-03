import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero(40, 5.0);

        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Ingresar carro");
            System.out.println("2. Dar salida a carro");
            System.out.println("3. Informar ingresos");
            System.out.println("4. Consultar puestos disponibles");
            System.out.println("5. Avanzar reloj");
            System.out.println("6. Cambiar tarifa");
            System.out.println("7. Método 1");
            System.out.println("8. Desocupar parqueadero");
            System.out.println("9. Método 2");
            System.out.println("0. Salir");

            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del carro: ");
                    String placaIngreso = scanner.next();
                    System.out.print("Ingrese la hora de entrada (entre 6 y 21): ");
                    int horaEntrada = scanner.nextInt();
                    parqueadero.ingresarCarro(placaIngreso, horaEntrada);
                    break;
                case 2:
                    System.out.print("Ingrese la placa del carro que sale: ");
                    String placaSalida = scanner.next();
                    System.out.print("Ingrese la hora de salida: ");
                    int horaSalida = scanner.nextInt();
                    parqueadero.darSalidaCarro(placaSalida, horaSalida);
                    break;
                case 3:
                    parqueadero.informarIngresos();
                    break;
                case 4:
                    int puestosDisponibles = parqueadero.consultarPuestosDisponibles();
                    System.out.println("Puestos disponibles: " + puestosDisponibles);
                    break;
                case 5:
                    parqueadero.avanzarReloj();
                    break;
                case 6:
                    System.out.print("Ingrese la nueva tarifa por hora: ");
                    double nuevaTarifa = scanner.nextDouble();
                    parqueadero.cambiarTarifa(nuevaTarifa);
                    break;
                case 7:
                    System.out.println(parqueadero.metodo1());
                    break;
                case 8:
                    int carrosDesocupados = parqueadero.desocuparParqueadero();
                    System.out.println("Cantidad de carros desocupados: " + carrosDesocupados);
                    break;
                case 9:
                    System.out.println(parqueadero.metodo2());
                    break;
            }
        } while (opcion != 0);

        System.out.println("¡Gracias por utilizar el sistema de parqueadero!");
        scanner.close();
    }
}