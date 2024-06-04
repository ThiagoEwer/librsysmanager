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
    private List<MovimentoEstoque> movimentos;
    private Estoque estoques;

    public MockDados() {
        initializeData();
    }

    private void initializeData() {
        // Inicializar listas
        livros = new ArrayList<>();
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        vendas = new ArrayList<>();
        promocoes = new ArrayList<>();

        // Mock GERAL!
        movimentos = new ArrayList<>(Arrays.asList(
            new MovimentoEstoque(1, new Date(124, 4, 31), 10, TipoMovimento.ENTRADA),
            new MovimentoEstoque(2, new Date(124, 3, 15), 5, TipoMovimento.ENTRADA),
            new MovimentoEstoque(3, new Date(124, 5, 22), 8, TipoMovimento.ENTRADA),
            new MovimentoEstoque(4, new Date(124, 5, 10), 7, TipoMovimento.ENTRADA),
            new MovimentoEstoque(5, new Date(124, 5, 26), 4, TipoMovimento.ENTRADA)
        ));
        estoques = new Estoque(movimentos);

        livros = new ArrayList<>(Arrays.asList(
                new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", "978-0-261-10320-9", 89.90),
                new Livro(2, "O Hobbit", "J.R.R. Tolkien", "978-0-261-10221-9", 49.90),
                new Livro(3, "1984", "George Orwell", "978-0-452-28423-4", 39.90),
                new Livro(4, "Dom Quixote", "Miguel de Cervantes", "978-0-14-243723-0", 59.90),
                new Livro(5, "Guerra e Paz", "Liev Tolstói", "978-0-14-044793-4", 99.90)
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

        vendas = new ArrayList<>(Arrays.asList(
                new Venda(new Date(System.currentTimeMillis() - 86400000 * 3), 139.80, Arrays.asList(livros.get(0), livros.get(1)), clientes.get(0), funcionarios.get(0)),
                new Venda(new Date(System.currentTimeMillis() - 86400000 * 2), 99.80, Arrays.asList(livros.get(2), livros.get(3)), clientes.get(1), funcionarios.get(1)),
                new Venda(new Date(System.currentTimeMillis() - 86400000), 99.90, Arrays.asList(livros.get(4)), clientes.get(0), funcionarios.get(1))
        ));

        promocoes = new ArrayList<>(Arrays.asList(
                new Promocao("Desconto de Verão", 10.0, new Date(), new Date()),
                new Promocao("Promoção de Inverno", 15.0, new Date(), new Date())
        ));
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public Livro getLivroPorCodigo(int codigo){
        for (Livro livro : livros) {
            if(livro.getCodigo() == codigo){
                return livro;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void updateCliente(int id, Cliente cliente) {
        this.clientes.set(id, cliente);
    }

    public void deletarCliente(int id) {
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

    public Estoque getEstoques() {
        return estoques;
    }

    public List<MovimentoEstoque> getMovimentacoesPorCodigo(int codigo){
        return estoques.getMovimentacoesEstoquePorCodigo(codigo);
    }

    public int getEstoques(int codigo){
        return estoques.getEstoquePorCodigo(codigo);
    }

    public Date getDataEntradaEstoques(int codigo){
        return estoques.getDataEntradaEstoquePorCodigo(codigo);
    }
    
    public void entradaEstoque(int codigoLivro, Date dataEntrada, int quantidade) {
        estoques.adicionarEntrada(codigoLivro, dataEntrada, quantidade);
    }

    public void saidaEstoque(int codigoLivro, Date dataSaida, int quantidade){
        estoques.adicionarSaida(codigoLivro, dataSaida, quantidade);
    }

    // método para gerar IDs únicos para os livros
    public int gerarIdUnicoParaLivro() {
        return livros.size() + 1;
    }

    // Add um livro ao repositório
    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void updateLivro(int id, Livro livro) {
        this.livros.set(id, livro);
    }

    public void deletarLivro(int id) {
        this.livros.remove(id);
    }

    // Método para imprimir detalhes das vendas
    public void imprimirDetalhesDasVendas() {
        for (Venda venda : vendas) {
            System.out.println(venda.getVendaDetalhes());
        }
    }
}
