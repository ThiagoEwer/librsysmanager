package GUI;

import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import mock.MockDados;

public class EstoqueFormAdd extends JDialog {
    
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtQuantidade;

    private EstoqueForm form;
    private ViewLivrosPanel view;
    private MockDados repository;
    private int codigoLivro;

    public EstoqueFormAdd(MockDados repository, ViewLivrosPanel view, int codigoLivro, EstoqueForm form){
        this.form = form;
        this.view = view;
        this.repository = repository;
        this.codigoLivro = codigoLivro;
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
    }

    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Estoque");

        lblQuantidade.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lblQuantidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuantidade.setText("Quantidade:");

        txtQuantidade.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtQuantidade.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtQuantidade.setToolTipText("");

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
                        .addComponent(lblQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(btnSalvar)
                    .addContainerGap(95, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 44, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(btnSalvar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(txtQuantidade.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Preencher a QUANTIDADE DE ENTRADA!", "Campo Vazio", JOptionPane.ERROR_MESSAGE);
        }
        else{

            repository.entradaEstoque(codigoLivro, new Date(), Integer.parseInt(txtQuantidade.getText()));
            JOptionPane.showMessageDialog(null, "Nova entrada cadastrada com sucesso!");

            view.removeAll();
            view.initComponents();
            
            form.dispose();;
            new EstoqueForm(repository, view, codigoLivro).setVisible(true);

            //FECHAR FORM ATUAL
            this.dispose();
        }
    }
}
