package criptografia;

/* TODO/OK FACADE.03
 * 
 * 1. Verifique se esta fachada deve se compor (referenciar como atributo privado), 
 * objetos �teis ao provimento das funcionalidades do subsistuem de criptgrafia (veja
 * os pr�ximos passos). A coes�o dessa classe (prop�sito de exist�ncia) foca na
 * disponibiliz��o de servi�os de forma simplificada, que combinam usos de funcionalidades
 * providas por classes do subsistema de criptografia. Reforce essa coes�o alterando o nome
 * desta classe para que remeta do que ela est� servindo como interface de fachada. 
 * 
 * 2. Implemente esta fachada de modo que o TODO_FACADE.01.2 seja conhecido como uma funcionalidade
 * encriptarFraco();
 * 
 * 3. Implemente esta fachada de modo que o TODO_FACADE.01.3 seja conhecido como uma funcionalidade
 * encriptarMedio();
 * 
 * 4. Implemente esta fachada de modo que o TODO_FACADE.01.4 seja conhecido como uma funcionalidade
 * encriptarForte();
 * 
 * 5. Implemente esta fachada de modo que o TODO_FACADE.01.5 seja conhecido como uma funcionalidade
 * encriptarMuitoForte();
 * 
 * 6. Implemente esta fachada de modo que o TODO_FACADE.01.6 seja conhecido como uma funcionalidade
 * encriptarMuitissimoForte();
 * 
 * 7. Assuma que se passaram alguns meses depois que finalizamos esta fachada.
 * O mantenedor dessa classe tem que alterar o m�todo {encriptarMuitissimoForte()}
 * para que passe a usar o objeto da classe {ValidadorStringBase}, invocando-lhe 
 * {validarAlfanumericaMaiusculoMinusculo()}, antes da linha que efetivamente
 * aciona a encripta��o.
 * 
 * 8. Assuma que se passaram mais alguns dias depois que finalizamos esta fachada. 
 * Agora o mantenedor dessa classe tem que alter�-la, adicionando um novo servi�o a partir
 * da disponibiliza��o de um novo m�todo que sobrecarrega {encriptarMuitissimoForte()}.
 * A implementa��o desse novo servi�o, considera a execu��o parametrizada de valida��o 
 * ou n�o, pela invoca��o de {validarAlfanumericaMaiusculoMinusculo()} para um objeto
 * da classe {ValidadorStringBase}, antes de efetivamente encriptar.
 */
public class FachadaCriptografia {

    private SHA256Encriptador  sha256Encriptador = new SHA256Encriptador();
    
    private ValidadorStringBase validador = new ValidadorStringBase();

    private EmbaralhadorString embaralhadorString;

	public String encriptarFraco(String string){
        MD5Encriptador md5Encriptador = new MD5Encriptador();
		return md5Encriptador.encriptar(string);
    }

    public String encriptarMedio(String string){
        SHAEncriptador shaEncriptador = new SHAEncriptador();
		return shaEncriptador.encriptar(string);
    }

    public String encriptarForte(String string){
        SHA256Encriptador  sha256Encriptador  = new SHA256Encriptador();
		return sha256Encriptador.encriptar(string);
    }

    public String encriptarMuitoForte(String string){
        embaralhadorString = new EmbaralhadorString(string);
		
		embaralhadorString.adicionarHorarioDoSistema();
		return sha256Encriptador.encriptar(embaralhadorString.toString());
    }

    public String encriptarMuitissimoForte(String string){

        embaralhadorString = new EmbaralhadorString(string);
		embaralhadorString.adicionarHorarioDoSistema();
		embaralhadorString.adicionarChaveDeEmbaralhamento("celiolindo");

        String strinBaseEmbaralhada = embaralhadorString.toString();

        validador.validarAlfanumericaMaiusculoMinusculo(strinBaseEmbaralhada);

		return sha256Encriptador.encriptar(strinBaseEmbaralhada);
    }
	
    public String encriptarMuitissimoForte(String string, boolean validacao){

        embaralhadorString = new EmbaralhadorString(string);
        embaralhadorString.adicionarHorarioDoSistema();
        embaralhadorString.adicionarChaveDeEmbaralhamento("celionaotaolindo");

        String stringBaseEmbaralhada = embaralhadorString.toString();

        if(validacao) 
            validador.validarAlfanumericaMaiusculoMinusculo(stringBaseEmbaralhada);

        return sha256Encriptador.encriptar(stringBaseEmbaralhada);
    }
}
