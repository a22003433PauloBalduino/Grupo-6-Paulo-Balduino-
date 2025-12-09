import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        CalculadoraAvancada calcAdv = new CalculadoraAvancada();

        while (true) {

            System.out.println("\n=====================================");
            System.out.println("          CALCULADORA JAVA          ");
            System.out.println("=====================================");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("5 - Potência");
            System.out.println("6 - Raiz Quadrada");
            System.out.println("7 - Equação do 2º Grau");
            System.out.println("0 - Sair");
            System.out.println("=====================================");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();

            if (opcao == 0) {
                System.out.println("Encerrando... Até logo!");
                break;
            }

            double a, b, c;

            try {
                switch (opcao) {

                    case 1:
                        System.out.print("Digite A: ");
                        a = sc.nextDouble();
                        System.out.print("Digite B: ");
                        b = sc.nextDouble();
                        System.out.println("Resultado: " + calc.somar(a, b));
                        break;

                    case 2:
                        System.out.print("Digite A: ");
                        a = sc.nextDouble();
                        System.out.print("Digite B: ");
                        b = sc.nextDouble();
                        System.out.println("Resultado: " + calc.subtrair(a, b));
                        break;

                    case 3:
                        System.out.print("Digite A: ");
                        a = sc.nextDouble();
                        System.out.print("Digite B: ");
                        b = sc.nextDouble();
                        System.out.println("Resultado: " + calc.multiplicar(a, b));
                        break;

                    case 4:
                        System.out.print("Digite A: ");
                        a = sc.nextDouble();
                        System.out.print("Digite B: ");
                        b = sc.nextDouble();
                        System.out.println("Resultado: " + calc.dividir(a, b));
                        break;

                    case 5:
                        System.out.print("Digite a base: ");
                        a = sc.nextDouble();
                        System.out.print("Digite o expoente: ");
                        b = sc.nextDouble();
                        System.out.println("Resultado: " + calcAdv.potencia(a, b));
                        break;

                    case 6:
                        System.out.print("Digite o valor: ");
                        a = sc.nextDouble();
                        System.out.println("Resultado: " + calcAdv.raizQuadrada(a));
                        break;

                    case 7:
                        System.out.print("Digite A: ");
                        a = sc.nextDouble();
                        System.out.print("Digite B: ");
                        b = sc.nextDouble();
                        System.out.print("Digite C: ");
                        c = sc.nextDouble();
                        System.out.println(calcAdv.resolverEquacaoSegundoGrau(a, b, c));
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                sc.nextLine(); // limpar buffer
            }

            System.out.println("\nPressione ENTER para continuar...");
            sc.nextLine(); // buffer
            sc.nextLine(); // enter
        }

        sc.close();
    }
}
