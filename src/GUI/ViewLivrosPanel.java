package GUI;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import mock.MockDados;
import model.Livro;

public class ViewLivrosPanel extends JPanel {

    private javax.swing.JButton btnExcluirLivro;
    private javax.swing.JButton btnNovoLivro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLivros;
    private javax.swing.JButton btnEstoqueEntradasSaidas;

    private MockDados repository;

    public ViewLivrosPanel(MockDados repository){
        this.repository = repository;
        initComponents();
    }

    protected void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivros = new javax.swing.JTable();
        btnNovoLivro = new javax.swing.JButton();
        btnExcluirLivro = new javax.swing.JButton();
        btnEstoqueEntradasSaidas = new javax.swing.JButton();

        String[] colunas = {"Código", "Título", "Autor", "ISBN", "Preço", "Estoque"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Isso torna todas as células não editáveis
            }
        };
        
        tblLivros = new javax.swing.JTable(model);

        for (Livro est : repository.getLivros()) {
            

            Object[] row = new Object[6];
            row[0] = est.getCodigo();
            row[1] = est.getTitulo();
            row[2] = est.getAutor();
            row[3] = est.getISBN();
            row[4] = est.getPreco();
            row[5] = repository.getEstoques(est.getCodigo());

            model.addRow(row);
        }

        tblLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLivros);

        btnNovoLivro.setText("Novo Livro");
        btnNovoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoLivroActionPerformed(evt);
            }
        });

        btnExcluirLivro.setText("Excluir Livro");
        btnExcluirLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirLivroActionPerformed(evt);
            }
        });

        btnEstoqueEntradasSaidas.setText("Estoque (Entradas e Saídas)");
        btnEstoqueEntradasSaidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstoqueEntradasSaidasActionPerformed(evt);
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
                        .addComponent(btnNovoLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEstoqueEntradasSaidas)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoLivro)
                    .addComponent(btnExcluirLivro)
                    .addComponent(btnEstoqueEntradasSaidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );
    }

    //EVENTO do Botão NOVO LIVRO para abrir o Frame de CADASTRO de Livro
    private void btnNovoLivroActionPerformed(ActionEvent evt){
        new CadastroLivrosForm(repository, this).setVisible(true);
    }

    //EVENTO do Botão EXCLUIR LIVRO
    private void btnExcluirLivroActionPerformed(java.awt.event.ActionEvent evt) {  
        if(tblLivros.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Não existem livros para excluir!", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        }else if(tblLivros.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Selecione um livro para excluir!", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        }else if(tblLivros.getSelectedRowCount() > 1){
            JOptionPane.showMessageDialog(null, "Selecione apenas UM livro para excluir", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        }else{
            int id = tblLivros.getSelectedRow();
            
            Object[] opcoes = {"Sim", "Não"};
            String mensagem = "Deseja EXCLUIR o livro " + tblLivros.getValueAt(id, 1) + " (Código: " + tblLivros.getValueAt(id, 0) + ") ?";
            String titulo = "Excluir Livro";

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
            repository.deletarLivro(id);
            
            this.removeAll();
            this.initComponents();
            
            JOptionPane.showMessageDialog(null, "Livro EXCLUÍDO com sucesso!");
        }
        }                                               
    }

    //EVENTO do CLIQUE DUPLO para EDITAR um Cadastro de Cliente
    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {
        if(evt.getClickCount() == 2 && !evt.isConsumed()){
        
            int id = tblLivros.getSelectedRow();
            Livro livro = repository.getLivros().get(tblLivros.getSelectedRow());

            new CadastroLivrosForm(repository, this, livro, id).setVisible(true);
        }                                         
    }

    private void btnEstoqueEntradasSaidasActionPerformed(java.awt.event.ActionEvent evt) {   
        if(tblLivros.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Não existem livros para visualizar estoque!", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        }else if(tblLivros.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Selecione um livro para visualizar o estoque!", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        }else if(tblLivros.getSelectedRowCount() > 1){
            JOptionPane.showMessageDialog(null, "Selecione apenas UM livro para visualizar o estoque", "Seleção inválida", JOptionPane.ERROR_MESSAGE);
        }else{ 
            int index = tblLivros.getSelectedRow();
            Object codigo = tblLivros.getValueAt(index,0);
            new EstoqueForm(repository, this, Integer.parseInt(String.valueOf(codigo))).setVisible(true); 
        }                                                  
        
    }
}

