package main;

import criptografia.EmbaralhadorString;
import criptografia.FachadaCriptografia;
import criptografia.MD5Encriptador;
import criptografia.SHA256Encriptador;
import criptografia.SHAEncriptador;

public class Aplicacao {

	public static void main(String[] args) {
		usandoSubsistemaCriptografiaSemFacade();
		usandoSubsistemaCriptografiaComFacade();
	}

	private static void usandoSubsistemaCriptografiaSemFacade() {
		String stringBase = "PP ADS FACADE";

		/* TODO/OK FACADE.01
		 * 
		 * 1. Utilizaremos aqui o subsistema (pacote) criptografia j� existem e desejamos 
		 * utiliz�-las. Um subsistema pode ser compreendido como um ou mais pacotes 
		 * cujas classes disponibilizam objetos que cooperam para entregar um m�dulo
		 * ou bloco de funcionalidades.
		 * 
		 * 2. Encripte o valor contido na vari�vel {stringBase} j� declarada abaixo. Para isso, 
		 * use um objeto da classe {MD5Encriptador} e exiba o resultado na sa�da.
		 * 
		 * 3. Encripte a {stringBase} usando agora o objeto {SHAEncriptador} e exiba 
		 * o resultado na sa�da.
		 * 
		 * 4. Encripte {a stringBase} usando o objeto {SHA256Encriptador} e exiba na sa�da.
		 * 
		 * 5. Embaralhe a {stringBase} com o objeto {EmbaralhadorString}, invocando-lhe 
		 * {adicionarHorarioDoSistema()}. Pegue o resultado disso e encripte usando o 
		 * objeto {SHA256Encriptador} e exiba o resultado na sa�da.
		 * 
		 * 6. Embaralhe a {stringBase} com o objeto {EmbaralhadorString}, invocando-lhe 
		 * {adicionarHorarioDoSistema()} e em seguida {adicionarChaveDeEmbaralhamento()}, esse
		 * �ltimo m�todo pede uma string adicional como par�metro. Pegue o resultado disso e
		 * encripte usando o objeto {SHA256Encriptador} e exiba o resultado na sa�da.
		 * 
		 * ---------- 
		 * [PERGUNTA A] 
		 * O m�todo aqui implementado equivaleria a um codigo cliente que estaria usando 
		 * um subsistema de objetos para criptografia. Somente pelos passos 1 a 5 acima, 
		 * voce achou intuitivo para programadores clientes das classes envolvidas chamar 
		 * funcionalidades de encripta��o a partir de uma string, considerando o nivel de 
		 * seguran�a do m�todo de criptografia (mais ou menos seguras)? 
		 * OBS.: imagine que os programadores clientes do subsitema ou n�o teriam
		 * acesso ao c�digo fonte dessas classes ou seria trabalhoso l�-las.
		 * 
		 * [ 
		 *   Não é nada intuitivo, pois, o cliente não tem nenhum indicativo do nível que cada 
		 *   método encriptador vai retornar a String, e também que possui métodos mais complexos 
		 *   de serem configurados! 
		 * ]
		 * ----------
		 * 
		 *
		 */

		MD5Encriptador md5 = new MD5Encriptador();
		System.out.println(md5.encriptar(stringBase));


		SHAEncriptador shae = new SHAEncriptador();
		System.out.println(shae.encriptar(stringBase));  


		SHA256Encriptador  sha256  = new SHA256Encriptador();
		System.out.println(sha256.encriptar(stringBase));

		EmbaralhadorString embaralhador1 = new EmbaralhadorString(stringBase);
		
		embaralhador1.adicionarHorarioDoSistema();
		System.out.println(sha256.encriptar(embaralhador1.toString()));

		EmbaralhadorString embaralhador2 = new EmbaralhadorString(stringBase);
		embaralhador2.adicionarHorarioDoSistema();
		embaralhador2.adicionarChaveDeEmbaralhamento("celiolindo");
		System.out.println(sha256.encriptar(embaralhador2.toString()));
	}

