package src;

import java.util.ArrayList;

/**
 * Implementación de la interfaz CalculadoraPOSTFIX que evalúa expresiones en
 * notación POSTFIX.
 */
public class Calculadora implements CalculadoraPOSTFIX {

    /**
     * Calcula el resultado de una expresión en notación POSTFIX.
     *
     * @param cadena La expresión en notación POSTFIX.
     * @return El resultado de la evaluación de la expresión.
     *         Devuelve -10 si hay un operador no reconocido o error al convertir a
     *         entero.
     *         Devuelve -20 si no hay suficientes operandos para algún operador.
     *         Devuelve -30 si hay una división por cero.
     */
    @Override
    public int calcular(String cadena) {
        MiStack<Integer> pila = new MiStack<>();
        ArrayList<String> cadenaPosFix = new ArrayList<>();
        int contadorDeVariables = 0;

        // Divide la cadena en elementos y los agrega a la lista
        String[] elementos = cadena.split(" ");
        for (String elemento : elementos) {
            cadenaPosFix.add(elemento);
        }

        // Procesa cada elemento de la expresión POSTFIX
        for (String variable : cadenaPosFix) {
            if (variable.equals("+") || variable.equals("-") || variable.equals("*") || variable.equals("/")) {
                // Si el elemento es un operador, realiza la operación correspondiente
                if (contadorDeVariables < 2) {
                    return -20; // No hay suficientes operandos para el operador
                }
                int operandoB = pila.pop();
                int operandoA = pila.pop();
                switch (variable) {
                    case "+":
                        pila.push(operandoA + operandoB);
                        break;
                    case "-":
                        pila.push(operandoA - operandoB);
                        break;
                    case "*":
                        pila.push(operandoA * operandoB);
                        break;
                    case "/":
                        if (operandoB == 0) {
                            return -30; // División por cero
                        }
                        pila.push(operandoA / operandoB);
                        break;
                    default:
                        return -10; // Operador no reconocido
                }
                contadorDeVariables--;
            } else {
                // Si el elemento es un operando, intenta convertirlo a entero y lo agrega a la
                // pila
                try {
                    pila.push(Integer.parseInt(variable));
                    contadorDeVariables++;
                } catch (NumberFormatException e) {
                    return -10; // Error al convertir a entero
                }
            }
        }

        // Verifica si hay un único resultado en la pila al final
        if (contadorDeVariables == 1) {
            return pila.pop();
        } else {
            return -20; // No hay suficientes operadores para algunos operadores
        }
    }
}