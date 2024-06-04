package GUI;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import mock.MockDados;
import model.Carrinho;
import model.Cliente;
import model.Funcionario;
import model.Livro;
import model.Venda;

public class CadastroVendasForm extends JDialog {
    
    private javax.swing.JButton btnAddCarrinho;
    private javax.swing.JButton btnDelCarrinho;
    private javax.swing.JButton btnSalvarVenda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodFuncionario;
    private javax.swing.JLabel lblCodigoLivro;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDadosCliente;
    private javax.swing.JLabel lblDadosFuncionario;
    private javax.swing.JLabel lblDadosLivro;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTituloCarrinho;
    private javax.swing.JLabel lblTituloVenda;
    private javax.swing.JTextField txtCodigoFuncionario;
    private javax.swing.JTextField txtCodigoLivro;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextArea txtaCarrinho;

    private MockDados repository;
    private ViewVendasPanel view;

    private int idCliente = -1;
    private int idFuncionario = -1;
    private Livro livroSelecionado = null;
    private int quantidadeLivros = 0;
    private List<Carrinho> carrinho;

    public CadastroVendasForm(MockDados repository, ViewVendasPanel view){
        this.repository = repository;
        this.view = view;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        lblTituloCarrinho = new javax.swing.JLabel();
        lblCodFuncionario = new javax.swing.JLabel();
        txtCodigoFuncionario = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblDadosFuncionario = new javax.swing.JLabel();
        lblDadosCliente = new javax.swing.JLabel();
        lblCodigoLivro = new javax.swing.JLabel();
        txtCodigoLivro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaCarrinho = new javax.swing.JTextArea();
        lblTituloVenda = new javax.swing.JLabel();
        btnAddCarrinho = new javax.swing.JButton();
        btnDelCarrinho = new javax.swing.JButton();
        btnSalvarVenda = new javax.swing.JButton();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblDadosLivro = new javax.swing.JLabel();

        carrinho = new ArrayList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTituloCarrinho.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lblTituloCarrinho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloCarrinho.setText("Carrinho");

        lblCodFuncionario.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblCodFuncionario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCodFuncionario.setText("Código Funcionário:");

        txtCodigoFuncionario.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtCodigoFuncionario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigoFuncionario.setToolTipText("");
        txtCodigoFuncionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoFuncionarioFocusLost(evt);
            }
        });

        lblCpf.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblCpf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCpf.setText("CPF Cliente:");

        txtCpf.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtCpf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCpf.setToolTipText("");
        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });

        lblDadosFuncionario.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblDadosFuncionario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDadosFuncionario.setText(" ");

        lblDadosCliente.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblDadosCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDadosCliente.setText(" ");

        lblCodigoLivro.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblCodigoLivro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCodigoLivro.setText("Código Livro:");

        txtCodigoLivro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtCodigoLivro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigoLivro.setToolTipText("");
        txtCodigoLivro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoLivroFocusLost(evt);
            }
        });

        txtaCarrinho.setColumns(20);
        txtaCarrinho.setRows(5);
        jScrollPane1.setViewportView(txtaCarrinho);

        lblTituloVenda.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lblTituloVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloVenda.setText("Registrar Venda");

        btnAddCarrinho.setText("ADD Carrinho");
        btnAddCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCarrinhoActionPerformed(evt);
            }
        });

        btnDelCarrinho.setText("DEL Carrinho");
        btnDelCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelCarrinhoActionPerformed(evt);
            }
        });

        btnSalvarVenda.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        btnSalvarVenda.setText("Salvar Venda");
        btnSalvarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarVendaActionPerformed(evt);
            }
        });

        lblQuantidade.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblQuantidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuantidade.setText("Quantidade:");

        txtQuantidade.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtQuantidade.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtQuantidade.setToolTipText("");
        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });

        lblDadosLivro.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblDadosLivro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDadosLivro.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigoLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDadosLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDadosCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDadosFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCodFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCpf)
                                    .addComponent(txtCodigoFuncionario)))
                            .addComponent(lblTituloCarrinho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(btnSalvarVenda)
                                .addGap(146, 146, 146)))
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTituloVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lblDadosCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodFuncionario)
                    .addComponent(txtCodigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDadosFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoLivro)
                    .addComponent(txtCodigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDadosLivro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCarrinho)
                    .addComponent(btnDelCarrinho))
                .addGap(18, 18, 18)
                .addComponent(lblTituloCarrinho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvarVenda)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(lblTituloVenda)
                    .addContainerGap(336, Short.MAX_VALUE)))
        );

        pack();
    }

    private void btnAddCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {
        String txt = txtaCarrinho.getText();
        if(idCliente > -1 && idFuncionario > -1 && livroSelecionado != null && quantidadeLivros > 0){

            List<Integer> codLivro = new ArrayList<>();
            List<Integer> quantLivro = new ArrayList<>();
            
            for (Carrinho car : carrinho) {
                codLivro.add(car.getLivroSelecionado().getCodigo());
                quantLivro.add(car.getQuantidadeLivro());
            }

            int qtLivro = 0;
            int cont = 0;
            for (Integer codLv : codLivro) {
                if(codLv == livroSelecionado.getCodigo()){
                    qtLivro += quantLivro.get(cont);
                }
                cont++;
            }

            if(repository.getEstoques(livroSelecionado.getCodigo()) < quantidadeLivros + qtLivro){
                JOptionPane.showMessageDialog(null, "Só tem disponível em estoque " + (repository.getEstoques(livroSelecionado.getCodigo()) - qtLivro) + " livros!");
            }else{
                Carrinho car = new Carrinho(idCliente, idFuncionario, livroSelecionado, quantidadeLivros);
                carrinho.add(car);
                txtaCarrinho.setText(txt + "Livro: " + livroSelecionado.getTitulo() + " - Quantidade: " + quantidadeLivros + "\n");
            }

        }else{
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios!");
        }                                                 
    }                                              

    private void btnDelCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void btnSalvarVendaActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if(carrinho == null || carrinho.size() == 0){
            JOptionPane.showMessageDialog(null, "Carrinho Vazio!");
        }else{
            int valorTotal = 0;
            List<Livro> livros = new ArrayList<>();
            
            for (Carrinho car : carrinho) {
                
                for (int i = 1; i <= car.getQuantidadeLivro(); i++) {
                    livros.add(car.getLivroSelecionado());
                    valorTotal += car.getLivroSelecionado().getPreco();
                }
                
                repository.saidaEstoque(car.getLivroSelecionado().getCodigo(), new Date(), car.getQuantidadeLivro());

            }

            Venda vd = new Venda(new Date(), valorTotal, livros, repository.getCliente(idCliente), repository.getFuncionario(idFuncionario));
            repository.addVenda(vd);

            //RECARREGAR O PAINEL VIEWCLIENTES
            view.removeAll();
            view.initComponents();

            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
    
            //FECHAR FORM ATUAL
            this.dispose();
            
        }
    }                                              

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {                                 

        List<Cliente> clientes = repository.getClientes();
        boolean found = false;
        int cont = 0;
        for (Cliente cli : clientes) {
            if(cli.getCpf().equals(txtCpf.getText())){
                lblDadosCliente.setText("Cliente: " + cli.getNome());
                idCliente = cont;
                found = true;
                break;
            }
            cont++;
        }

        if(!found){
            idCliente = -1;
            lblDadosCliente.setText(" ");
            txtCpf.setText("");
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
    }                                

    private void txtCodigoFuncionarioFocusLost(java.awt.event.FocusEvent evt) {                                               
        
        List<Funcionario> funcionarios = repository.getFuncionarios();
        
        if(!txtCodigoFuncionario.getText().equals("")){
            if(Integer.parseInt(txtCodigoFuncionario.getText()) <= funcionarios.size() - 1){
                idFuncionario = Integer.parseInt(txtCodigoFuncionario.getText());
                lblDadosFuncionario.setText("Funcionário: " + funcionarios.get(idFuncionario).getNome());
            }else{
                idFuncionario = -1;
                lblDadosFuncionario.setText(" ");
                txtCodigoFuncionario.setText("");
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
            }
        }
        
    }

    private void txtCodigoLivroFocusLost(java.awt.event.FocusEvent evt) {                                         
        
        List<Livro> livros = repository.getLivros();
        boolean found = false;

        if(!txtCodigoLivro.getText().equals("")){
            
            for (Livro liv : livros) {
                if(liv.getCodigo() == Integer.parseInt(txtCodigoLivro.getText())){
                    lblDadosLivro.setText("Livro: " + liv.getTitulo());
                    livroSelecionado = liv;
                    found = true;
                    break;
                }
            }

        }
        
        if(!found){
            lblDadosLivro.setText(" ");
            txtCodigoLivro.setText("");
            livroSelecionado = null;
            JOptionPane.showMessageDialog(null, "Livro não encontrado!");
        }
    }                                        

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {                                        
        if(!txtQuantidade.getText().equals("")){
            if(Integer.parseInt(txtQuantidade.getText()) <= 0){
                txtQuantidade.setText("");
                quantidadeLivros = 0;
                JOptionPane.showMessageDialog(null, "A quantidade não pode ser nula ou inferior à 0!");
            }else{
                quantidadeLivros = Integer.parseInt(txtQuantidade.getText());
            }
        }
    }
}
