# Grupo-6-Paulo-Balduino-
Tema: Calculadora

Grupo: 6

---

### Funcionalidades baseadas em LLM
A aplicação delega no LLM:
- A resolução de operações matemáticas básicas
- A resolução de equações de segundo grau

---

### Tabela de Resumo

| Campo | Informação |
|-------|------------|
| **Prompts de integração esperadas** | 1) **Operação simples:** Resolva a operação matemática seguinte e devolva apenas o resultado numérico, sem texto adicional: "12 + 5 * 3 - 8 / 2" <br><br> 2) **Equação de 2º grau:** Resolva a seguinte equação de segundo grau do tipo ax^2 + bx + c = 0. Valores: a = 2, b = 5, c = -3 |
| **Prompts de integração usadas** | 1) **Operação simples:** Resolva a operação matemática seguinte e devolva apenas o resultado numérico, sem texto adicional: "12 + 5 * 3 - 8 / 2" <br><br> 2) **Equação de 2º grau:** Resolva a seguinte equação de segundo grau do tipo ax^2 + bx + c = 0. Valores: a = 2, b = 5, c = -3 |

---

###  Classes esperadas e suas responsabilidades
| Classe | Responsabilidade |
|--------|------------------|
| **Calculadora** | Realiza operações básicas: soma, subtração, multiplicação e divisão |
| **CalculadoraAvancada** | Estende a calculadora com funcionalidades como potência, raiz quadrada e equações de 2º grau |
| **ServicoLLM** | Responsável por enviar prompts ao LLM e receber respostas |
| **Controlador** | Faz a ligação entre a interface do utilizador, a calculadora e o serviço LLM |

---

###  Diagrama UML
<img width="350" height="234" alt="Uml" src="https://github.com/user-attachments/assets/89ffcbe6-947f-4618-ae7f-757d7c57130a" />
