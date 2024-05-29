package GUI;

import javax.swing.JFrame;
import mock.MockDados;

public class Principal extends JFrame {

    private javax.swing.JButton btnClientes;
    private MockDados repository;
    
    //Construtor
    public Principal(MockDados repository){
        this.repository = repository;
        this.inicializar();
        setLocationRelativeTo(null);
    }

    //Método de inicialização do FRAME
    private void inicializar(){
        btnClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnClientes)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btnClientes)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pack();
    }

    //EVENTO do Botão CLIENTES para abrir o Frame de VISUALIZAÇÃO dos Clientes
    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new ViewClientesForm(repository).setVisible(true);
    }
}
