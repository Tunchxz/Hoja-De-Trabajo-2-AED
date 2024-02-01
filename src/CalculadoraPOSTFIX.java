package src;

/**
 * Interfaz que define el contrato para una calculadora que evalúa expresiones
 * en notación POSTFIX.
 */
public interface CalculadoraPOSTFIX {

    /**
     * Calcula el resultado de una expresión en notación POSTFIX.
     *
     * @param cadena La expresión en notación POSTFIX.
     * @return El resultado de la evaluación de la expresión.
     */
    public int calcular(String cadena);
}