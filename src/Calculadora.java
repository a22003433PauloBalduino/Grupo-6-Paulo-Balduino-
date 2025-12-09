/**
 * Classe que disponibiliza operações aritméticas básicas.
 */
class Calculadora {

    /**
     * Soma dois valores.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return o resultado da soma entre {@code a} e {@code b}
     */
    public double somar(double a, double b) {
        return a + b;
    }

    /**
     * Subtrai dois valores.
     *
     * @param a valor inicial
     * @param b valor a subtrair
     * @return o resultado da subtração ({@code a - b})
     */
    public double subtrair(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dois valores.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return o resultado da multiplicação entre {@code a} e {@code b}
     */
    public double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide dois valores.
     *
     * @param a dividendo
     * @param b divisor
     * @return o resultado da divisão ({@code a / b})
     * @throws IllegalArgumentException se {@code b} for igual a zero
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        return a / b;
    }

}
