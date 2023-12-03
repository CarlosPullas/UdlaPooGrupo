import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Puesto {
    private int numero;
    private Carro carro;

    public Puesto(int numero) {
        this.numero = numero;
        this.carro = null;
    }

    public int getNumero() {
        return numero;
    }

    public Carro getCarro() {
        return carro;
    }

    public void asignarCarro(Carro carro) {
        this.carro = carro;
    }

    public void liberarPuesto() {
        this.carro = null;
    }

    public boolean estaOcupado() {
        return carro != null;
    }
}
