# Grupo-6-Paulo-Balduino-
**Tema:** Calculadora  
**Grupo:** 6  

---

## Funcionalidades baseadas em LLM

A aplicação delega no LLM:

- A resolução de operações matemáticas básicas  
- A resolução de equações de segundo grau  

---

## Tabela de Resumo

| Campo | Informação |
|-------|------------|
| **Prompts de integração esperadas** | 1) **Operação simples:** Resolva a operação matemática seguinte e devolva apenas o resultado numérico, sem texto adicional: `"12 + 5 * 3 - 8 / 2"` <br><br> 2) **Equação de 2º grau:** Resolva a seguinte equação do tipo ax² + bx + c = 0. Valores: a = 2, b = 5, c = -3 |
| **Prompts de integração usadas** | 1) **Operação simples:** Resolva a operação matemática seguinte e devolva apenas o resultado numérico, sem texto adicional: `"12 + 5 * 3 - 8 / 2"` <br><br> 2) **Equação de 2º grau:** Resolva a seguinte equação de segundo grau. Valores: a = 2, b = 5, c = -3 |

---

## Classes e Responsabilidades

| Classe | Responsabilidade |
|--------|------------------|
| **Calculadora** | Realiza operações básicas: soma, subtração, multiplicação e divisão |
| **CalculadoraAvancada** | Estende a calculadora com funcionalidades avançadas: potência, raiz quadrada e resolução de equações de 2º grau |
| **ServicoLLM** | Responsável pela comunicação com o LLM: cria prompts, envia pedidos e processa respostas |
| **CalculadoraGUI** | Interface gráfica completa construída em Swing; inclui botões, display, handlers e ligação às classes de cálculo |
| **ServicoLLMTest** | Contém testes unitários que avaliam cálculos simples, cálculos avançados, exceções e casos fronteira |

---

## Interface Gráfica (CalculadoraGUI)

A classe **CalculadoraGUI** implementa uma calculadora visual com:

- JFrame para a janela principal  
- Display numérico (JTextField)  
- Botões de 0–9, operações e funcionalidades avançadas  
- Ligação direta às classes `Calculadora` e `CalculadoraAvancada`  
- Eventos via ActionListener  
- Lógica para operações sequenciais e limpeza de display  

---

## Testes Unitários

Os testes incluem:

- Operações básicas  
- Operações avançadas  
- Exceções (ex.: dividir por zero)  
- Casos fronteira como overflow e valores inválidos  
- Testes para NaN, infinito e precisão  

---

## Diagrama UML

<img width="3636" height="2098" alt="uml" src="https://github.com/user-attachments/assets/82173770-c2c9-4a35-a64e-9ef017ada543" />

---

