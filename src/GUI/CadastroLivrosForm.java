package GUI;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import mock.MockDados;
import model.Livro;

public class CadastroLivrosForm extends JDialog {
    
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloLivro;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtTituloLivro;

    private MockDados repository;
    private ViewLivrosPanel view;
    private Livro livro;
    private int id;

    public CadastroLivrosForm(MockDados repository, ViewLivrosPanel view){
        this.repository = repository;
        this.view = view;
        this.initComponents();
        setLocationRelativeTo(null);
    }

    //Construtor - EDIÇÃO
    public CadastroLivrosForm(MockDados repository, ViewLivrosPanel view, Livro livro, int id){
        this.repository = repository;
        this.view = view;
        this.livro = livro;
        this.id = id;
        this.initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblTituloLivro = new javax.swing.JLabel();
        txtTituloLivro = new javax.swing.JTextField();
        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblIsbn = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setModal(true);
        setTitle("Cadastro de Livros");
        btnSalvar.setText("Cadastrar");
        lblTitulo.setText("Cadastro de Livro");
        getRootPane().setDefaultButton(btnSalvar);

        //Se livro NÃO for vazia, INICIE A EDIÇÃO
        if(this.livro != null){
            txtTituloLivro.setText(livro.getTitulo());
            txtAutor.setText(livro.getAutor());
            txtIsbn.setText(livro.getISBN());
            txtPreco.setText(String.valueOf(livro.getPreco()));
            
            setTitle("Editar Cadastro do Livro");
            btnSalvar.setText("Atualizar");
            lblTitulo.setText("Edição do Cadastro do Livro");
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Livro");

        lblTituloLivro.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblTituloLivro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTituloLivro.setText("Título:");

        txtTituloLivro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtTituloLivro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTituloLivro.setToolTipText("");

        lblAutor.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblAutor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAutor.setText("Autor:");

        txtAutor.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtAutor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtAutor.setToolTipText("");

        lblIsbn.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblIsbn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIsbn.setText("ISBN:");

        txtIsbn.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtIsbn.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIsbn.setToolTipText("");

        lblPreco.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblPreco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPreco.setText("Preço:");

        txtPreco.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtPreco.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPreco.setToolTipText("");

        btnSalvar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAutor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTituloLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTituloLivro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloLivro)
                    .addComponent(txtTituloLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutor)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIsbn)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {    
        
        String msg = "";

        if(txtTituloLivro.getText().equals("")){
            msg = "Preencher TÍTULO DO LIVRO";
            txtTituloLivro.requestFocusInWindow();
        }else if(txtAutor.getText().equals("")){
            msg = "Preencher AUTOR DO LIVRO";
            txtAutor.requestFocusInWindow();
        }else if(txtIsbn.getText().equals("")){
            msg = "Preencher ISBN DO LIVRO";
            txtIsbn.requestFocusInWindow();
        }else if(txtPreco.getText().equals("")){
            msg = "Preencher PREÇO DO LIVRO";
            txtPreco.requestFocusInWindow();
        }else{
            if(this.livro == null){
                Livro livro = new Livro(repository.gerarIdUnicoParaLivro(), txtTituloLivro.getText(), txtAutor.getText(), txtIsbn.getText(), Double.parseDouble(txtPreco.getText()));
                repository.addLivro(livro);
                JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
            }else{
                Livro livroUpdate = new Livro(this.livro.getCodigo(), txtTituloLivro.getText(), txtAutor.getText(), txtIsbn.getText(), Double.parseDouble(txtPreco.getText()));
                repository.updateLivro(id, livroUpdate);
                JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
            }

            //RECARREGAR O PAINEL VIEWCLIENTES
            view.removeAll();
            view.initComponents();
    
            //FECHAR FORM ATUAL
            this.dispose();
        }
        
        if(!msg.equals("")){
            JOptionPane.showMessageDialog(null, msg, "Campo Vazio", JOptionPane.ERROR_MESSAGE);
        } 
    } 

}
