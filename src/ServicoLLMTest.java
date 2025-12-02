import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ServicoLLMTest {

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

    @Test
    void testeCalculadoraAvancada() {
        CalculadoraAvancada calc = new CalculadoraAvancada();

        // Teste de potência
        assertEquals(8.0, calc.potencia(2, 3));

        // Teste de raiz quadrada
        assertEquals(5.0, calc.raizQuadrada(25));

        // Teste equação 2º grau com duas raízes reais
        String resultado1 = calc.resolverEquacaoSegundoGrau(2, 5, -3);
        // Deve conter as raízes 0.5 e -3
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
}
