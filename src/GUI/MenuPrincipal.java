package GUI;

import javax.swing.JFrame;

import mock.MockDados;

public class MenuPrincipal extends JFrame {

    private javax.swing.JMenuBar barMenu;
    private javax.swing.JButton btnClose;
    private javax.swing.JMenu mnClientes;
    private javax.swing.JMenuItem mnClientesItVerClientes;
    private javax.swing.JMenu mnLivros;
    private javax.swing.JMenuItem mnLivrosItVerLivros;
    private javax.swing.JMenu mnVendas;
    private javax.swing.JMenuItem mnVendasItVerVendas;
    private javax.swing.JTabbedPane tblPanel;

    private MockDados repository;

    public MenuPrincipal(MockDados repository){
        this.repository = repository;
        this.initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        tblPanel = new javax.swing.JTabbedPane();
        btnClose = new javax.swing.JButton();
        barMenu = new javax.swing.JMenuBar();
        mnClientes = new javax.swing.JMenu();
        mnClientesItVerClientes = new javax.swing.JMenuItem();
        mnLivros = new javax.swing.JMenu();
        mnLivrosItVerLivros = new javax.swing.JMenuItem();
        mnVendas = new javax.swing.JMenu();
        mnVendasItVerVendas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPanel.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tblPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tblPanelComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tblPanelComponentRemoved(evt);
            }
        });
        tblPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPanelMouseClicked(evt);
            }
        });

        btnClose.setText("Fechar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        btnClose.setVisible(false);

        mnClientes.setText("Clientes");

        mnClientesItVerClientes.setText("Listar Clientes");
        mnClientesItVerClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnClientesItVerClientesActionPerformed(evt);
            }
        });
        mnClientes.add(mnClientesItVerClientes);

        mnLivros.setText("Livros");

        mnLivrosItVerLivros.setText("Listar Livros");
        mnLivrosItVerLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLivrosItVerLivrosActionPerformed(evt);
            }
        });
        mnLivros.add(mnLivrosItVerLivros);

        mnVendas.setText("Vendas");

        mnVendasItVerVendas.setText("Listar Vendas");
        mnVendasItVerVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnVendasItVerVendasActionPerformed(evt);
            }
        });
        mnVendas.add(mnVendasItVerVendas);

        barMenu.add(mnClientes);
        barMenu.add(mnLivros);
        barMenu.add(mnVendas);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tblPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap())
        );

        pack();
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int indexPanel = tblPanel.getSelectedIndex();
        tblPanel.remove(indexPanel);
    }                                      

    private void mnClientesItVerClientesActionPerformed(java.awt.event.ActionEvent evt) {                                           
        tblPanel.addTab("Clientes", new ViewClientesPanel(repository));
        String txt = tblPanel.getTitleAt(tblPanel.getSelectedIndex());
        btnClose.setText("Fechar Guia: " + txt);
    }

    private void mnLivrosItVerLivrosActionPerformed(java.awt.event.ActionEvent evt) {                                           
        tblPanel.addTab("Livros", new ViewLivrosPanel(repository));
        String txt = tblPanel.getTitleAt(tblPanel.getSelectedIndex());
        btnClose.setText("Fechar Guia: " + txt);
    }

    private void mnVendasItVerVendasActionPerformed(java.awt.event.ActionEvent evt) {                                           
        tblPanel.addTab("Vendas", new ViewVendasPanel(repository));
        String txt = tblPanel.getTitleAt(tblPanel.getSelectedIndex());
        btnClose.setText("Fechar Guia: " + txt);
    }

    

    private void mostrarExconderBtnClose(){
        if(tblPanel.getComponentCount() > 0){
            btnClose.setVisible(true);
        }else{
            btnClose.setVisible(false);
        }
    }
    
    private void tblPanelComponentAdded(java.awt.event.ContainerEvent evt) {                                        
        mostrarExconderBtnClose();
    }

    private void tblPanelComponentRemoved(java.awt.event.ContainerEvent evt) {                                          
        mostrarExconderBtnClose();
    }

    private void tblPanelMouseClicked(java.awt.event.MouseEvent evt) {
        if(tblPanel.getSelectedIndex() != -1){
            String txt = tblPanel.getTitleAt(tblPanel.getSelectedIndex());
            btnClose.setText("Fechar Guia: " + txt);
        }                                     
    }
}
