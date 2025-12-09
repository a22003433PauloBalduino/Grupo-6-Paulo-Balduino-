    import static org.junit.Assert.assertTrue;
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertThrows;

    import org.junit.jupiter.api.Test;

    /**
     * Classe de testes unitários para verificar o funcionamento das classes
     * {@link Calculadora} e {@link CalculadoraAvancada}.
     *
     * <p>Contém dois grupos principais de testes:</p>
     * <ul>
     *     <li>Testes da calculadora simples</li>
     *     <li>Testes da calculadora avançada</li>
     * </ul>
     */
    public class ServicoLLMTest {

        /**
         * Testa todas as operações básicas da classe {@link Calculadora}:
         * <ul>
         *     <li>Soma</li>
         *     <li>Subtração</li>
         *     <li>Multiplicação</li>
         *     <li>Divisão</li>
         *     <li>Lançamento de exceção em divisão por zero</li>
         * </ul>
         */
        @Test
        void testeCalculadoraSimples() {
            Calculadora calc = new Calculadora();

            // Teste de soma
            assertEquals(17.0, calc.somar(12, 5));

            // Teste de subtração
            assertEquals(7.0, calc.subtrair(12, 5));

            // Teste de multiplicação
            assertEquals(60.0, calc.multiplicar(12, 5));

            // Teste de divisão
            assertEquals(2.4, calc.dividir(12, 5));

            // Teste de divisão por zero
            assertThrows(IllegalArgumentException.class, () -> calc.dividir(12, 0));
        }

        /**
         * Testa as funcionalidades adicionais da classe {@link CalculadoraAvancada}, incluindo:
         * <ul>
         *     <li>Cálculo de potência</li>
         *     <li>Raiz quadrada</li>
         *     <li>Resolução de equações do 2º grau (todos os casos)</li>
         *     <li>Equações de 1º grau e casos degenerados</li>
         * </ul>
         */
        @Test
        void testeCalculadoraAvancada() {
            CalculadoraAvancada calc = new CalculadoraAvancada();

            // Teste de potência
            assertEquals(8.0, calc.potencia(2, 3));

            // Teste de raiz quadrada
            assertEquals(5.0, calc.raizQuadrada(25));

            // Teste equação 2º grau com duas raízes reais
            String resultado1 = calc.resolverEquacaoSegundoGrau(2, 5, -3);
            assert(resultado1.contains("0.5"));
            assert(resultado1.contains("-3.0"));

            // Teste equação 2º grau com raiz única
            String resultado2 = calc.resolverEquacaoSegundoGrau(1, -2, 1);
            assert(resultado2.contains("1.0"));

            // Teste equação sem solução real
            String resultado3 = calc.resolverEquacaoSegundoGrau(1, 0, 1);
            assert(resultado3.contains("não tem soluções reais"));

            // Teste equação de 1º grau
            String resultado4 = calc.resolverEquacaoSegundoGrau(0, 2, -4);
            assert(resultado4.contains("x = 2.0"));

            // Teste equação sem solução
            String resultado5 = calc.resolverEquacaoSegundoGrau(0, 0, 5);
            assert(resultado5.contains("não tem solução"));

            // Teste equação com infinitas soluções
            String resultado6 = calc.resolverEquacaoSegundoGrau(0, 0, 0);
            assert(resultado6.contains("infinitas soluções"));
        }

        /**
         * Testa se o método {@link Calculadora#dividir(double, double)} lança
         * uma exceção ao tentar dividir um número por zero.
         */
        @Test
        void testeDivisaoPorZero() {
            Calculadora calc = new Calculadora();
            assertThrows(IllegalArgumentException.class, () -> calc.dividir(10, 0));
        }

        /**
         * Testa a multiplicação de números extremamente grandes, verificando se o
         * resultado excede o limite do tipo {@code double} e produz um valor infinito.
         */
        @Test
        void testeNumerosMuitoGrandes() {
            Calculadora calc = new Calculadora();
            double resultado = calc.multiplicar(1e308, 2);
            assertTrue(Double.isInfinite(resultado));
        }

        /**
         * Testa o cálculo da raiz quadrada de um número negativo, validando que a
         * operação devolve {@code NaN} conforme definido pelo método {@link Math#sqrt(double)}.
         */
        @Test
        void testeRaizQuadradaNegativa() {
            CalculadoraAvancada calc = new CalculadoraAvancada();
            double resultado = calc.raizQuadrada(-9);
            assertTrue(Double.isNaN(resultado));
        }
    }
