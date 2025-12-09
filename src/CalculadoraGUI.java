import javax.swing.*;
import java.awt.*;

/**
 * Interface gráfica para a calculadora simples e avançada.
 * <p>
 * Esta classe cria uma janela com botões numéricos, operações básicas
 * ({@code +, -, *, /}), operações avançadas ({@code √} e {@code ^}) e um display
 * para mostrar resultados. Usa internamente as classes {@link Calculadora}
 * e {@link CalculadoraAvancada} para realizar os cálculos.
 * </p>
 *
 * <p><b>Funcionamento geral:</b></p>
 * <ul>
 *     <li>O utilizador clica nos botões para inserir números e operações.</li>
 *     <li>O botão "=" executa a operação selecionada.</li>
 *     <li>O botão "C" limpa o display e reinicia o estado interno.</li>
 *     <li>O botão "√" calcula a raiz quadrada do valor atual.</li>
 *     <li>O botão "^" permite calcular potências.</li>
 * </ul>
 *
 * <p>
 * Esta classe contém apenas o método {@code main}, pois a aplicação é executada
 * diretamente a partir dela.
 * </p>
 */
public class CalculadoraGUI {

    /**
     * Valor numérico armazenado quando o utilizador premir uma operação.
     */
    public static double valorAtual = 0;

    /**
     * Operação escolhida pelo utilizador (ex: "+", "-", "*", "/", "^").
     */
    public static String operacao = "";

    /**
     * Indica se o display deve ser limpo antes de inserir novo texto.
     */
    public static boolean limparDisplay = false;

    /**
     * Ponto de entrada da aplicação gráfica da calculadora.
     * <p>
     * Este método cria a janela, os botões, o display e associa
     * todos os eventos necessários para que a interface funcione.
     * Cada botão possui uma ação que altera o display ou realiza
     * operações matemáticas utilizando {@link Calculadora} ou
     * {@link CalculadoraAvancada}.
     * </p>
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        Calculadora calcSimples = new Calculadora();
        CalculadoraAvancada calcAvancada = new CalculadoraAvancada();

        // Criação da janela
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Display superior
        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(display, BorderLayout.NORTH);

        // Painel com botões
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 4));
        frame.add(painel, BorderLayout.CENTER);

        // Lista de botões visíveis no ecrã
        String[] botoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "√", "^", "C"
        };

        // Criação dinâmica dos botões
        for (String txt : botoes) {
            JButton btn = new JButton(txt);
            btn.setFont(new Font("Arial", Font.BOLD, 20));

            /**
             * Ação a executar quando o botão é premido.
             */
            btn.addActionListener(e -> {
                String label = btn.getText();

                try {
                    // -------------------------------
                    // Entrada de números e vírgula
                    // -------------------------------
                    if (label.matches("[0-9]") || label.equals(".")) {
                        if (limparDisplay) {
                            display.setText("");
                            limparDisplay = false;
                        }
                        display.setText(display.getText() + label);
                    }

                    // -------------------------------
                    // Limpar calculadora
                    // -------------------------------
                    else if (label.equals("C")) {
                        display.setText("");
                        valorAtual = 0;
                        operacao = "";
                    }

                    // -------------------------------
                    // Realizar cálculo (=)
                    // -------------------------------
                    else if (label.equals("=")) {
                        double novoValor = Double.parseDouble(display.getText());

                        switch (operacao) {
                            case "+":
                                display.setText(String.valueOf(calcSimples.somar(valorAtual, novoValor)));
                                break;
                            case "-":
                                display.setText(String.valueOf(calcSimples.subtrair(valorAtual, novoValor)));
                                break;
                            case "*":
                                display.setText(String.valueOf(calcSimples.multiplicar(valorAtual, novoValor)));
                                break;
                            case "/":
                                display.setText(String.valueOf(calcSimples.dividir(valorAtual, novoValor)));
                                break;
                            case "^":
                                display.setText(String.valueOf(calcAvancada.potencia(valorAtual, novoValor)));
                                break;
                        }

                        operacao = "";
                    }

                    // -------------------------------
                    // Raiz quadrada
                    // -------------------------------
                    else if (label.equals("√")) {
                        double v = Double.parseDouble(display.getText());
                        display.setText(String.valueOf(calcAvancada.raizQuadrada(v)));
                    }

                    // -------------------------------
                    // Operações normais e potência
                    // -------------------------------
                    else {
                        valorAtual = Double.parseDouble(display.getText());
                        operacao = label;
                        limparDisplay = true;
                    }

                } catch (Exception ex) {
                    display.setText("Erro");
                }
            });

            painel.add(btn);
        }

        // Mostrar janela
        frame.setVisible(true);
    }
}
