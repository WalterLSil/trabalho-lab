package Dados;

import Entidades.Cartao;
import Entidades.Cliente;
import Entidades.Endereco;

import java.io.*;
import java.util.ArrayList;

public class DadosCliente {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public DadosCliente(){
        atualizarArray();
    }

    public ArrayList<Cliente> lerDadosCliente() {
        return clientes;
    }

    public void receberDadosCliente(Cliente cliente1) {
        clientes.add(cliente1);
    }
    public void alterarDadosCliente(int i, Cliente cliente) {
		clientes.set(i, cliente);
	}
	public void removerDadosCliente(int i){
        clientes.remove(i);
    }
    public void atualizarCliente(){
        try {
            ObjectOutputStream oss= new ObjectOutputStream(new FileOutputStream("src/Clientes.txt"));
            oss.writeObject(clientes);
            oss.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void atualizarArray(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Clientes.txt"));
            clientes = (ArrayList<Cliente>) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void preCadastrados(){
        Cartao cartao;
        Endereco endereco;
        cartao = new Cartao("jose pietro silva", "4455447844633328", "1128", 977, 1000);
        endereco = new Endereco("eita", "50980160", "178", "iputinga", "recife", "PE");
        clientes.add(new Cliente("javier", "17564895512", "10031992", endereco, "okokokokok"));
        clientes.add(new Cliente("jose", "88915398702", "10031992", cartao, endereco, "okokokokok"));
        clientes.add(new Cliente("francisco", "02456687301", "10031992", endereco, "okokokokok"));
        clientes.add(new Cliente("Xavier", "34458941278", "10031992", endereco, "okokokokok"));
        clientes.add(new Cliente("pedro", "44498766255", "10031992", endereco, "okokokokok"));
    }
}
