package Apresenta�ao;

import Entidades.Cartao;
import Entidades.Cliente;
import Entidades.Endereco;
import Negocio.NegocioCartao;
import Negocio.NegocioCliente;
import Negocio.NegocioEndereco;
import Util.Util;

import java.util.Scanner;

public class ClienteApresentacao {
    private Scanner sc = new Scanner(System.in);
    public NegocioCliente negociocliente = new NegocioCliente();
    public NegocioCartao negociocartao = new NegocioCartao();
    public NegocioEndereco negocioendereco = new NegocioEndereco();
    private int i;

    //sistema de cadastro de clientes
    public void CadastrarCliente() {
        System.out.println("*******************************Cadastrar Cliente*********************************\n");
        System.out.println("------------------------------Endere�o------------------------------------------\n");
        System.out.println("Lugadouro: ");
        String lugadouro = sc.nextLine();
        System.out.println("Numero: ");
        String numero = sc.next();
        System.out.println("Bairro: ");
        String bairro = sc.next();
        System.out.println("Cidade: ");
        String cidade = sc.next();
        System.out.println("Estado: ");
        String estado = sc.next();
        System.out.println("CEP: ");
        String cep = sc.next();
        cep = negocioendereco.validarCEP(cep);//vai validar o cep e retornar corrigido
        Endereco endereco = new Endereco(lugadouro, cep, numero, bairro, cidade, estado);
        System.out.println("\n----------------------------------Dados Cliente-----------------------------------");
        sc.nextLine();
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Data de nascimento: ");
        String data = sc.next();
        System.out.println("CPF: ");
        String cpf = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        System.out.println("deseja cadastrar o cart�o? ");
        String opc = sc.next().toLowerCase();
        Cliente cliente;
        if (opc.equals("sim")) {
            System.out.println("\n----------------------------------Dados Cart�o-----------------------------------");
            sc.nextLine();
            System.out.println("Nome do Titular do Cartao: ");
            String nometitular = sc.nextLine();
            System.out.println("N�mero do Cart�o: ");
            String numerocartao = sc.next();
            numerocartao = negociocartao.validarNumero(numerocartao);//vai validar o numero e retornar corrigido
            System.out.println("data de validade: ");
            String datavalidade = sc.next();
            datavalidade = negociocartao.validarDatadeValidade(datavalidade);//vai validar a data e retornar corrigido
            System.out.println("c�digo de seguran�a: ");
            int codigoseguranca = sc.nextInt();
            codigoseguranca = negociocartao.validarCodigoDeSeguranca(codigoseguranca);//vai validar o codigo e retornar corrigido
            System.out.println("Limite: ");
            double limite = sc.nextDouble();
            Cartao cartao = new Cartao(nometitular, numerocartao, datavalidade, codigoseguranca, limite);
            cliente = new Cliente(nome, cpf, data, cartao, endereco, senha);

        } else {
            cliente = new Cliente(nome, cpf, data, endereco, senha);
        }
        negociocliente.CadastroCliente(cliente);
    }

    //
    public void logarCliente() {
    	System.out.println("informe seu  CPF: ");
        String cpf = sc.next();
        System.out.println("informe sua senha: ");
        String senha = sc.next();
         i = negociocliente.Verificarcliente(cpf, senha);
	}
    
    //obter dados do cliente
    public void InterfaceDadosCliente() {
        System.out.println("*******************************************Dados do Cliente************************************\n");
        System.out.println("Nome: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getNome() + "\n"
                + "Data de Nascimento: " + Util.formatarDataNascimento(negociocliente.getDadoscliente().lerDadosCliente().get(i).getData()) + "\n"
                + "CPF: " + Util.formatarCPF(negociocliente.getDadoscliente().lerDadosCliente().get(i).getCpf()) + "\n");
        System.out.println("-deseja obter informa��es sobre o endere�o? ");
        String opc = sc.next().toLowerCase();
        if (opc.equals("sim")) {
            System.out.println("***************************************Dados Endere�o Cliente******************************\n");
            System.out.println("Lugadouro: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getLugadouro() + "\n"
                    + "N�: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getNumeroResidencia() + "\n"
                    + "Bairro: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getBairro() + "\n"
                    + "Cidade: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getCidade() + "\n"
                    + "Estado: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getEstado() + "\n"
                    + "CEP: " + Util.formatarCEP(negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getCep()) + "\n");
        }
        System.out.println("-deseja obter informa��es do cart�o? ");
        opc = sc.next().toLowerCase();
        if (opc.equals("sim")) {
            if (negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao() != null) {
                System.out.println("***************************************Dados Cart�o Cliente******************************");
                System.out.println("Nome do Titular: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getNometitular() + "\n"
                        + "N�mero do cartao: " + Util.formatarNumeroCartao(negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getNumerocartao()) + "\n"
                        + "Validade: " + Util.formatarDataCartao(negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getValidade()) + "\n");
            } else {
                System.out.println("Cart�o n�o cadastrado");
            }
        }
    }
    
    //alterar dados do cliente
    public void AlterarDados() {
            System.out.println("\n----------------------------------Dados Cliente-----------------------------------");
            sc.nextLine();
            System.out.println("Nome: ");
            String nome = sc.nextLine();
            System.out.println("Data de nascimento: ");
            String data = sc.next();
            System.out.println("CPF: ");
            String cpf = sc.next();
            System.out.println("Senha: ");
            String senha = sc.next();
           
            System.out.println("------------------------------Endere�o------------------------------------------\n");
            sc.nextLine();
            System.out.println("Lugadouro: ");
            String lugadouro = sc.nextLine();
            System.out.println("Numero: ");
            String numero = sc.next();
            System.out.println("Bairro: ");
            String bairro = sc.next();
            System.out.println("Cidade: ");
            String cidade = sc.next();
            System.out.println("Estado: ");
            String estado = sc.next();
            System.out.println("CEP: ");
            String cep = sc.next();
            cep=negocioendereco.validarCEP(cep);//vai validar o cep e retornar corrigido
            Endereco endereco = new Endereco(lugadouro, cep, numero, bairro, cidade, estado);
            
            System.out.println("*Alterar* dados do cart�o ?");
            String opAltCart�o = sc.next().toLowerCase();
        
        if (opAltCart�o.equals("sim")) {
            System.out.println("\n----------------------------------Dados Cart�o-----------------------------------");
            System.out.println("Nome do Titular do Cartao: ");
            String nometitular = sc.nextLine();
            System.out.println("N�mero do Cart�o: ");
            String numerocartao = sc.next();
            numerocartao=negociocartao.validarNumero(numerocartao);//vai validar o numero do cart�o e retornar corrigido
            System.out.println("data de validade: ");
            String datavalidade = sc.next();
            datavalidade=negociocartao.validarDatadeValidade(datavalidade);//vai validar a data e retornar corrigido
            System.out.println("c�digo de seguran�a: ");
            int codigoseguranca = sc.nextInt();
            codigoseguranca=negociocartao.validarCodigoDeSeguranca(codigoseguranca);//vai validar o codigo e retornar corrigido
            System.out.println("Limite: ");
            double limite = sc.nextDouble();
            Cartao cartao = new Cartao(nometitular, numerocartao, datavalidade, codigoseguranca, limite);
            
            negociocliente.alterarCliente(new Cliente(nome, cpf, data, cartao, endereco, senha), i);
        }else {
        	negociocliente.alterarCliente(new Cliente(nome, cpf, data, endereco, senha), i);
        }
        
    }
}