	private static void usandoSubsistemaCriptografiaComFacade() {

		String stringBase = "PP ADS FACADE";

		FachadaCriptografia fachada = new FachadaCriptografia();
		System.out.println(fachada.encriptarFraco(stringBase));
		System.out.println(fachada.encriptarMedio(stringBase));
		System.out.println(fachada.encriptarForte(stringBase));
		System.out.println(fachada.encriptarMuitoForte(stringBase));
		System.out.println(fachada.encriptarMuitissimoForte(stringBase));
		System.out.println(fachada.encriptarMuitissimoForte(stringBase, false));

		/*
		 * TODO/OK FACADE.02
		 * 
		 * 1. Assuma que agora vamos dispor um "jeito de usar" o subsistema de criptgrafia,
		 * por meio de uma interface simplificadora e reutiliz�vel.
		 * 
		 * 2. Para isso, implemente a classe {Fachada}, cuja coes�o foca 
		 * em simplificar o entendimento e uso de funcionalidades do nosso subsistema de criptografia.
		 * Implemente os servi�os providos por esta fachada a partir ds m�todos propostos 
		 * nas explica��es dos passos presentes no TODO_FACADE.03.
		 *  
		 * 3. Conhecendo e estando dispon�vel agora a fachada, encripte a {stringBase},
		 * incovando os servi�os de encripta��o dela, do mais fraco ao mais forte, exibindo os
		 * respectivos resultados na sa�da. 
		 * 
		 * ---------- 
		 * [PERGUNTA B] 
		 * Considerando a experi�ncia de dispor um c�digo cliente do padr�o Fa�ade, considerando
		 * a sua utilidade para usar mais facilmente objetos do subsistema de criptografia, 
		 * que benef�cios ficam percept�veis em rela��o ao uso sem o padr�o, experimentado
		 * anteriormente? 
		 * [ 
		 *   O cliente se isola do subsistema de criptografia, diminuindo assim o acoplamento, 
		 *   acaba com a replicação de código, torna o processo de encriptação mais intuitivo 
		 *   para os clientes, pois a fachada possui os métodos de acordo com o nível de encriptação! 
		 * ]
		 * ----------
		 * 
		 * ---------- 
		 * [PERGUNTA C] 
		 * Considerando o c�digo implementado na classe Fa�ade, ela est� mantendo refer�ncias 
		 * para objetos os objetos �teis do subsistema de criptografia? Manter essas refer�ncias 
		 * descaracterizaria o padr�o (especialmente se mantidas como atributos na classe da 
		 * fachada)? Por qu�?
		 * [
		 * Não descaracterizaria, pois, a classe fachada tem exatamente esse propósito, intermediar 
		 * a relação entre o cliente e os objetos úteis! 
		 * ]
		 * ----------
		 * 
		 * ---------- 
		 * [PERGUNTA D] 
		 * E o contr�rio: os objetos �teis estariam se acoplando ou dependendo da classe Fa�ade, 
		 * quando voc� a implementou? Manter referencias assim descaracterizaria o padr�o e 
		 * por qu� (explique sob a perspectiva do reuso das classes de objetos �teis)?
		 * [ 
		 *   Os objetos úteis não estão se acoplando com a fachada. Sim, descaracterizaria, pois os 
		 *  objetos úteis tem a função de prover as funcionalidades para a interface(Fachada) implementar 
		 *  de uma forma simples, por isso, objetos úteis se acoplarem com a fachada não é correto, 
		 *  apenas dificultaria o reuso	dos objetos úteis!
		 * ]
		 * ----------
		 * 
		 * ---------- 
		 * [PERGUNTA E] 
		 * No TODO_FACADE.03.7 alteramos a implementa��o interna de um m�todo j� existente da fachada e em uso por um c�digo
		 * cliente dessas mesma fachada. Essa altera��o passou despercebida para esse c�digo cliente (ele
		 * precisou ser modificado) e por qu�? Haveria uma situa��o em que modificar esse m�todo resultaria em impacto no c�digo 
		 * de clientes que j� utilizam-no?
		 * [
		 *   Sim, passou despercebido, pois as alterações que fizeram resultam apenas na classe fachada, que faz o contato direto
		 *   com os objetos úteis. Não, toda alteração seja nos objetos úteis ou na fachada, não resultarim em nenhum impacto no 
		 *   código cliente, 
		 *  ]
		 * ----------
		 * 
		 * ---------- 
		 * [PERGUNTA F] 
		 * No TODO_FACADE.03.8 acrescentamos uma nova funcionalidade simplificada do subsistema 
		 * na fachada (novo m�todo). Essa adi��o de m�todo passou despercebida para o c�digo cliente? 
		 * Isso seria uma vantagem do padr�o e por qu�?
		 * [
		 *   SIM, o cliente pode escolher funcionalidades que serão de melhor utilidade, ele não é forçado a usar todas elas
		 * ]
		 * ----------
		 */

	}

}
