package GUI;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import mock.MockDados;
import model.Cliente;

public class ViewClientesForm extends JFrame {

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JButton btnNovoCliente;
    private javax.swing.JButton btnExcluirCliente;
    private MockDados repository;

    //Construtor
    public ViewClientesForm(MockDados repository){
        this.repository = repository;
        this.inicializar();
        setLocationRelativeTo(null);
    }

    //Método de inicialização do FRAME
    private void inicializar(){

        btnNovoCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        String[] colunas = {"Nome", "CPF", "Telefone", "Email"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Isso torna todas as células não editáveis
            }
        };
        
        tblClientes = new javax.swing.JTable(model);

        for (Cliente cl : repository.getClientes()) {
            Object[] row = new Object[4];
            row[0] = cl.getNome();
            row[1] = cl.getCpf();
            row[2] = cl.getTelefone();
            row[3] = cl.getEmail();

            model.addRow(row);
        }

        
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(tblClientes);

        btnNovoCliente.setText("Novo Cliente");
        btnNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoClienteActionPerformed(evt);
            }
        });

        btnExcluirCliente.setText("Excluir Cliente");
        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteActionPerformed(evt);
            }
        });

        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoCliente)
                    .addComponent(btnExcluirCliente))
                .addGap(46, 46, 46))
        );

        pack();
    }

    //EVENTO do Botão NOVO CLIENTE para abrir o Frame de CADASTRO de Cliente
    private void btnNovoClienteActionPerformed(ActionEvent evt){
        new CadastroClientesForm(repository, this).setVisible(true); 
    }

    //EVENTO do Botão EXCLUIR CLIENTE
    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {  
        if(tblClientes.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Não existem clientes para excluir!", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        }else if(tblClientes.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir!", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        }else if(tblClientes.getSelectedRowCount() > 1){
            JOptionPane.showMessageDialog(null, "Selecione apenas UM cliente para excluir", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        }else{
            int id = tblClientes.getSelectedRow();
            
            Object[] opcoes = {"Sim", "Não"};
            String mensagem = "Deseja EXCLUIR o cliente " + tblClientes.getValueAt(id, 0) + "?";
            String titulo = "Excluir Cliente";

            int escolha = JOptionPane.showOptionDialog(
                null, // componente pai, null para centralizar na tela
                mensagem, // mensagem a ser exibida
                titulo, // título da caixa de diálogo
                JOptionPane.DEFAULT_OPTION, // tipo de opção (botões)
                JOptionPane.PLAIN_MESSAGE, // tipo de mensagem
                null, // ícone, null para o padrão
                opcoes, // array de opções para os botões
                opcoes[1] // opção padrão
        );

        if (escolha == 0) {
            repository.deletarCliente(id);
            this.dispose();
            new ViewClientesForm(repository).setVisible(true);
            JOptionPane.showMessageDialog(null, "Cliente EXCLUÍDO com sucesso!");
        }
        }                                               
    }

    //EVENTO do CLIQUE DUPLO para EDITAR um Cadastro de Cliente
    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {
        if(evt.getClickCount() == 2 && !evt.isConsumed()){
        
            int id = tblClientes.getSelectedRow();
            Cliente cliente = repository.getClientes().get(tblClientes.getSelectedRow());

            new CadastroClientesForm(repository, this, cliente, id).setVisible(true);
        }                                         
    }

}
