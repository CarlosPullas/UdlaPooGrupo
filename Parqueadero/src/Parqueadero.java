import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Parqueadero {
    private List<Puesto> puestos;
    private Map<String, Carro> carros;
    private double tarifaPorHora;
    private double ingresos;

    public Parqueadero(int numPuestos, double tarifaPorHora) {
        this.puestos = new ArrayList<>();
        this.carros = new HashMap<>();
        this.tarifaPorHora = tarifaPorHora;
        this.ingresos = 0;

        for (int i = 1; i <= numPuestos; i++) {
            puestos.add(new Puesto(i));
        }
    }

    public void ingresarCarro(String placa, int horaEntrada) {
        if (!carros.containsKey(placa)) {
            Carro carro = new Carro(placa, horaEntrada);
            carros.put(placa, carro);

            Puesto puestoDisponible = buscarPuestoDisponible();
            if (puestoDisponible != null) {
                puestoDisponible.asignarCarro(carro);
            } else {
                System.out.println("No hay puestos disponibles.");
            }
        } else {
            System.out.println("El carro con placa " + placa + " ya está en el parqueadero.");
        }
    }

    public void darSalidaCarro(String placa, int horaSalida) {
        if (carros.containsKey(placa)) {
            Carro carro = carros.get(placa);
            int tiempoEstacionado = horaSalida - carro.getHoraEntrada();
            double costo = calcularCosto(tiempoEstacionado);

            System.out.println("El carro con placa " + placa + " ha salido. Costo: $" + costo);

            Puesto puesto = buscarPuestoPorCarro(placa);
            puesto.liberarPuesto();

            carros.remove(placa);
            ingresos += costo;
        } else {
            System.out.println("El carro con placa " + placa + " no se encuentra en el parqueadero.");
        }
    }

    public void informarIngresos() {
        System.out.println("Ingresos totales: $" + ingresos);
    }

    public int consultarPuestosDisponibles() {
        int disponibles = 0;
        for (Puesto puesto : puestos) {
            if (!puesto.estaOcupado()) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public void avanzarReloj() {

    }

    public void cambiarTarifa(double nuevaTarifa) {
        this.tarifaPorHora = nuevaTarifa;
        System.out.println("La tarifa del parqueadero ha sido cambiada a $" + nuevaTarifa + " por hora.");
    }

    private Puesto buscarPuestoDisponible() {
        for (Puesto puesto : puestos) {
            if (!puesto.estaOcupado()) {
                return puesto;
            }
        }
        return null;
    }

    private Puesto buscarPuestoPorCarro(String placa) {
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado() && puesto.getCarro().getPlaca().equals(placa)) {
                return puesto;
            }
        }
        return null;
    }

    private double calcularCosto(int tiempoEstacionado) {

        return tiempoEstacionado * tarifaPorHora;
    }
    public int contarCarrosQueComienzanConPlacaPB() {
        int count = 0;
        for (Carro carro : carros.values()) {
            if (carro.getPlaca().startsWith("PB")) {
                count++;
            }
        }
        return count;
    }
    public boolean hayCarroCon24Horas() {
        for (Carro carro : carros.values()) {
            int tiempoEstacionado = obtenerTiempoEstacionado(carro);
            if (tiempoEstacionado >= 24) {
                return true;
            }
        }
        return false;
    }

    private int obtenerTiempoEstacionado(Carro carro) {
        // Obtener el tiempo actual o el momento en que se llama este método
        int tiempoActual = 0; // Reemplaza con la lógica real para obtener el tiempo actual
        return tiempoActual - carro.getHoraEntrada();
    }

    public String metodo1() {
        int cantidadCarrosPB = contarCarrosQueComienzanConPlacaPB();
        boolean hayCarro24Horas = hayCarroCon24Horas();

        String mensaje = "Cantidad de carros con placa PB: " + cantidadCarrosPB +
                " - Hay carro parqueado por 24 o más horas: " + (hayCarro24Horas ? "Sí" : "No") + ".";
        return mensaje;
    }

    public int desocuparParqueadero() {
        int carrosSacados = carros.size();
        carros.clear();
        for (Puesto puesto : puestos) {
            puesto.liberarPuesto();
        }
        return carrosSacados;
    }

    public String metodo2() {
        int carrosSacados = desocuparParqueadero();
        return "Cantidad de carros sacados: " + carrosSacados + ".";
    }
}


