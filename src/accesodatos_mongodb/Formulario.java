package accesodatos_mongodb;

import accesodatos_mongodb.classe_criminale.CRUD;
import accesodatos_mongodb.classe_criminale.Destino;
import accesodatos_mongodb.classe_criminale.Excel;
import accesodatos_mongodb.classe_criminale.Insercion;
import accesodatos_mongodb.classe_criminale.MongoUtils;
import accesodatos_mongodb.classe_criminale.PDF;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author hector
 */
public class Formulario extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private final ArrayList<JButton> buttons;
    private static ArrayList<JTextField> textfields;
    private Destino destinoXinsertar;
    private static ArrayList<Object> listaLugaresXid;
    private ImageIcon image;
    private Document lugaresDoc;
    private Document ImagenesDoc;
    private final String[] datosClickJTable;
    public int numerodedocumentos;
    private final String col[]
            = {"ID", "PAIS", "CIUDAD", "LUGAR", "IMAGEN"};

    public Formulario() {
        initComponents();
         //Insercion.insertar();

        /**
         * IMPORTANTE ( LINEA 42) Insercion.insertar() 
         * Crea la base de datos, la colección y los documentos. 
         * Si es la primera vez que inicias el programa, ésta línea debe
         * estar descomentada, para llenar la colección destinos.
         * Las siguientes veces que reanudes el programa no se podrán 
         * insertar documentos puesto que ocurriría un error al generar 
         * las claves primarias (recordamos que el campol _id debe ser
         * único para cada destino).
         */
        //INICIALIZACIÓN DEL FORMULARIO: 
        //Cabeceras de la JTable;
        datosClickJTable = new String[5];
        txtupdateIDLUG.setEnabled(false);
        txtnewID.setEnabled(false);  //El ID va a ser generado automáticamente;

        txtdeleteLUGAR.setEnabled(false);   //En el borrado me aseguro que se introduce una ciudad que se encuentra en mi colección;
        imgLabel.setText("");

        //Lista de botones (ENABLED) : : ON/OFF;
        buttons = new ArrayList<>();
        buttons.add(this.btnLimpiar);
        buttons.add(this.btnExcel);
        buttons.add(this.btnPDF);
        buttons.add(this.btnInsert);
        buttons.add(this.btnDelete);
        buttons.add(this.btnUpdate);

        //Lista de textfields (ENABLED) : : ON/OFF;
        textfields = new ArrayList<>();
        textfields.add(this.txtnewPAIS);
        textfields.add(this.txtnewCIUDAD);
        textfields.add(this.txtnewLUGARES);
        textfields.add(this.txtupdatePAIS);
        textfields.add(this.txtupdateCIUDAD);
        textfields.add(this.txtupdateLUGARES);

        //Lista de TextFields (LIMIA DATOS RESIDUO)
        MongoUtils.limpiaTextFields(textfields, true);
        MongoUtils.enabledButtons(buttons, false);
        MongoUtils.enabledJTextFields(textfields, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        imgLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtnewID = new javax.swing.JTextField();
        txtnewPAIS = new javax.swing.JTextField();
        txtnewCIUDAD = new javax.swing.JTextField();
        txtnewLUGARES = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        txtdeleteLUGAR = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtupdateIDLUG = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtupdatePAIS = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtupdateCIUDAD = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtupdateLUGARES = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(92, 74, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(816, 605));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        btnMostrar.setBackground(new java.awt.Color(39, 128, 112));
        btnMostrar.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnMostrar.setText("MOSTRAR DESTINOS");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(39, 128, 112));
        btnLimpiar.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR DESTINOS");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnExcel.setBackground(new java.awt.Color(39, 128, 112));
        btnExcel.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnExcel.setText("EXPORTAR A EXCEL");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        btnPDF.setBackground(new java.awt.Color(39, 128, 112));
        btnPDF.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        btnPDF.setText("EXPORTAR A PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tDatos);

        btnSalir.setBackground(new java.awt.Color(174, 7, 24));
        btnSalir.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/default.png"))); // NOI18N
        imgLabel.setText("jLabel2");
        imgLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("{ MONGO : TOURS }");

        jLabel7.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("NUEVO DESTINO");

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PAIS");

        jLabel9.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CIUDAD");

        jLabel10.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("LUGARES");

        jLabel11.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BORRAR DESTINO");

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("LUGAR");

        btnInsert.setBackground(new java.awt.Color(39, 128, 112));
        btnInsert.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/insert.png"))); // NOI18N
        btnInsert.setText("INSERTAR");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(39, 128, 112));
        btnDelete.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bin.png"))); // NOI18N
        btnDelete.setText("ELIMINAR");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ACTUALIZAR DESTINO");

        jLabel14.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ID");

        jLabel15.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("PAIS");

        jLabel16.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("CIUDAD");

        jLabel17.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("LUGARES");

        btnUpdate.setBackground(new java.awt.Color(39, 128, 112));
        btnUpdate.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btnUpdate.setText("ACTUALIZAR");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Para introducir varios lugares");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(" introdúcelos separados por comas (,)");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnPDF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMostrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(16, 16, 16)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel1)))
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtnewLUGARES)
                                    .addComponent(txtnewCIUDAD, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtnewPAIS)
                                    .addComponent(txtnewID, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4)))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdeleteLUGAR)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtupdateIDLUG)
                            .addComponent(txtupdatePAIS)
                            .addComponent(txtupdateCIUDAD)
                            .addComponent(txtupdateLUGARES, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSalir))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtupdateIDLUG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtnewID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(txtdeleteLUGAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtnewPAIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtupdatePAIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtupdateCIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtnewCIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtnewLUGARES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtupdateLUGARES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        System.out.println("** DIBUJANDO JTable **");

        modelo = new DefaultTableModel(col, 0);
        this.tDatos.setModel(modelo);

        //Inicialización de botones y textfields;
        MongoUtils.enabledButtons(buttons, true);
        MongoUtils.enabledJTextFields(textfields, true);

        //Genero la consulta y selecciono todos los documentos;
        CRUD crud = new CRUD();
        Collection<Document> listadetodoslosdocumentos = crud.selectXall();

        //Pongo en el ID_INSERTAR_ TEXTBOX el último ID insertado +1;
        txtnewID.setText(MongoUtils.nextID(crud.ultimo_ID_Insertado()));

        //Inserta documento en  JTable mediante un foreach;
        listadetodoslosdocumentos.forEach((Document item) -> {
            Document filas = (Document) item.get("Lugares");
            for (int i = 0; i < filas.size(); i++) {
                lugaresDoc = (Document) item.get("Lugares");
                ImagenesDoc = (Document) item.get("Imagen");
                Object[] objects
                        = {item.get("_id"), item.get("Pais"), item.get("Ciudad"), lugaresDoc.get("lug" + i), ImagenesDoc.get("img" + i)};

                //Añado el elemento a la JTable, No se muestran los lugares vacíos;
                if (!(lugaresDoc.get("lug" + i).toString()).equals("")) {
                    modelo.addRow(objects);
                }
            }
        });
        btnMostrar.setEnabled(false);
        btnLimpiar.setEnabled(true);
        System.out.println("** ELEMENTO JTable COMPLETADO**");

    }//GEN-LAST:event_btnMostrarActionPerformed
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // SALIR DEL FORMULARIO
        System.out.println("** THANK U; SEE YOU SOON **");
        int reply
                = JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro de que quieres salir de la aplicación?",
                        "SALIR",
                        JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.exit(-9);
        }
    }//GEN-LAST:event_btnSalirActionPerformed
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // LIMPIAR LOS DATOS DE LA TABLA
        System.out.println("** LIMPIANDO FILAS JTable **");
        btnMostrar.setEnabled(true);
        MongoUtils.limpiaTextFields(textfields, true);
        MongoUtils.enabledJTextFields(textfields, false);
        MongoUtils.enabledButtons(buttons, false);
        txtnewID.setText("");
        txtdeleteLUGAR.setText("");
        txtupdateIDLUG.setText("");
        image
                = new ImageIcon(getClass().getResource("../img/default.png"));
        imgLabel.setIcon(image);

        MongoUtils.clearJTable(modelo);

        System.out.println("** JTable VACÍO **");
    }//GEN-LAST:event_btnLimpiarActionPerformed
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //ELIMINAR DOCUMENTO;
        System.out.println("** ELIMINANDO DOCUMENTO **");

        //Reset de campos UPDATE;
        txtupdateIDLUG.setText("");
        txtupdatePAIS.setText("");
        txtupdateCIUDAD.setText("");
        txtupdateLUGARES.setText("");

        //Comienzo validaciones:
        //Campo vacío o numérico;
        if (txtdeleteLUGAR.getText().trim().length() == 0 || MongoUtils.isNumeric(txtdeleteLUGAR.getText().trim())) {
            JOptionPane.showMessageDialog(this,
                    "El campo no puede quedar vacío," +
                    "\nselecciona un elemento en la tabla" +
                    "\nNo se ha eliminado ningún registro",
                    "DESTINOS TURÍSTICOS - Error de borrado",
                    JOptionPane.ERROR_MESSAGE);
            txtdeleteLUGAR.requestFocus();
            System.out.println("No se ha podido eliminar el registro");
            return;
        } else {

            if (new CRUD().delete(destinoXinsertar, listaLugaresXid)) {
                JOptionPane.showMessageDialog(rootPane,
                        "Se han borrado el primer destino encontrado." +
                        "\nDestino: " + txtdeleteLUGAR.getText().trim() +
                        "\nPara ver los cambios pulsa el botón de actualizar",
                        "DESTINOS TURÍSTICOS - Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Registro borrado");
                image
                        = new ImageIcon(getClass().getResource("..\\img\\default.png"));
                imgLabel.setIcon(image);

            } else {
                JOptionPane.showMessageDialog(this,
                        "Ha ocurrido un error al intentar borrar el destino: " + txtdeleteLUGAR.getText() +
                        "\nPosibles causas:" +
                        "\n - La ciudad: " + txtdeleteLUGAR.getText() + " no se encuentra entre nuestros destinos." +
                        "\n\nPossible solución:" +
                        "\n - Pulsa 'Mostrar destinos' para confirmar la ciudad a eliminar." +
                        "\n - Si persiste el error contacta con el administrador.",
                        "DESTINOS TURÍSTICOS - Error",
                        JOptionPane.ERROR_MESSAGE);
                txtdeleteLUGAR.requestFocus();
                System.out.println("No se ha podido eliminar el registro");
            }
        }

        txtdeleteLUGAR.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void tDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDatosMouseClicked
        // ENTRANDO EN LA JTABLE
        System.out.println("** SELECCIONANDO FILA JTABLE **");
        int index = tDatos.getSelectedRow();

        //Guardo datos en nuevo objeto DESTINO cada vez que hago click en 
        destinoXinsertar = new Destino();
        destinoXinsertar.setId(modelo.getValueAt(index, 0).toString());
        destinoXinsertar.setPais(modelo.getValueAt(index, 1).toString());
        destinoXinsertar.setCiudad(modelo.getValueAt(index, 2).toString());
        destinoXinsertar.setLugares(modelo.getValueAt(index, 3).toString());
        destinoXinsertar.setRuta_imagen(modelo.getValueAt(index, 4).toString());
        destinoXinsertar.setAux(modelo.getValueAt(index, 3).toString());

        //Recoje los LUGARES que tiene la fila que seleccione en la tabla;
        listaLugaresXid
                = new CRUD().dameLosLugaresQueTieneTuID(destinoXinsertar);

        //Poner datos en los TEXTBOX_UPDATE;
        txtupdateIDLUG.setText(destinoXinsertar.getId());
        txtupdatePAIS.setText(destinoXinsertar.getPais());
        txtupdateCIUDAD.setText(destinoXinsertar.getCiudad());
        txtupdateLUGARES.setText(destinoXinsertar.getLugares());

        image
                = new ImageIcon(getClass().getResource(destinoXinsertar.getRuta_imagen()));
        imgLabel.setIcon(image);

        //Completa el campo BORRAR con el click de la JTable
        txtdeleteLUGAR.setText(destinoXinsertar.getLugares());

        System.out.println(
                "*** DATOS DE LA FILA SELECCIONADA ***" +
                "\nID: " + destinoXinsertar.getId() +
                "\nPAIS: " + destinoXinsertar.getPais() +
                " \nCIUDAD: " + destinoXinsertar.getCiudad() +
                "\nLUGARES: " + listaLugaresXid.get(0) +
                " \nIMAGEN: " + destinoXinsertar.getRuta_imagen() +
                "\n*****************************************");
    }//GEN-LAST:event_tDatosMouseClicked
    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        //EXPORTAR A EXCELL;
        System.out.println("EXPORTANDO A EXCEL");

        //Genero la consulta y selecciono todos los documentos;
        CRUD crud = new CRUD();
        Collection<Document> listadetodoslosdocumentos = crud.selectXall();
        JFileChooser saver = new JFileChooser();

        int returnVal = saver.showSaveDialog(this);
        File file = saver.getSelectedFile();

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            if (Excel.newExcelBook(file, listadetodoslosdocumentos)) {
                JOptionPane.showMessageDialog(
                        this,
                        "Se ha guardado el documento excel ",
                        "DESTINOS TURÍSTICOS - Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Documento XLS creado y datos exportados;");
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "No se ha podido generar el documento exxcel",
                        "DESTINOS TURÍSTICOS - Mensaje de error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnExcelActionPerformed
    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        // EXPORTAR A PDF
        System.out.println("** EXPORTANDO DOCUMENTO PDF **");
        JFileChooser saver = new JFileChooser();

        int returnVal = saver.showSaveDialog(this);
        File file = saver.getSelectedFile();

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            if (PDF.newPDFDoc(file, new CRUD().selectXall())) {
                JOptionPane.showMessageDialog(
                        this,
                        "Se ha guardado el documento pdf ",
                        "DESTINOS TURÍSTICOS - Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Documento PDF creado y datos exportados;");
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "No se ha podido generar el documento pdf",
                        "DESTINOS TURÍSTICOS - Mensaje de error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnPDFActionPerformed
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // INSERTAR NUEVOS DESTINOS
        System.out.println("** INSERTANDO DESTINOS **");
        CRUD crud = new CRUD();
        destinoXinsertar = new Destino();

        //Creo un nuevo objeto ciudad con los datos de los textFields;
        destinoXinsertar.setId(txtnewID.getText().trim());
        destinoXinsertar.setPais(txtnewPAIS.getText().trim());
        destinoXinsertar.setCiudad(txtnewCIUDAD.getText().trim());
        destinoXinsertar.setLugares(txtnewLUGARES.getText().trim());
        //destino.setRuta_imagen(pathString);
        //sinCity.setRuta_imagen(txt_newIMG.getText().trim());

        //VALIDACIÓN DEL FORMULARIO (CAMPOS NO VACÍOS)
        if (MongoUtils.camposVacios(destinoXinsertar)) {
            JOptionPane.showMessageDialog(rootPane,
                    "No ha sido posible insertar el registro." +
                    "\n Se han encontrado campos vacíos",
                    "DESTINOS TURÍSTICOS - Mensaje de error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        //VALIDACIÓN DEL FORMULARIO (CAMPOS NO NUMÉRICOS);
        if (MongoUtils.primerCaracterNumerico(destinoXinsertar.getId().substring(0, 1)) ||
                MongoUtils.isNumeric(destinoXinsertar.getPais()) ||
                MongoUtils.isNumeric(destinoXinsertar.getCiudad()) ||
                MongoUtils.isNumeric(destinoXinsertar.getLugares())) {
            if (MongoUtils.primerCaracterNumerico(destinoXinsertar.getId().substring(0, 1))) {
                System.out.println("ID no comienza por letra");
                txtnewID.setText("");
                txtnewID.requestFocus();
            }
            if (MongoUtils.isNumeric(destinoXinsertar.getPais())) {
                System.out.println("Pais con datos numéricos");
                txtnewPAIS.setText("");
                txtnewPAIS.requestFocus();
            }
            if (MongoUtils.isNumeric(destinoXinsertar.getCiudad())) {
                System.out.println("Ciudad con datos numéricos");
                txtnewCIUDAD.setText("");
                txtnewCIUDAD.requestFocus();
            }
            if (MongoUtils.isNumeric(destinoXinsertar.getLugares())) {
                System.out.println("Lugar con datos numéricos");
                txtnewLUGARES.setText("");
                txtnewLUGARES.requestFocus();
            }
            JOptionPane.showMessageDialog(rootPane,
                    "No ha sido posible insertar el registro." +
                    "\n\nPosibles causas:" +
                    "\n - El _ID no puede comenzar por un número" +
                    "\n - Ninguno de los campos excepto la foto pueden quedar vacíos." +
                    "\n - Se ha encontrado un valor numérico en alguno de los campos." +
                    "\n\nPosible solución:" +
                    "\n - Intenta corregir los errores." +
                    "\n - Introduce un ID que comience por un carácter no numérico" +
                    "\n - Los campos PAIS, CIUDAD Y LUGAR no pueden contener caracteres numéricos." +
                    "\n - Si persiste el error contacta con el administrador.",
                    "DESTINOS TURÍSTICOS - Mensaje de error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        //INTENTO REALIZAR EL INSERT;
        boolean sc = crud.insertar(destinoXinsertar);
        if (!sc) {
            JOptionPane.showConfirmDialog(rootPane,
                    "Ha ocurrido un error grave." +
                    "\nLos datos no han podido ser insertados" +
                    "\npor motivos internos de sistema." +
                    "\nPosibles causas: " +
                    "\n - Puede que el _ID ya esté en uso." +
                    "\n\nPosible solución:" +
                    "\n - Intenta introducir un _ID distinto." +
                    "\n - Si persiste el error contacta con el administrador.",
                    "DESTINOS TURÍSTICOS - ERROR GRAVE",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane,
                    "Se ha añadido un nuevo destino en la base de datos." +
                    "\nDestino: " + destinoXinsertar.getCiudad() + "(" + destinoXinsertar.getPais() + ")" +
                    "\nPara ver los cambios pulsa el botón de actualizar",
                    "DESTINOS TURÍSTICOS - Mensaje de confirmación",
                    JOptionPane.INFORMATION_MESSAGE);

        }
        MongoUtils.limpiaTextFields(textfields, sc);


    }//GEN-LAST:event_btnInsertActionPerformed
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // ACTUALIZAR EL CONTENIDO DE LA COLECCIÓN
        txtdeleteLUGAR.setText("");
        System.out.println("** ACTUALIZANDO BASE DE DATOS **");
        destinoXinsertar = new Destino();
        boolean flaglugar = true;
        String id_lugar = "";

        destinoXinsertar.setId(txtupdateIDLUG.getText().trim());
        destinoXinsertar.setPais(txtupdatePAIS.getText().trim());
        destinoXinsertar.setCiudad(txtupdateCIUDAD.getText().trim());
        destinoXinsertar.setLugares(txtupdateLUGARES.getText().trim());
        // flaglugar = (destino.getLugares().length() != 0) ? flaglugar : false;
        id_lugar = txtupdateIDLUG.getText();
        destinoXinsertar.setAux(id_lugar);

        if (id_lugar.length() == 0) {
            System.out.println("No se ha introducido clave de destino a modificar");
            JOptionPane.showMessageDialog(this,
                    "Debes especificar un destino" +
                    "\nHaz click en un elemento de la tabla para modificarlo.",
                    "DESTINOS TURÍSTICOS - Mensaje de información",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (MongoUtils.isNumeric(destinoXinsertar.getPais()) ||
                MongoUtils.isNumeric(destinoXinsertar.getCiudad()) ||
                MongoUtils.isNumeric(destinoXinsertar.getLugares())) {

            //Pais con valores numéricos
            if (MongoUtils.isNumeric(destinoXinsertar.getPais())) {
                JOptionPane.showMessageDialog(this,
                        "El campo PAIS no puede contener valores numéricos.",
                        "DESTINOS TURÍSTICOS - Mensaje de información",
                        JOptionPane.ERROR_MESSAGE);
                txtupdatePAIS.setText("");
                txtupdatePAIS.requestFocus();
            }
            //Ciudad  con valores numéricos
            if (MongoUtils.isNumeric(destinoXinsertar.getCiudad())) {
                JOptionPane.showMessageDialog(this,
                        "El campo CIUDAD no puede contener valores numéricos.",
                        "DESTINOS TURÍSTICOS - Mensaje de información",
                        JOptionPane.ERROR_MESSAGE);
                txtupdateCIUDAD.setText("");
                txtupdateCIUDAD.requestFocus();
            }
            //Lugar con valores numéricos
            if (MongoUtils.isNumeric(destinoXinsertar.getLugares())) {
                JOptionPane.showMessageDialog(this,
                        "El campo LUGAR no puede contener valores numéricos.",
                        "DESTINOS TURÍSTICOS - Mensaje de información",
                        JOptionPane.ERROR_MESSAGE);
                txtupdateLUGARES.setText("");
                txtupdateLUGARES.requestFocus();
            }

        } else {
            //Intento el UPDATE;
            if (new CRUD().update(destinoXinsertar, listaLugaresXid)) {
                System.out.println("Registro actualizado...");
                JOptionPane.showMessageDialog(rootPane,
                        "Se ha actualizado el registro: " +
                        "\nDestino: " + destinoXinsertar.getId() +
                        "\nPara ver los cambios pulsa el botón de actualizar",
                        "DESTINOS TURÍSTICOS - Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                destinoXinsertar.setId("");
                destinoXinsertar.setPais("");
                destinoXinsertar.setCiudad("");
                destinoXinsertar.setLugares("");
                destinoXinsertar.setAux("");
                txtupdateIDLUG.setText("");
                MongoUtils.limpiaTextFields(textfields, true);
            } else {
                System.out.println("El registro no se ha podido actualizar");
                JOptionPane.showMessageDialog(this,
                        "Ha ocurrido un error al intentar actualizar el destino _ID: '" + destinoXinsertar.getId() + "'" +
                        "\nPosibles causas:" +
                        "\n - El _ID introducido no se encuentra entre los destinos." +
                        "\n - Haz click sobre uno de los elementos de la lista para" +
                        "\n   rellenar el campo ID con el destino a modificar." +
                        "\n\nPosible solución:" +
                        "\n - Pulsa 'Mostrar destinos' para verificar el _ID a eliminar." +
                        "\n - Haz click sobre alguno de los elementos de la tabla" +
                        "\n   para modificarlo." +
                        "\n - Si persiste el error contacta con el administrador.",
                        "DESTINOS TURÍSTICOS - Error en la actualización",
                        JOptionPane.ERROR_MESSAGE);
                txtupdateIDLUG.setText("");
            }
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField txtdeleteLUGAR;
    private javax.swing.JTextField txtnewCIUDAD;
    private javax.swing.JTextField txtnewID;
    private javax.swing.JTextField txtnewLUGARES;
    private javax.swing.JTextField txtnewPAIS;
    private javax.swing.JTextField txtupdateCIUDAD;
    private javax.swing.JTextField txtupdateIDLUG;
    private javax.swing.JTextField txtupdateLUGARES;
    private javax.swing.JTextField txtupdatePAIS;
    // End of variables declaration//GEN-END:variables
}
