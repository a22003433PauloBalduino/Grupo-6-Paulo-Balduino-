/**
 * Classe que representa uma calculadora avançada, estendendo a funcionalidade
 * da classe {@link Calculadora} com operações matemáticas adicionais.
 */
class CalculadoraAvancada extends Calculadora {

    /**
     * Calcula a potência de um número.
     *
     * @param base valor base
     * @param expoente valor do expoente
     * @return o resultado de {@code base^expoente}
     */
    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    /**
     * Calcula a raiz quadrada de um número.
     *
     * @param valor número do qual será extraída a raiz quadrada
     * @return a raiz quadrada do valor
     */
    public double raizQuadrada(double valor) {
        return Math.sqrt(valor);
    }

    /**
     * Resolve uma equação do segundo grau da forma:
     * <p>
     *     {@code ax^2 + bx + c = 0}
     * </p>
     *
     * Este método trata todos os casos:
     * <ul>
     *     <li>Não ser equação de 2º grau (a = 0)</li>
     *     <li>Delta negativo (sem soluções reais)</li>
     *     <li>Delta igual a zero (uma solução real)</li>
     *     <li>Delta positivo (duas soluções reais)</li>
     * </ul>
     *
     * @param a coeficiente quadrático
     * @param b coeficiente linear
     * @param c termo independente
     * @return uma mensagem descrevendo o tipo de equação e suas soluções
     */
    public String resolverEquacaoSegundoGrau(double a, double b, double c) {

        // Caso especial: não é equação de 2º grau
        if (a == 0) {
            if (b == 0) {
                return (c == 0)
                        ? "A equação tem infinitas soluções."
                        : "A equação não tem solução.";
            } else {
                double x = -c / b;
                return "Equação de 1º grau. Solução: x = " + x;
            }
        }

        double delta = b*b - 4*a*c;

        if (delta < 0) {
            return "A equação não tem soluções reais (delta < 0).";
        }

        if (delta == 0) {
            double x = -b / (2 * a);
            return "A equação tem uma única solução real (raiz dupla): x = " + x;
        }

        // Delta > 0 → duas soluções reais
        double x1 = (-b + Math.sqrt(delta)) / (2*a);
        double x2 = (-b - Math.sqrt(delta)) / (2*a);

        return "A equação tem duas soluções reais: x1 = " + x1 + ", x2 = " + x2;
    }
}
