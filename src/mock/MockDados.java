package mock;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MockDados {
    private List<Livro> livros;
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    private List<Venda> vendas;
    private List<Promocao> promocoes;

    public MockDados() {
        initializeData();
    }

    private void initializeData() {
        // Como não vamos usar o SQL, aqui abaixo seguem os dados mockados dos objetos que vamos usar
        livros = new ArrayList<>(Arrays.asList(
            new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "978-0-261-10320-9", 89.90, 10),
            new Livro("O Hobbit", "J.R.R. Tolkien", "978-0-261-10221-9", 49.90, 5),
            new Livro("1984", "George Orwell", "978-0-452-28423-4", 39.90, 8),
            new Livro("Dom Quixote", "Miguel de Cervantes", "978-0-14-243723-0", 59.90, 7),
            new Livro("Guerra e Paz", "Liev Tolstói", "978-0-14-044793-4", 99.90, 4)
        ));

        Endereco enderecoCliente1 = new Endereco("Avenida Paulista", "1000", "São Paulo", "SP", "01310-100");
        Endereco enderecoCliente2 = new Endereco("Rua XV de Novembro", "500", "Curitiba", "PR", "80020-310");
        clientes = new ArrayList<>(Arrays.asList(
            new Cliente("João da Silva", "123.456.789-00", "joao.silva@gmail.com", "11 99999-8888", enderecoCliente1),
            new Cliente("Maria Oliveira", "987.654.321-00", "maria.oliveira@gmail.com", "41 98888-7777", enderecoCliente2)
        ));

        Endereco enderecoFuncionario1 = new Endereco("Rua das Flores", "150", "Rio de Janeiro", "RJ", "20010-020");
        Endereco enderecoFuncionario2 = new Endereco("Avenida Brasil", "200", "Belo Horizonte", "MG", "30140-001");
        funcionarios = new ArrayList<>(Arrays.asList(
            new Funcionario("Carlos Souza", "111.222.333-44", "carlos.souza@empresa.com", "21 97777-6666", enderecoFuncionario1, "Gerente", 5000.00, new Date()),
            new Funcionario("Ana Lima", "555.666.777-88", "ana.lima@empresa.com", "31 96666-5555", enderecoFuncionario2, "Vendedora", 3000.00, new Date())
        ));

        vendas = new ArrayList<>();

        promocoes = new ArrayList<>(Arrays.asList(
            new Promocao("Desconto de Verão", 10.0, new Date(), new Date()),
            new Promocao("Promoção de Inverno", 15.0, new Date(), new Date())
        ));
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void updateCliente(int id, Cliente cliente){
        this.clientes.set(id, cliente);
    }

    public void deletarCliente(int id){
        this.clientes.remove(id);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void addVenda(Venda venda) {
        vendas.add(venda);
    }
}