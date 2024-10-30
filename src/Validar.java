public class Validar {


    public static void validarCPF(String cpf) throws CPFException {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            throw new CPFException("CPF deve ter 11 dígitos.");
        }

        if (cpf.chars().distinct().count() == 1) {
            throw new CPFException("CPF não pode ter todos os dígitos iguais.");
        }

        int soma = 0;
        int peso = 10;

        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * peso--;
        }

        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0 : digito1;

        if (digito1 != (cpf.charAt(9) - '0')) {
            throw new CPFException("CPF inválido.");
        }

        soma = 0;
        peso = 11;

        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * peso--;
        }

        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0 : digito2;

        if (digito2 != (cpf.charAt(10) - '0')) {
            throw new CPFException("CPF inválido.");
        }
    }

}