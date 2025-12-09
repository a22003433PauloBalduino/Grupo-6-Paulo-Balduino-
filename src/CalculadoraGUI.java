import javax.swing.*;
import java.awt.*;

public class CalculadoraGUI {

    private static double valorAtual = 0;
    private static String operacao = "";
    private static boolean limparDisplay = false;

    public static void main(String[] args) {

        Calculadora calcSimples = new Calculadora();
        CalculadoraAvancada calcAvancada = new CalculadoraAvancada();

        JFrame frame = new JFrame("Calculadora");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(display, BorderLayout.NORTH);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 4));
        frame.add(painel, BorderLayout.CENTER);

        // Lista de botões (números + operações)
        String[] botoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "√", "^", "C"
        };

        for (String txt : botoes) {
            JButton btn = new JButton(txt);
            btn.setFont(new Font("Arial", Font.BOLD, 20));

            btn.addActionListener(e -> {
                String label = btn.getText();

                try {
                    if (label.matches("[0-9]") || label.equals(".")) {
                        if (limparDisplay) {
                            display.setText("");
                            limparDisplay = false;
                        }
                        display.setText(display.getText() + label);
                    }
                    else if (label.equals("C")) {
                        display.setText("");
                        valorAtual = 0;
                        operacao = "";
                    }
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
                    else if (label.equals("√")) {
                        double v = Double.parseDouble(display.getText());
                        display.setText(String.valueOf(calcAvancada.raizQuadrada(v)));
                    }
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

        frame.setVisible(true);
    }
}
