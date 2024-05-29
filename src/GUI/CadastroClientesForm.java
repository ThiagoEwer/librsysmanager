package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mock.MockDados;
import model.Cliente;
import model.Endereco;

import java.awt.event.ActionEvent;

public class CadastroClientesForm extends JFrame{

    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndCep;
    private javax.swing.JLabel lblEndCidade;
    private javax.swing.JLabel lblEndEstado;
    private javax.swing.JLabel lblEndNumero;
    private javax.swing.JLabel lblEndRua;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndCep;
    private javax.swing.JTextField txtEndCidade;
    private javax.swing.JTextField txtEndEstado;
    private javax.swing.JTextField txtEndNumero;
    private javax.swing.JTextField txtEndRua;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;

    private MockDados repository;
    private ViewClientesForm view;
    private Cliente cliente;
    private int id;

    //Construtor - CADASTRO
    public CadastroClientesForm(MockDados repository, ViewClientesForm view){
        this.repository = repository;
        this.view = view;
        this.inicializar();
        setLocationRelativeTo(null);
    }

    //Construtor - EDIÇÃO
    public CadastroClientesForm(MockDados repository, ViewClientesForm view, Cliente cliente, int id){
        this.repository = repository;
        this.view = view;
        this.cliente = cliente;
        this.id = id;
        this.inicializar();
        setLocationRelativeTo(null);
    }

    //Método de inicialização do FRAME
    private void inicializar(){

        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        txtCpf = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblEndRua = new javax.swing.JLabel();
        txtEndRua = new javax.swing.JTextField();
        lblEndNumero = new javax.swing.JLabel();
        txtEndNumero = new javax.swing.JTextField();
        txtEndCidade = new javax.swing.JTextField();
        lblEndCidade = new javax.swing.JLabel();
        lblEndEstado = new javax.swing.JLabel();
        txtEndEstado = new javax.swing.JTextField();
        txtEndCep = new javax.swing.JTextField();
        lblEndCep = new javax.swing.JLabel();

        setTitle("Cadastro de Clientes");
        btnSalvar.setText("Cadastrar");
        lblTitulo.setText("Cadastro de Cliente");
        getRootPane().setDefaultButton(btnSalvar);

        //Se cliente NÃO for vazia, INICIE A EDIÇÃO
        if(this.cliente != null){
            txtNome.setText(cliente.getNome());
            txtCpf.setText(cliente.getCpf());
            txtEmail.setText(cliente.getEmail());
            txtTelefone.setText(cliente.getTelefone());
            txtEndRua.setText(cliente.getEndereco().getRua());
            txtEndNumero.setText(cliente.getEndereco().getNumero());
            txtEndCidade.setText(cliente.getEndereco().getCidade());
            txtEndEstado.setText(cliente.getEndereco().getEstado());
            txtEndCep.setText(cliente.getEndereco().getCep());
            setTitle("Editar Cadastro do Cliente");
            btnSalvar.setText("Atualizar");
            lblTitulo.setText("Edição do Cadastro do Cliente");
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(600, 260));
        setSize(new java.awt.Dimension(0, 0));

        lblTitulo.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        lblNome.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNome.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNome.setToolTipText("");

        btnSalvar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtCpf.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtCpf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCpf.setToolTipText("");

        lblCpf.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblCpf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCpf.setText("CPF:");

        lblEmail.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEmail.setToolTipText("");

        lblTelefone.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelefone.setText("Telefone:");

        txtTelefone.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtTelefone.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTelefone.setToolTipText("");

        lblEndRua.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblEndRua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEndRua.setText("Rua:");

        txtEndRua.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtEndRua.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEndRua.setToolTipText("");

        lblEndNumero.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblEndNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEndNumero.setText("Número:");

        txtEndNumero.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtEndNumero.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEndNumero.setToolTipText("");

        txtEndCidade.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtEndCidade.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEndCidade.setToolTipText("");

        lblEndCidade.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblEndCidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEndCidade.setText("Cidade:");

        lblEndEstado.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblEndEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEndEstado.setText("Estado:");

        txtEndEstado.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtEndEstado.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEndEstado.setToolTipText("");

        txtEndCep.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtEndCep.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEndCep.setToolTipText("");

        lblEndCep.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblEndCep.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEndCep.setText("CEP:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(7, 7, 7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                            .addComponent(txtEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEndCidade)
                            .addComponent(lblEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtEndRua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEndNumero))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEndCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEndEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEndCep)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEndNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(txtEndCep))))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCpf)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefone)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEndRua)
                            .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndNumero)
                            .addComponent(txtEndNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndCep)
                            .addComponent(lblEndEstado)
                            .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndCidade)))
                    .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }

    //EVENTO do Botão SALVAR Cadastro de Cliente
    private void btnSalvarActionPerformed(ActionEvent evt) { 

        Endereco endereco = new Endereco(txtEndRua.getText(), txtEndNumero.getText(), txtEndCidade.getText(), txtEndEstado.getText(), txtEndCep.getText());
        Cliente cliente = new Cliente(txtNome.getText(), txtCpf.getText(), txtEmail.getText(), txtTelefone.getText(), endereco);
        String msg = "";

        if(cliente.getNome().equals("")){
            msg = "Preencher NOME";
            txtNome.requestFocusInWindow();
        }else if(cliente.getCpf().equals("")){
            msg = "Preencher CPF";
            txtCpf.requestFocusInWindow();
        }else if(cliente.getEmail().equals("")){
            msg = "Preencher EMAIL";
            txtEmail.requestFocusInWindow();
        }else if(cliente.getTelefone().equals("")){
            msg = "Preencher TELEFONE";
            txtTelefone.requestFocusInWindow();
        }else if(endereco.getRua().equals("")){
            msg = "Preencher RUA";
            txtEndRua.requestFocusInWindow();
        }else if(endereco.getNumero().equals("")){
            msg = "Preencher NÚMERO";
            txtEndNumero.requestFocusInWindow();
        }else if(endereco.getCidade().equals("")){
            msg = "Preencher CIDADE";
            txtEndCidade.requestFocusInWindow();
        }else if(endereco.getEstado().equals("")){
            msg = "Preencher ESTADO";
            txtEndEstado.requestFocusInWindow();
        }else if(endereco.getCep().equals("")){
            msg = "Preencher CEP";
            txtEndCep.requestFocusInWindow();
        }else{
            if(this.cliente == null){
                repository.addClientes(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            }else{
                repository.updateCliente(id, cliente);
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
            }
    
            view.dispose();
    
            new ViewClientesForm(repository).setVisible(true);
    
            this.dispose();
        }
        
        if(!msg.equals("")){
            JOptionPane.showMessageDialog(null, msg, "Campo Vazio", JOptionPane.ERROR_MESSAGE);
        } 
    } 
}