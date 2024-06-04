package GUI;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import mock.MockDados;
import model.MovimentoEstoque;

public class EstoqueForm extends JDialog {
    private javax.swing.JButton btnNovaEntrada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblEstoque;

    private MockDados repository;
    private ViewLivrosPanel view;
    private int codigo;

    public EstoqueForm(MockDados repository, ViewLivrosPanel view, int codigo){
        this.repository = repository;
        this.view = view;
        this.codigo = codigo;
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
    }

    protected void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstoque = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnNovaEntrada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        String[] colunas = {"Código Livro", "Tipo Movimento", "Data Movimento", "Quantidade"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Isso torna todas as células não editáveis
            }
        };
        
        tblEstoque = new javax.swing.JTable(model);

        for (MovimentoEstoque est : repository.getMovimentacoesPorCodigo(codigo)) {

            Object[] row = new Object[4];
            row[0] = est.getCodigoLivro();
            row[1] = est.getTipo();
            row[2] = est.getDataMovimento();
            row[3] = est.getQuantidade();

            model.addRow(row);
        }

        jScrollPane1.setViewportView(tblEstoque);

        lblTitulo.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Livro: " + repository.getLivroPorCodigo(codigo).getTitulo());

        btnNovaEntrada.setText("Nova Entrada");
        btnNovaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovaEntrada)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovaEntrada)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnNovaEntradaActionPerformed(java.awt.event.ActionEvent evt) {                                               
        new EstoqueFormAdd(repository, view, codigo, this).setVisible(true);
    }
}
