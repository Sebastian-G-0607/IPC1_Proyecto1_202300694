package interfaces;

//Se importan las bibliotecas de objeto investigador y para escribir los investigadores en el arraylist
import clases.Actualizar_Tabla;
import clases.Escribir_investigador;
import clases.Investigador;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import clases.RenderTabla;
import clases.Cargar_csv;
import clases.Escribir_InvestigadorBinario;
import clases.Escribir_muestra;
import clases.Escribir_muestraBinaria;
import clases.Escribir_patron;
import clases.Muestra;
import clases.Patron;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.sqrt;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author sebas
 */
public class Administrador extends javax.swing.JFrame {

    //Se crea un dtm estático para agregar y actualizar datos de la tabla
    public static DefaultTableModel dtm1 = new DefaultTableModel(); //default table model para investigadores
    public static DefaultTableModel dtm_muestras; //default table model para muestras
    public static DefaultTableModel dtm_patrones; //default table model para patrones
    private JButton cerrarsesion;

    //Creación del botón VER de la tabla de muestras
    public static JButton ver = new JButton("VER");
    
    //Se crean dos enteros para almacenar la fila y columna de la tabla de muestras que seleccioné el usuario
    public static int fila,columna;

    //Creación del constructor Administrador
    public Administrador() {

        initComponents();
        
//        cerrarsesion = new JButton("Cerrar Sesión");
//        cerrarsesion.setBounds(200, 200, 100, 30);
//        add(cerrarsesion);
//        cerrarsesion.addActionListener(this);

        
        //Se da nombre al boton de la tabla de muestras para identificarlos en el evento
        ver.setName("botonVer");
        
        setSize(800, 500);
        setTitle("Módulo de Administrador");
        setResizable(false);
        setLocationRelativeTo(null);

        //Encabezados de las columnas de la tabla Investigadores
        String id[] = {"Código", "Nombre", "Genero", "Experimentos"};
        dtm1.setColumnIdentifiers(id); //Se agrega el vector id al encabezado de la tabla como títulos
        tabla_investigadores.setModel(dtm1); //Se asigna el dtm1 a la tabla_investigadores

        //Se crean la tablas que contienen investigadores, las muestras y la tabla que contiene los patrones
        tabla_investigadores();
        tabla_muestras();
        tabla_patrones();
        

        //Se lee el arraylist y se agregan los elementos al JTable y JComboBox, si no hay elementos no se realiza ninguna acción
        if (Escribir_investigador.investigadores != null || Escribir_investigador.investigadores.size() != 0) {
            for (Investigador investigador_temp : Escribir_investigador.investigadores) {
                dtm1.addRow(new Object[]{investigador_temp.getCodigo(), investigador_temp.getNombre(), investigador_temp.getGenero(), investigador_temp.getNumExperimentos()}); //Se agrega el elemento a la tabla de Investigadores
                combo_investigador.addItem(investigador_temp.getNombre()); //Se agrega el elemento al JComboBox que está en la pestaña de Asignar Muestra
            }
        }
        
        //Se lee el ArrayList de muestras y se agregan los elementos al JTable  y JCoboBox correspondiente, si no hay elementos no se realiza ninguna acción
        if (Escribir_muestra.muestras != null || Escribir_muestra.muestras.size() != 0) {
            for (Muestra muestra_temp : Escribir_muestra.muestras) {
                dtm_muestras.addRow(new Object[]{muestra_temp.getCodigo(), muestra_temp.getDescripcion(), muestra_temp.getEstado(), ver}); //Se agrega el elemento a la tabla de muestras
                combo_muestra.addItem(muestra_temp.getDescripcion()); //Se agrega el elemento al JComboBox que está en la pestaña de Asignar Muestra
            }
        }
        
        //Se lee el ArrayList de patrones y se agregan los elementos al JTable de patrones
        if (Escribir_patron.patrones != null || !Escribir_patron.patrones.isEmpty()) {
            for (Patron patron_temp : Escribir_patron.patrones) {
                dtm_patrones.addRow(new Object[]{patron_temp.getCodigo(), patron_temp.getNombre(), ver}); //Se agrega el elemento a la tabla de patrones
            }
        }

    }

