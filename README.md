# Validador de CPF

## Objetivo

Este projeto tem como objetivo criar um programa em Java para validar um CPF informado pelo usuário.

Após a validação, o programa exibe uma das mensagens:

- CPF válido!
- CPF inválido!

## Sobre o projeto

O sistema lê um CPF, remove possíveis caracteres como pontos e traço, e verifica se ele possui 11 números.

Depois disso, o programa aplica o cálculo dos dígitos verificadores do CPF para saber se o número informado é válido ou não.

## Como funciona a validação

O CPF possui 11 dígitos.

Os 9 primeiros dígitos formam a base do CPF, e os 2 últimos são chamados de dígitos verificadores.

Para validar o CPF, o programa faz os seguintes passos:

1. Verifica se o CPF tem 11 dígitos.
2. Verifica se todos os caracteres são números.
3. Verifica se todos os números não são iguais, como `00000000000` ou `11111111111`.
4. Calcula o primeiro dígito verificador.
5. Calcula o segundo dígito verificador.
6. Compara os dígitos calculados com os dígitos informados no CPF.

Se os dois dígitos estiverem corretos, o CPF é considerado válido.

## Exemplo de uso

Ao executar o programa, o usuário informa um CPF:

```text
Digite o CPF: 111.444.777-35
CPF válido!
