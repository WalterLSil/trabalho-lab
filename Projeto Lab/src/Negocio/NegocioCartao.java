package Negocio;
import java.util.Scanner;
/*
A classe NegocioCartao vai fazer toda aa valida��es (se tem letras ou numeros faltando)sobre as informa��es do cart�o
no metodo validarDatadeValidade o usuario tera q escrever (mes/ano) da validade do cart�o
 */
public class NegocioCartao {
	Scanner sc = new Scanner(System.in);
	public String validarNumero(String numerocartao) {
		//vai verificar se tem 16 numeros e nem uma letra ex.(1478523698521478) e retorna corrigido
			while (!numerocartao.matches("\\d{16}")) {
				System.out.println("Numero do cartao errado, por favor digite corretamente: ");
				numerocartao = sc.next();
			}
			System.out.println("numero do cartao valido.");
			return numerocartao;
	}
	public String validarDatadeValidade(String s) {
		//vai verificar se a data esta correta exemplo ex.(12/22) e retorna corrigido
			while (!s.matches("\\d{2}/\\d{2}")) {
				System.out.println("A validade do cartao esta errada, por favor digite corretamente: ");
				s = sc.next();
			}
			System.out.println("Data de validade do cartao esta valida.");
			return s;
	}
	public int validarCodigoDeSeguranca(int codigodeseguranca) {
		String s = Integer.toString(codigodeseguranca);
		//vai verificar o codigo de seguran�a se tem 3 numeros e n�o letrar ex.(325) e retorna corrigido
			while (!s.matches("\\d{3}")) {
				System.out.println("O codido de seguran�a do cartao esta errado, por favor digite corretamente: ");
				codigodeseguranca = sc.nextInt();
				s = Integer.toString(codigodeseguranca);
			}
			System.out.println("O codigo de seguran�a do cartao esta valido.");
			return Integer.parseInt(s);
	}
}