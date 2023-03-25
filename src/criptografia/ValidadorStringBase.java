package criptografia;

public class ValidadorStringBase {

	public boolean validarAlfanumericaMaiusculoMinusculo(String stringBase) {
		return stringBase.matches("[a-z A-Z 0-9]*");
	}
	
	public boolean validarSomenteAlfabeticaMaiusculoMinusculo(String stringBase) {
		return stringBase.matches("[a-z A-Z]*");
	}

	public boolean validarSomenteNumeros(String stringBase) {
		return stringBase.matches("[0-9]*");
	}
}
