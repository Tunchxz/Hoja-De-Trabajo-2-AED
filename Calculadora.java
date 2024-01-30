package src;

import java.util.ArrayList;

public class Calculadora implements CalculadoraPOSTFIX {

    @Override
    public int calcular(String cadena) {
        MiStack<Integer> pila = new MiStack<>();
        ArrayList<String> cadenaPosFix = new ArrayList<>();
        int contadorDeVariables = 0;

        String[] elementos = cadena.split(" ");
        for (String elemento : elementos) {
            cadenaPosFix.add(elemento);
        }

        for (String variable : cadenaPosFix) {
            if (variable.equals("+") || variable.equals("-") || variable.equals("*") || variable.equals("/")) {
                if (contadorDeVariables < 2) {
                    return -20;
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
                            return -30;
                        }
                        pila.push(operandoA / operandoB);
                        break;
                    default:
                        return -10;
                }
                contadorDeVariables--;
            } else {
                try {
                    pila.push(Integer.parseInt(variable));
                    contadorDeVariables++;
                } catch (NumberFormatException e) {
                    return -10;
                }
            }
        }

        if (contadorDeVariables == 1) {
            return pila.pop();
        } else {
            return -20;
        }
    }
}