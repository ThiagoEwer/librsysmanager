package GUI;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import mock.MockDados;
import model.Livro;
import model.Venda;

public class ViewVendasPanel extends JPanel {
    
    private javax.swing.JButton btnExcluirVenda;
    private javax.swing.JButton btnNovaVenda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendas;

    private MockDados repository;

    public ViewVendasPanel(MockDados repository){
        this.repository = repository;
        initComponents();
    }

    protected void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        btnNovaVenda = new javax.swing.JButton();
        btnExcluirVenda = new javax.swing.JButton();

        String[] colunas = {"Cliente", "Funcionário", "Data Venda", "Livros Vendidos", "Total"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Isso torna todas as células não editáveis
            }
        };
        
        tblVendas = new javax.swing.JTable(model);
        
        for (Venda vd : repository.getVendas()) {
            
            String livros = "";
            for (Livro livro : vd.getLivrosVendidos()) {
                livros = livros + " - " + livro.getTitulo();
            }

            Object[] row = new Object[5];
            row[0] = vd.getCliente().getNome();
            row[1] = vd.getFuncionario().getNome();
            row[2] = vd.getData();
            row[3] = livros;
            row[4] = vd.getValorTotal();

            model.addRow(row);
        }

        tblVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendas);

        btnNovaVenda.setText("Nova Venda");
        btnNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaVendaActionPerformed(evt);
            }
        });

        btnExcluirVenda.setText("Excluir Venda");
        btnExcluirVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirVendaActionPerformed(evt);
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
                        .addComponent(btnNovaVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaVenda)
                    .addComponent(btnExcluirVenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );
    }

    //EVENTO do Botão NOVO LIVRO para abrir o Frame de CADASTRO de Livro
    private void btnNovaVendaActionPerformed(ActionEvent evt){
        new CadastroVendasForm(repository, this).setVisible(true);
    }

    //EVENTO do Botão EXCLUIR LIVRO
    private void btnExcluirVendaActionPerformed(java.awt.event.ActionEvent evt) {  
        // if(tblVendas.getRowCount() == 0){
        //     JOptionPane.showMessageDialog(null, "Não existem livros para excluir!", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        // }else if(tblVendas.getSelectedRowCount() == 0){
        //     JOptionPane.showMessageDialog(null, "Selecione um livro para excluir!", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        // }else if(tblVendas.getSelectedRowCount() > 1){
        //     JOptionPane.showMessageDialog(null, "Selecione apenas UM livro para excluir", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        // }else{
        //     int id = tblVendas.getSelectedRow();
            
        //     Object[] opcoes = {"Sim", "Não"};
        //     String mensagem = "Deseja EXCLUIR o livro " + tblVendas.getValueAt(id, 1) + " (Código: " + tblVendas.getValueAt(id, 0) + ") ?";
        //     String titulo = "Excluir Livro";

        //     int escolha = JOptionPane.showOptionDialog(
        //         null, // componente pai, null para centralizar na tela
        //         mensagem, // mensagem a ser exibida
        //         titulo, // título da caixa de diálogo
        //         JOptionPane.DEFAULT_OPTION, // tipo de opção (botões)
        //         JOptionPane.PLAIN_MESSAGE, // tipo de mensagem
        //         null, // ícone, null para o padrão
        //         opcoes, // array de opções para os botões
        //         opcoes[1] // opção padrão
        // );

        // if (escolha == 0) {
        //     repository.deletarLivro(id);
            
        //     this.removeAll();
        //     this.initComponents();
            
        //     JOptionPane.showMessageDialog(null, "Livro EXCLUÍDO com sucesso!");
        // }
        // }                                               
    }

    //EVENTO do CLIQUE DUPLO para EDITAR um Cadastro de Cliente
    private void tblVendasMouseClicked(java.awt.event.MouseEvent evt) {
        if(evt.getClickCount() == 2 && !evt.isConsumed()){
        
            //int id = tblVendas.getSelectedRow();
            //Livro livro = repository.getLivros().get(tblVendas.getSelectedRow());

            //new CadastroLivrosForm(repository, this, livro, id).setVisible(true);
        }                                         
    }

}
