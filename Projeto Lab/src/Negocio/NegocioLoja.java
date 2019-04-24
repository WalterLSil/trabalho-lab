package Negocio;

import java.util.Scanner;

import Dados.DadosLoja;
import Entidades.Loja;

/*
 * essa classe tem como o objetivo de validar os dados da Loja
 * como: 
 * validar cria��o de uma nova loja
 * validar cnpj
 * validadar altara��o de dados das lojas
 * buscar loja
 * Validar remo��o da loja
 * 
 */

public class NegocioLoja {

	private Scanner sc = new Scanner(System.in);
	private DadosLoja dadosLoja = new DadosLoja();

	
	//validar cnpj
	public String validarCNPJ(String cnpj) {
		boolean f = cnpj.matches("\\d{14}");
		while (f == false) {
			System.out.println("cnpj invalido, por favor digite corretamente: ");
			cnpj = sc.next();
			f = cnpj.matches("\\d{14}");
		}

		System.out.println("cnpj valido!");
		return cnpj;
	}

	//validar data de inicializa��o da loja
	public String validarDataCriacao(String datacriacao) {
		while (datacriacao.length() != 8) {
			System.out.println("data invalida, por favor digite corretamente: ");
			datacriacao = sc.next();
		}
		System.out.println("data valida!");
		return datacriacao;
	}

	//validar cadastro da loja
	public boolean CadstrarLoja(Loja loja) {
		dadosLoja.receberDadosLoja(loja);
		return true;
	}

	//buscar loja
	public int Verificarloja(String cnpj) {
		int i;
		int size=dadosLoja.lerDadosLoja().size();
		for (i = 0; i < size; i++) {
			if (cnpj.equals(dadosLoja.lerDadosLoja().get(i).getCnpj())) {
				break;
			}
		}
		return i;
	}
	
	public DadosLoja getDadosLoja() {
		return dadosLoja;
	}
	public void setDadosLoja(DadosLoja dadosLoja) {
		this.dadosLoja = dadosLoja;
	}
	
	
}
