class CalculadoraAvancada extends Calculadora {

    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    public double raizQuadrada(double valor) {
        return Math.sqrt(valor);
    }

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
