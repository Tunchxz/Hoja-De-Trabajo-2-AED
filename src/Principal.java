package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("datos.txt"))) {
            Calculadora miCalculadora = new Calculadora();

            while (scanner.hasNextLine()) {
                String cadena = scanner.nextLine();
                int resultado = miCalculadora.calcular(cadena);
                if (resultado == -10) {
                    System.out.println(
                            "[Sistema]: Error (hay un carácter que no puede ser interpretado como operando o operador).");
                } else if (resultado == -20) {
                    System.out.println("[Sistema]: Insuficiente cantidad de operandos para realizar una operación.");
                } else if (resultado == -30) {
                    System.out.println("[Sistema]: Error numérico (división entre cero).");
                } else if (resultado == -40) {
                    System.out.println(
                            "");
                } else {
                    System.out.println("Resultado: " + resultado);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error al cargar o leer el archivo datos.txt: " + e.getMessage());
        }
    }
}