# Programacao Orientada a Objetos IFTM
Este repositório é divido em:

- atividades realizadas;
- avaliações realizadas;
- projeto final;

# PROJETO FINAL

Este projeto implementa uma aplicação comercial em Java que permite o gerenciamento de clientes, contas bancárias, investimentos e financiamentos. Ele utiliza conceitos de Programação Orientada a Objetos (POO), incluindo:

## Conceitos de POO Utilizados

- **Encapsulamento**: Os atributos das classes são privados, e o acesso a eles ocorre por meio de métodos públicos (getters e setters).
- **Métodos e variáveis estáticas**: A classe `Financiamento` utiliza uma constante estática para a taxa de juros (`TAXA_JUROS`) e um formato estático para exibição de valores monetários.
- **Sobrecarga de construtores e métodos**: A classe `Conta` (não fornecida, mas referenciada) possuindo sobrecarga para permitir diferentes formas de inicialização.
- **Tratamento de Exceções**: O código utiliza `try-catch` para capturar exceções em operações de entrada de dados, evitando falhas na execução.
- **Relacionamento entre classes**:
- **Agregação Simples**: A classe `Cliente` mantém uma lista de `Investimentos`, indicando que os investimentos pertencem a um cliente e não são excluídos junto com ele.
- **Composição**: A classe `Cliente` possui referência à `Conta`, o que significa que um cliente deve possuir uma conta bancária .

## Principais Funcionalidades

- **Gerenciamento de Clientes**: Cadastro de clientes com conta bancária.
- **Operações Bancárias**: Depósito e saque na conta do cliente.
- **Simulação de Financiamentos**: Cálculo de valor das parcelas e total a pagar com base em juros compostos.
- **Gerenciamento de Investimentos**: Vinculação e remoção de investimentos dos clientes.
- **Interface com Usuário**: Utilização do `JOptionPane` para entrada e saída de dados.

Este projeto fornece uma abordagem prática e intuitiva para operações financeiras, garantindo uma experiência eficiente e interativa para o usuário.
