package GUI;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import mock.MockDados;
import model.Cliente;

public class ViewClientesPanel extends JPanel {

    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnNovoCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;

    private MockDados repository;

    public ViewClientesPanel(MockDados repository){
        this.repository = repository;
        initComponents();
    }

    protected void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnNovoCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();

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

        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirCliente)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoCliente)
                    .addComponent(btnExcluirCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );
    }

    //EVENTO do Botão NOVO CLIENTE para abrir o Frame de CADASTRO de Cliente
    private void btnNovoClienteActionPerformed(ActionEvent evt){
        new CadastroClientesForm(repository, this).setVisible(true);;
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
            
            this.removeAll();
            this.initComponents();
            
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
