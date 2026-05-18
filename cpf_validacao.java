/**
 1. Desenvolver um aplicativo que leia um CPF e, após a validação,
 exiba na tela se o CPF é válido ou inválido.

 Resultado Esperado:
 Se o CPF for válido, exibir na tela: 'CPF válido!'
 Se o CPF for inválido, exibir na tela: 'CPF inválido!'
 */

import static java.lang.IO.readln;

void main() {
    // Solicita que o usuário digite o CPF
    IO.print("Digite o CPF: ");
    String cpf = readln();

    // Remove pontos, traços e espaços do CPF digitado
    cpf = cpf
            .replace(".", "")
            .replace("-", "")
            .replace(" ", "");


    boolean cpfValido = true;

    // Verifica se o CPF possui exatamente 11 dígitos
    if (cpf.length() != 11) {
        cpfValido = false;
    } else {
        // Verifica se todos os caracteres são números
        for (int i = 0; i < cpf.length(); i++) {
            if (!Character.isDigit(cpf.charAt(i))) {
                cpfValido = false;
            }
        }

        // Verifica se todos os números do CPF são iguais
        if (cpfValido) {
            boolean todosIguais = true;

            for (int i = 1; i < cpf.length(); i++) {
                if (cpf.charAt(i) != cpf.charAt(0)) {
                    todosIguais = false;
                }
            }

            if (todosIguais) {
                cpfValido = false;
            }
        }

        // Calcula e valida os dígitos verificadores do CPF
        if (cpfValido) {

            int soma = 0;

            // Multiplica os 9 primeiros dígitos pelos pesos de 10 até 2
            for (int i = 0; i < 9; i++) {
                int numero = Character.getNumericValue(cpf.charAt(i));
                soma += numero * (10 - i);
            }

            // Calcula o resto da divisão por 11
            int resto = soma % 11;

            // Calcula o primeiro dígito verificador
            int primeiroDigito;

            if (resto < 2) {
                primeiroDigito = 0;
            } else {
                primeiroDigito = 11 - resto;
            }

            // Verifica se o primeiro dígito calculado é igual ao CPF digitado
            int primeiroDigitoCpf = Character.getNumericValue(cpf.charAt(9));

            if (primeiroDigito != primeiroDigitoCpf) {
                cpfValido = false;
            }

            // Soma para calcular o segundo dígito verificador
            soma = 0;

            // Multiplica os 10 primeiros dígitos pelos pesos de 11 até 2
            for (int i = 0; i < 10; i++) {
                int numero = Character.getNumericValue(cpf.charAt(i));
                soma += numero * (11 - i);
            }

            // Calcula o resto da divisão por 11
            resto = soma % 11;

            // Calcula o segundo dígito verificador
            int segundoDigito;

            if (resto < 2) {
                segundoDigito = 0;
            } else {
                segundoDigito = 11 - resto;
            }

            // Verifica se o segundo dígito calculado é igual ao CPF digitado
            int segundoDigitoCpf = Character.getNumericValue(cpf.charAt(10));

            if (segundoDigito != segundoDigitoCpf) {
                cpfValido = false;
            }
        }
    }

    // Exibe o resultado da validação do CPF
    if (cpfValido) {
        IO.println("CPF válido!");
    } else {
        IO.println("CPF inválido!");
    }
}