    public void tabla_investigadores() {
        tabla_investigadores.setDefaultRenderer(Object.class, new RenderTabla());
        dtm1 = new DefaultTableModel(); //Se inicializa el dtm_muestras
        String id[] = {"Código", "Nombre", "Genero", "Experimentos"};
        dtm1.setColumnIdentifiers(id); //Se agrega el vector id al encabezado del dtm_muestras
        tabla_investigadores.setModel(dtm1); //A la tabla muestras se le asigna el modelo que se definió arriba
        tabla_investigadores.setRowHeight(20); //Se ajusta el alto de la fila
    }
    
    //Función para crear la tabla que contiene las muestras, especial porque se crea un botón en la última columna.
    public void tabla_muestras() {
        tabla_muestras.setDefaultRenderer(Object.class, new RenderTabla());
        dtm_muestras = new DefaultTableModel(); //Se inicializa el dtm_muestras
        String[] id = {"Código", "Descripción", "Estado", "Acciones"};
        dtm_muestras.setColumnIdentifiers(id); //Se agrega el vector id al encabezado del dtm_muestras
        tabla_muestras.setModel(dtm_muestras); //A la tabla muestras se le asigna el modelo que se definió arriba
        tabla_muestras.setRowHeight(30); //Se ajusta el alto de la fila
    }
    public void tabla_patrones() {
        tabla_patrones.setDefaultRenderer(Object.class, new RenderTabla());
        dtm_patrones = new DefaultTableModel(); //Se inicializa el dtm_patrones
        String[] id = {"Código", "Nombre", "Acciones"};
        dtm_patrones.setColumnIdentifiers(id); //Se agrega el vector id al encabezado del dtm_patrones
        tabla_patrones.setModel(dtm_patrones); //A la tabla muestras se le asigna el modelo que se definió arriba
        tabla_patrones.setRowHeight(30); //Se ajusta el alto de la fila
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_admin = new javax.swing.JTabbedPane();
        pestaña_investigadores = new javax.swing.JPanel();
        crear_btn = new javax.swing.JButton();
        cargar_btn = new javax.swing.JButton();
        actualizar_btn = new javax.swing.JButton();
        eliminar_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_investigadores = new javax.swing.JTable();
        cerrarS_1 = new javax.swing.JButton();
        pestaña_muestras = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_muestras = new javax.swing.JTable();
        crear_muestra_btn = new javax.swing.JButton();
        cargar_muestra_btn = new javax.swing.JButton();
        cerrarS_2 = new javax.swing.JButton();
        pestaña_asignacion = new javax.swing.JPanel();
        label_investigador = new javax.swing.JLabel();
        label_muestra = new javax.swing.JLabel();
        combo_investigador = new javax.swing.JComboBox<>();
        combo_muestra = new javax.swing.JComboBox<>();
        asignar_btn = new javax.swing.JButton();
        cerrarS_3 = new javax.swing.JButton();
        pestaña_patrones = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_patrones = new javax.swing.JTable();
        crear_patron_btn = new javax.swing.JButton();
        cargar_patron_btn = new javax.swing.JButton();
        eliminar_patron_btn = new javax.swing.JButton();
        cerrarS_4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        crear_btn.setText("CREAR");
        crear_btn.setPreferredSize(new java.awt.Dimension(72, 50));
        crear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_btnActionPerformed(evt);
            }
        });

        cargar_btn.setText("CARGAR");
        cargar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_btnActionPerformed(evt);
            }
        });

        actualizar_btn.setText("ACTUALIZAR");
        actualizar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizar_btnActionPerformed(evt);
            }
        });

        eliminar_btn.setText("ELIMINAR");
        eliminar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_btnActionPerformed(evt);
            }
        });

        tabla_investigadores = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabla_investigadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Género", "Experimentos"
            }
        ));
        jScrollPane1.setViewportView(tabla_investigadores);

        cerrarS_1.setText("Cerrar Sesión");
        cerrarS_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarS_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pestaña_investigadoresLayout = new javax.swing.GroupLayout(pestaña_investigadores);
        pestaña_investigadores.setLayout(pestaña_investigadoresLayout);
        pestaña_investigadoresLayout.setHorizontalGroup(
            pestaña_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña_investigadoresLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(pestaña_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pestaña_investigadoresLayout.createSequentialGroup()
                            .addComponent(actualizar_btn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pestaña_investigadoresLayout.createSequentialGroup()
                            .addComponent(crear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(cargar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cerrarS_1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30))
        );
        pestaña_investigadoresLayout.setVerticalGroup(
            pestaña_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña_investigadoresLayout.createSequentialGroup()
                .addGroup(pestaña_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pestaña_investigadoresLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(pestaña_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cargar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(crear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pestaña_investigadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eliminar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(actualizar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cerrarS_1))
                    .addGroup(pestaña_investigadoresLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panel_admin.addTab("Investigadores", pestaña_investigadores);

        tabla_muestras = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabla_muestras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_muestras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_muestrasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_muestras);

        crear_muestra_btn.setText("CREAR");
        crear_muestra_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_muestra_btnActionPerformed(evt);
            }
        });

        cargar_muestra_btn.setText("CARGAR");
        cargar_muestra_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_muestra_btnActionPerformed(evt);
            }
        });

        cerrarS_2.setText("Cerrar Sesión");
        cerrarS_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarS_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pestaña_muestrasLayout = new javax.swing.GroupLayout(pestaña_muestras);
        pestaña_muestras.setLayout(pestaña_muestrasLayout);
        pestaña_muestrasLayout.setHorizontalGroup(
            pestaña_muestrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña_muestrasLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pestaña_muestrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pestaña_muestrasLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(pestaña_muestrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(crear_muestra_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cargar_muestra_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addContainerGap(88, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña_muestrasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cerrarS_2)
                        .addGap(30, 30, 30))))
        );
        pestaña_muestrasLayout.setVerticalGroup(
            pestaña_muestrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña_muestrasLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pestaña_muestrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pestaña_muestrasLayout.createSequentialGroup()
                        .addComponent(crear_muestra_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cargar_muestra_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)
                        .addComponent(cerrarS_2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panel_admin.addTab("Muestras", pestaña_muestras);

        label_investigador.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_investigador.setText("Investigador:");

        label_muestra.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_muestra.setText("Muestra:");

        combo_investigador.setModel(new javax.swing.DefaultComboBoxModel<>());
        combo_investigador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_investigadorActionPerformed(evt);
            }
        });

        combo_muestra.setModel(new javax.swing.DefaultComboBoxModel<>());
        combo_muestra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_muestraActionPerformed(evt);
            }
        });

        asignar_btn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        asignar_btn.setText("ASIGNAR");
        asignar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignar_btnActionPerformed(evt);
            }
        });

        cerrarS_3.setText("Cerrar Sesión");
        cerrarS_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarS_3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pestaña_asignacionLayout = new javax.swing.GroupLayout(pestaña_asignacion);
        pestaña_asignacion.setLayout(pestaña_asignacionLayout);
        pestaña_asignacionLayout.setHorizontalGroup(
            pestaña_asignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña_asignacionLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(pestaña_asignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_investigador)
                    .addComponent(label_muestra))
                .addGap(56, 56, 56)
                .addGroup(pestaña_asignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(asignar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_muestra, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_investigador, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña_asignacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrarS_3)
                .addGap(30, 30, 30))
        );
        pestaña_asignacionLayout.setVerticalGroup(
            pestaña_asignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña_asignacionLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(pestaña_asignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_investigador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_investigador))
                .addGap(54, 54, 54)
                .addGroup(pestaña_asignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_muestra)
                    .addComponent(combo_muestra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(asignar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(cerrarS_3)
                .addGap(41, 41, 41))
        );

        panel_admin.addTab("Asignación de experimentos", pestaña_asignacion);

        tabla_patrones = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabla_patrones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_patrones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_patronesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_patrones);

        crear_patron_btn.setText("CREAR");
        crear_patron_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_patron_btnActionPerformed(evt);
            }
        });

        cargar_patron_btn.setText("CARGAR");
        cargar_patron_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_patron_btnActionPerformed(evt);
            }
        });

        eliminar_patron_btn.setText("ELIMINAR");
        eliminar_patron_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_patron_btnActionPerformed(evt);
            }
        });

        cerrarS_4.setText("Cerrar Sesión");
        cerrarS_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarS_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pestaña_patronesLayout = new javax.swing.GroupLayout(pestaña_patrones);
        pestaña_patrones.setLayout(pestaña_patronesLayout);
        pestaña_patronesLayout.setHorizontalGroup(
            pestaña_patronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña_patronesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pestaña_patronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pestaña_patronesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pestaña_patronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pestaña_patronesLayout.createSequentialGroup()
                                .addComponent(crear_patron_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cargar_patron_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(eliminar_patron_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña_patronesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cerrarS_4)
                        .addGap(30, 30, 30))))
        );
        pestaña_patronesLayout.setVerticalGroup(
            pestaña_patronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña_patronesLayout.createSequentialGroup()
                .addGroup(pestaña_patronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pestaña_patronesLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(pestaña_patronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(crear_patron_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(cargar_patron_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(eliminar_patron_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cerrarS_4))
                    .addGroup(pestaña_patronesLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panel_admin.addTab("Patrones", pestaña_patrones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_admin)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_admin, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método que captura el evento del botón crear
    private void crear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_btnActionPerformed
        new Crear_Investigador().setVisible(true);
    }//GEN-LAST:event_crear_btnActionPerformed

    //Método que captura el evento del botón actualizar
    private void actualizar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizar_btnActionPerformed
        new Actualizar_Investigador().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_actualizar_btnActionPerformed

    //Método que captura el evento del botón eliminar
    private void eliminar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_btnActionPerformed
         new Eliminar_Investigador().setVisible(true);
    }//GEN-LAST:event_eliminar_btnActionPerformed

    private void crear_muestra_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_muestra_btnActionPerformed
        new Crear_muestra().setVisible(true);
    }//GEN-LAST:event_crear_muestra_btnActionPerformed

    private void combo_investigadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_investigadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_investigadorActionPerformed

    //Método para capturar el evento del botón asignar perteneciente al apartado: Asignación de experimentos.
    private void asignar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignar_btnActionPerformed
        
        //Strings auxiliares
        String investigador;
        String muestra;
        int indexInvestigador = -1; //índice que almacenára la posición del investigador
        int indexMuestra = -1; //Índice que almacenará la posición de la muestra 

        //Si alguno de los JComboBox no fue seleccionado, se despliega un mensaje de error
        if (combo_investigador.getSelectedItem() == null || combo_muestra.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Error en la asignación", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Si ambos JComboBox contienen información, se asigna la muestra al investigador
        else {
            investigador = combo_investigador.getSelectedItem().toString(); //Se convierte a String el texto del JCombo box de investigador
            muestra = combo_muestra.getSelectedItem().toString(); //Se convierte a String el texto del JCombo box de muestras
            
            //Bucle for para encontrar el índice de la muestra
            for(int i=0; i<Escribir_muestra.muestras.size(); i++){
                if(Escribir_muestra.muestras.get(i).getDescripcion().equals(muestra)){
                    indexMuestra = i;
                }
            }
            //Bucle for para encontrar el índice de la muestra
            for(int i=0; i<Escribir_investigador.investigadores.size(); i++){
                if(Escribir_investigador.investigadores.get(i).getNombre().equals(investigador)){ 
                    indexInvestigador = i;
                }
            }
            
            if(indexInvestigador == -1 || indexMuestra == -1){ //Si alguno de los índices es -1, no se encontrarón coincidencias
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if(Escribir_muestra.muestras.get(indexMuestra).getEstado().equals("En proceso")){ // || Escribir_muestra.muestras.get(indexMuestra).getEstado().equals("Procesado")
                JOptionPane.showMessageDialog(null,"La muestra ya fue asignada a otro investigador", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{ //Si no se cumple ninguna condición anterior, se asigna la muestra al investigador
                Escribir_investigador.investigadores.get(indexInvestigador).setMuestra_asignada(Escribir_muestra.muestras.get(indexMuestra)); //Se asigna la muestra con el indexMuestra al investigador con el indexInvestigador
                Escribir_investigador.investigadores.get(indexInvestigador).setNumExperimentos(Escribir_investigador.investigadores.get(indexInvestigador).getNumExperimentos() + 1);
                Escribir_muestra.muestras.get(indexMuestra).setEstado("En proceso");
                Actualizar_Tabla.actualizar_elemento(dtm1, indexInvestigador, Escribir_investigador.investigadores);
                Escribir_InvestigadorBinario.escribir_investigadorbin();
                Escribir_muestraBinaria.escribir_muestrabin();
                Actualizar_Tabla.actualizar_muestra(dtm_muestras, indexMuestra, Escribir_muestra.muestras);
                JOptionPane.showMessageDialog(null,"Se asignó la muestra correctamente al investigador", "", JOptionPane.INFORMATION_MESSAGE); //Mensaje de asignación exitosa
            }
        }


    }//GEN-LAST:event_asignar_btnActionPerformed

    //Método que captura el evento del botón Cargar del apartado de: Investigadores
    private void cargar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_btnActionPerformed
        //Se crea un objeto de tipo Cargar_csv para utilizar los métodos para leer archivos
        Cargar_csv cargar = new Cargar_csv();
        if (cargar.cargarCSV() == 1) { //Si se cumple esta condición, el usuario ingresó sí seleccionó un archivo
            try {
                cargar.cargarAlArray(cargar.ruta); //Se utiliza el método para cargar los investigadores del csv al array y luego grabarlos en el archivo binario
            } catch (IOException ex) { //Se captura la excepción
                JOptionPane.showMessageDialog(null, ex);
            }

        }

    }//GEN-LAST:event_cargar_btnActionPerformed

    //Método que captura el evento al hacer click sobre el botón ver de la tabla de muestras
    private void tabla_muestrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_muestrasMouseClicked
        
        //Se guarda el indice de la columna sobre la que se hizo click
        columna = tabla_muestras.getColumnModel().getColumnIndexAtX(evt.getX()); 
        //Se guarda el índice de la fila sobre la que se hizo click
        fila = evt.getY()/tabla_muestras.getRowHeight(); 
        
        if(columna<=tabla_muestras.getColumnCount() && columna>=0 && fila<=tabla_muestras.getRowCount() && fila>=0){ //Condición para validar que exista al menos una columna y una fila
            
            Object obj = tabla_muestras.getValueAt(fila, columna);
            
            if(obj instanceof JButton){ //Si se presionó el botón ver, se ejecuta el siguiente bloque
                
                int index = fila; //Se guarda el índice de la fila de la que se presionó el botón
                String path = Escribir_muestra.muestras.get(index).getCodigo() + ".html"; //Se crea un string con extensión html para crear un archivo
                
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                    
                    writer.write("<!DOCTYPE html>\n");
                    writer.write("<html>\n");
                    writer.write("<head>\n");
                    writer.write("<title>" + "Muestra " + Escribir_muestra.muestras.get(index).getCodigo() + "</title>\n");
                    writer.write("</head>\n");
                    writer.write("<body>\n");
                    writer.write("<h2>Matriz perteneciente a la muestra " + Escribir_muestra.muestras.get(index).getCodigo() + "</h2>\n");
                    writer.write("<table border=\"1\">\n");

                    // Escribir filas y columnas de la matriz
                    for (int i = 0; i < Escribir_muestra.muestras.get(index).getPatron().length; i++) {
                        writer.write("<tr>\n");
                        for (int j = 0; j < Escribir_muestra.muestras.get(index).getPatron()[i].length; j++) {
                            writer.write("<td>" + Escribir_muestra.muestras.get(index).getPatron()[i][j] + "</td>\n");
                        }
                        writer.write("</tr>\n");
                    }

                    writer.write("</table>\n");
                    writer.write("</body>\n");
                    writer.write("</html>\n");
                    
                    File html = new File(path);
                    Desktop.getDesktop().open(html);

//                    System.out.println("Archivo HTML creado exitosamente en: " + path);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        }
    }//GEN-LAST:event_tabla_muestrasMouseClicked

    private void combo_muestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_muestraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_muestraActionPerformed

    private void crear_patron_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_patron_btnActionPerformed
        new Crear_patron().setVisible(true);
    }//GEN-LAST:event_crear_patron_btnActionPerformed

    private void eliminar_patron_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_patron_btnActionPerformed
        new Eliminar_patron().setVisible(true);
    }//GEN-LAST:event_eliminar_patron_btnActionPerformed

    private void cerrarS_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarS_1ActionPerformed
        UIManager.put("OptionPane.noButtonText", "No"); // texto para cancel es Cancelar
        UIManager.put("OptionPane.yesButtonText", "Sí"); // texto para ok es Aceptar
        int input = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if(input == 0){
            dispose();
            new Login().setVisible(true); 
        }
        
    }//GEN-LAST:event_cerrarS_1ActionPerformed

    private void cerrarS_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarS_2ActionPerformed
        UIManager.put("OptionPane.noButtonText", "No"); // texto para cancel es Cancelar
        UIManager.put("OptionPane.yesButtonText", "Sí"); // texto para ok es Aceptar
        int input = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if(input == 0){
            dispose();
            new Login().setVisible(true); 
        }
    }//GEN-LAST:event_cerrarS_2ActionPerformed

    private void cerrarS_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarS_3ActionPerformed
        UIManager.put("OptionPane.noButtonText", "No"); // texto para cancel es Cancelar
        UIManager.put("OptionPane.yesButtonText", "Sí"); // texto para ok es Aceptar
        int input = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if(input == 0){
            dispose();
            new Login().setVisible(true); 
        }
    }//GEN-LAST:event_cerrarS_3ActionPerformed

    private void cerrarS_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarS_4ActionPerformed
        UIManager.put("OptionPane.noButtonText", "No"); // texto para cancel es Cancelar
        UIManager.put("OptionPane.yesButtonText", "Sí"); // texto para ok es Aceptar
        int input = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if(input == 0){
            dispose();
            new Login().setVisible(true); 
        }
    }//GEN-LAST:event_cerrarS_4ActionPerformed

    private void cargar_muestra_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_muestra_btnActionPerformed
        Cargar_csv cargar = new Cargar_csv();
        if (cargar.cargarCSV() == 1) { //Si se cumple esta condición, el usuario ingresó sí seleccionó un archivo
            try {
                cargar.cargarcsvMuestra(cargar.ruta, 1); //Se utiliza el método para cargar las muestras del csv al array y luego grabarlos en el archivo binario
            } catch (IOException ex) { //Se captura la excepción
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }//GEN-LAST:event_cargar_muestra_btnActionPerformed

    private void cargar_patron_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_patron_btnActionPerformed
        Cargar_csv cargar = new Cargar_csv();
        if (cargar.cargarCSV() == 1) { //Si se cumple esta condición, el usuario ingresó sí seleccionó un archivo
            try {
                cargar.cargarcsvMuestra(cargar.ruta, 2); //Se utiliza el método para cargar las muestras del csv al array y luego grabarlos en el archivo binario
            } catch (IOException ex) { //Se captura la excepción
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }//GEN-LAST:event_cargar_patron_btnActionPerformed

    private void tabla_patronesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_patronesMouseClicked
                //Se guarda el indice de la columna sobre la que se hizo click
        columna = tabla_patrones.getColumnModel().getColumnIndexAtX(evt.getX()); 
        //Se guarda el índice de la fila sobre la que se hizo click
        fila = evt.getY()/tabla_patrones.getRowHeight(); 
        
        if(columna<=tabla_patrones.getColumnCount() && columna>=0 && fila<=tabla_patrones.getRowCount() && fila>=0){ //Condición para validar que exista al menos una columna y una fila
            
            Object obj = tabla_patrones.getValueAt(fila, columna);
            
            if(obj instanceof JButton){ //Si se presionó el botón ver, se ejecuta el siguiente bloque
                
                int index = fila; //Se guarda el índice de la fila de la que se presionó el botón
                String path = Escribir_patron.patrones.get(index).getCodigo() + ".html"; //Se crea un string con extensión html para crear un archivo
                
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                    
                    writer.write("<!DOCTYPE html>\n");
                    writer.write("<html>\n");
                    writer.write("<head>\n");
                    writer.write("<title>" + "Patron " + Escribir_patron.patrones.get(index).getCodigo() + "</title>\n");
                    writer.write("</head>\n");
                    writer.write("<body>\n");
                    writer.write("<h2>Matriz perteneciente al patrón " + Escribir_patron.patrones.get(index).getCodigo() + "</h2>\n");
                    writer.write("<table border=\"1\">\n");

                    // Escribir filas y columnas de la matriz
                    for (int i = 0; i < Escribir_patron.patrones.get(index).getPatron().length; i++) {
                        writer.write("<tr>\n");
                        for (int j = 0; j < Escribir_patron.patrones.get(index).getPatron()[i].length; j++) {
                            writer.write("<td>" + Escribir_patron.patrones.get(index).getPatron()[i][j] + "</td>\n");
                        }
                        writer.write("</tr>\n");
                    }

                    writer.write("</table>\n");
                    writer.write("</body>\n");
                    writer.write("</html>\n");
                    
                    File html = new File(path);
                    Desktop.getDesktop().open(html);

//                    System.out.println("Archivo HTML creado exitosamente en: " + path);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        }
    }//GEN-LAST:event_tabla_patronesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar_btn;
    private javax.swing.JButton asignar_btn;
    private javax.swing.JButton cargar_btn;
    private javax.swing.JButton cargar_muestra_btn;
    private javax.swing.JButton cargar_patron_btn;
    private javax.swing.JButton cerrarS_1;
    private javax.swing.JButton cerrarS_2;
    private javax.swing.JButton cerrarS_3;
    private javax.swing.JButton cerrarS_4;
    public static javax.swing.JComboBox<String> combo_investigador;
    public static javax.swing.JComboBox<String> combo_muestra;
    private javax.swing.JButton crear_btn;
    private javax.swing.JButton crear_muestra_btn;
    private javax.swing.JButton crear_patron_btn;
    private javax.swing.JButton eliminar_btn;
    private javax.swing.JButton eliminar_patron_btn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_investigador;
    private javax.swing.JLabel label_muestra;
    private javax.swing.JTabbedPane panel_admin;
    private javax.swing.JPanel pestaña_asignacion;
    private javax.swing.JPanel pestaña_investigadores;
    private javax.swing.JPanel pestaña_muestras;
    private javax.swing.JPanel pestaña_patrones;
    private javax.swing.JTable tabla_investigadores;
    private javax.swing.JTable tabla_muestras;
    private javax.swing.JTable tabla_patrones;
    // End of variables declaration//GEN-END:variables
}
