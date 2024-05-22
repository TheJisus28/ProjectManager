/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.proyectos;

import ui.HomeUI;
import data.BBDD;
import java.util.List;
import models.User;

/**
 *
 * @author JESUS DANIEL
 */
public class ProyectoMostrarTodo extends javax.swing.JFrame {

    /**
     * Creates new form ProyectoMostrarTodo
     */
    private String cedulaUsuario;
    private String idProyecto;
    public ProyectoMostrarTodo(String cedula, String IDProyecto) {
        cedulaUsuario = cedula;
        idProyecto = IDProyecto;
        initComponents();
        mostrarPersonasEnProyecto();
    }

    // ------------------------- mis metodos
    
   private void mostrarPersonasEnProyecto() {
    // Obtener los datos de todos los usuarios en el proyecto
    List<User> users = BBDD.obtenerUsuariosEnProyecto(idProyecto);
    
    // Crear un StringBuilder para construir el String
    StringBuilder sb = new StringBuilder();
    
    // Iterar sobre cada usuario y agregar sus datos al StringBuilder
    for (User user : users) {
        sb.append("Nombre: ").append(user.getNombre()).append("\n");
        sb.append("Cédula: ").append(user.getCedula()).append("\n");
        sb.append("Edad: ").append(user.getEdad()).append("\n");
        sb.append("Titulo: ").append(user.getTitulo()).append("\n");
        // Agregar cualquier otro dato que desees mostrar
        sb.append("\n"); // Agregar un salto de línea entre cada usuario
    }
    
    // Establecer el String resultante en el JTextArea
    jTextArea_motrar_personal_en_proyecto.setText(sb.toString());
}

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_de_fondo = new javax.swing.JPanel();
        panel_lateral = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_informarcion_general = new javax.swing.JPanel();
        crear_proyecto_btn_regresar = new javax.swing.JButton();
        login_lbl_usuario5 = new javax.swing.JLabel();
        mostrar_nombre_proyecto = new javax.swing.JTextField();
        mostrar_id_proyecto = new javax.swing.JTextField();
        login_lbl_usuario6 = new javax.swing.JLabel();
        login_lbl_usuario7 = new javax.swing.JLabel();
        mostrar_numero_trabajadores = new javax.swing.JTextField();
        mostrar_persona_responsable = new javax.swing.JTextField();
        login_lbl_usuario8 = new javax.swing.JLabel();
        mostrar_fecha_inicio = new javax.swing.JTextField();
        login_lbl_usuario9 = new javax.swing.JLabel();
        login_lbl_usuario10 = new javax.swing.JLabel();
        mostrar_fecha_final = new javax.swing.JTextField();
        login_lbl_usuario11 = new javax.swing.JLabel();
        mostrar_descripcion = new javax.swing.JTextField();
        mostrar_presupuesto = new javax.swing.JTextField();
        login_lbl_usuario12 = new javax.swing.JLabel();
        panel_actividades = new javax.swing.JPanel();
        actividades_mostar = new javax.swing.JButton();
        actividades_crear = new javax.swing.JButton();
        actividades_modificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_motrar_personal_en_proyecto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_de_fondo.setBackground(new java.awt.Color(255, 255, 255));

        panel_lateral.setBackground(new java.awt.Color(102, 102, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Manager");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Project");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("V. 1.0.0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ver info");

        javax.swing.GroupLayout panel_lateralLayout = new javax.swing.GroupLayout(panel_lateral);
        panel_lateral.setLayout(panel_lateralLayout);
        panel_lateralLayout.setHorizontalGroup(
            panel_lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_lateralLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(panel_lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_lateralLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_lateralLayout.createSequentialGroup()
                        .addGroup(panel_lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_lateralLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(9, 9, 9))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(65, 65, 65))))
        );
        panel_lateralLayout.setVerticalGroup(
            panel_lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_lateralLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(76, 76, 76)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        crear_proyecto_btn_regresar.setBackground(new java.awt.Color(255, 255, 255));
        crear_proyecto_btn_regresar.setText("<<<");
        crear_proyecto_btn_regresar.setPreferredSize(new java.awt.Dimension(100, 30));
        crear_proyecto_btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_proyecto_btn_regresarActionPerformed(evt);
            }
        });

        login_lbl_usuario5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login_lbl_usuario5.setText("Nombre del proyecto");

        mostrar_nombre_proyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_nombre_proyectoActionPerformed(evt);
            }
        });

        mostrar_id_proyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_id_proyectoActionPerformed(evt);
            }
        });

        login_lbl_usuario6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login_lbl_usuario6.setText("id del proyecto");

        login_lbl_usuario7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login_lbl_usuario7.setText("Numero de trabajdores");

        mostrar_numero_trabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_numero_trabajadoresActionPerformed(evt);
            }
        });

        mostrar_persona_responsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_persona_responsableActionPerformed(evt);
            }
        });

        login_lbl_usuario8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login_lbl_usuario8.setText("Responsable del proyecto");

        mostrar_fecha_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_fecha_inicioActionPerformed(evt);
            }
        });

        login_lbl_usuario9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login_lbl_usuario9.setText("Fecha Inicio");

        login_lbl_usuario10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login_lbl_usuario10.setText("Fecha Final");

        mostrar_fecha_final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_fecha_finalActionPerformed(evt);
            }
        });

        login_lbl_usuario11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login_lbl_usuario11.setText("Descripcion");

        mostrar_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_descripcionActionPerformed(evt);
            }
        });

        mostrar_presupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_presupuestoActionPerformed(evt);
            }
        });

        login_lbl_usuario12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login_lbl_usuario12.setText("Presupuesto");

        javax.swing.GroupLayout panel_informarcion_generalLayout = new javax.swing.GroupLayout(panel_informarcion_general);
        panel_informarcion_general.setLayout(panel_informarcion_generalLayout);
        panel_informarcion_generalLayout.setHorizontalGroup(
            panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_informarcion_generalLayout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_informarcion_generalLayout.createSequentialGroup()
                        .addComponent(crear_proyecto_btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_informarcion_generalLayout.createSequentialGroup()
                        .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_informarcion_generalLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel_informarcion_generalLayout.createSequentialGroup()
                                        .addComponent(login_lbl_usuario10)
                                        .addGap(18, 18, 18)
                                        .addComponent(mostrar_fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_informarcion_generalLayout.createSequentialGroup()
                                        .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(login_lbl_usuario11)
                                            .addComponent(login_lbl_usuario12))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(mostrar_descripcion)
                                            .addComponent(mostrar_presupuesto, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)))))
                            .addGroup(panel_informarcion_generalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel_informarcion_generalLayout.createSequentialGroup()
                                        .addComponent(login_lbl_usuario7)
                                        .addGap(18, 18, 18)
                                        .addComponent(mostrar_numero_trabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_informarcion_generalLayout.createSequentialGroup()
                                        .addComponent(login_lbl_usuario6)
                                        .addGap(18, 18, 18)
                                        .addComponent(mostrar_id_proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_informarcion_generalLayout.createSequentialGroup()
                                        .addComponent(login_lbl_usuario8)
                                        .addGap(18, 18, 18)
                                        .addComponent(mostrar_persona_responsable, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_informarcion_generalLayout.createSequentialGroup()
                                        .addComponent(login_lbl_usuario5)
                                        .addGap(18, 18, 18)
                                        .addComponent(mostrar_nombre_proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_informarcion_generalLayout.createSequentialGroup()
                                        .addComponent(login_lbl_usuario9)
                                        .addGap(18, 18, 18)
                                        .addComponent(mostrar_fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(75, 75, 75))))
        );
        panel_informarcion_generalLayout.setVerticalGroup(
            panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_informarcion_generalLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrar_nombre_proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_lbl_usuario5))
                .addGap(20, 20, 20)
                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrar_id_proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_lbl_usuario6))
                .addGap(20, 20, 20)
                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrar_numero_trabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_lbl_usuario7))
                .addGap(20, 20, 20)
                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrar_persona_responsable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_lbl_usuario8))
                .addGap(18, 18, 18)
                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrar_fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_lbl_usuario9))
                .addGap(22, 22, 22)
                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrar_fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_lbl_usuario10))
                .addGap(20, 20, 20)
                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrar_presupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_lbl_usuario12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_informarcion_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrar_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_lbl_usuario11))
                .addGap(18, 18, 18)
                .addComponent(crear_proyecto_btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        mostrar_nombre_proyecto.setText(BBDD.obtenerProyectoPorId(idProyecto).getNombre());
        mostrar_id_proyecto.setText(BBDD.obtenerProyectoPorId(idProyecto).getIdProyecto());
        mostrar_numero_trabajadores.setText(String.valueOf(BBDD.cantidadPersonasTrabajanProyecto(idProyecto)));
        mostrar_persona_responsable.setText(BBDD.personaResponsableProyecto(idProyecto));
        mostrar_descripcion.setText(BBDD.obtenerProyectoPorId(idProyecto).getDescripcion());
        mostrar_presupuesto.setText(String.valueOf(BBDD.obtenerProyectoPorId(idProyecto).getPresupuesto()));

        jTabbedPane1.addTab("INFORMACION GENERAL", panel_informarcion_general);

        actividades_mostar.setBackground(new java.awt.Color(255, 255, 255));
        actividades_mostar.setText("MOSTAR TODAS LAS ACTVIDADES");
        actividades_mostar.setPreferredSize(new java.awt.Dimension(100, 30));
        actividades_mostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actividades_mostarActionPerformed(evt);
            }
        });

        actividades_crear.setBackground(new java.awt.Color(255, 255, 255));
        actividades_crear.setText("CREAR ACTIVIDAD");
        actividades_crear.setPreferredSize(new java.awt.Dimension(100, 30));
        actividades_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actividades_crearActionPerformed(evt);
            }
        });

        actividades_modificar.setBackground(new java.awt.Color(255, 255, 255));
        actividades_modificar.setText("MODIFICAR ACTIVIDAD");
        actividades_modificar.setPreferredSize(new java.awt.Dimension(100, 30));
        actividades_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actividades_modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_actividadesLayout = new javax.swing.GroupLayout(panel_actividades);
        panel_actividades.setLayout(panel_actividadesLayout);
        panel_actividadesLayout.setHorizontalGroup(
            panel_actividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_actividadesLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(panel_actividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actividades_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actividades_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actividades_mostar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        panel_actividadesLayout.setVerticalGroup(
            panel_actividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_actividadesLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(actividades_mostar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(actividades_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(actividades_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ACTIVIDADES", panel_actividades);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("TAREAS", jPanel1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("PERSONAL EN PROYECTO");

        jTextArea_motrar_personal_en_proyecto.setColumns(20);
        jTextArea_motrar_personal_en_proyecto.setRows(5);
        jScrollPane2.setViewportView(jTextArea_motrar_personal_en_proyecto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("PERSONAL", jPanel2);

        javax.swing.GroupLayout panel_de_fondoLayout = new javax.swing.GroupLayout(panel_de_fondo);
        panel_de_fondo.setLayout(panel_de_fondoLayout);
        panel_de_fondoLayout.setHorizontalGroup(
            panel_de_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_de_fondoLayout.createSequentialGroup()
                .addComponent(panel_lateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_de_fondoLayout.setVerticalGroup(
            panel_de_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_lateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_de_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_de_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crear_proyecto_btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_proyecto_btn_regresarActionPerformed
        // Acciones del boton regresar

        // Cerrar esta ventana y mostrar la ventana principal (Home)
        HomeUI home = new HomeUI(cedulaUsuario);
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_crear_proyecto_btn_regresarActionPerformed

    private void mostrar_nombre_proyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_nombre_proyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrar_nombre_proyectoActionPerformed

    private void mostrar_id_proyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_id_proyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrar_id_proyectoActionPerformed

    private void mostrar_numero_trabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_numero_trabajadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrar_numero_trabajadoresActionPerformed

    private void mostrar_persona_responsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_persona_responsableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrar_persona_responsableActionPerformed

    private void mostrar_fecha_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_fecha_inicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrar_fecha_inicioActionPerformed

    private void mostrar_fecha_finalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_fecha_finalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrar_fecha_finalActionPerformed

    private void mostrar_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrar_descripcionActionPerformed

    private void mostrar_presupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_presupuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrar_presupuestoActionPerformed

    private void actividades_mostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actividades_mostarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actividades_mostarActionPerformed

    private void actividades_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actividades_crearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actividades_crearActionPerformed

    private void actividades_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actividades_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actividades_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actividades_crear;
    private javax.swing.JButton actividades_modificar;
    private javax.swing.JButton actividades_mostar;
    private javax.swing.JButton crear_proyecto_btn_regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea_motrar_personal_en_proyecto;
    private javax.swing.JLabel login_lbl_usuario10;
    private javax.swing.JLabel login_lbl_usuario11;
    private javax.swing.JLabel login_lbl_usuario12;
    private javax.swing.JLabel login_lbl_usuario5;
    private javax.swing.JLabel login_lbl_usuario6;
    private javax.swing.JLabel login_lbl_usuario7;
    private javax.swing.JLabel login_lbl_usuario8;
    private javax.swing.JLabel login_lbl_usuario9;
    private javax.swing.JTextField mostrar_descripcion;
    private javax.swing.JTextField mostrar_fecha_final;
    private javax.swing.JTextField mostrar_fecha_inicio;
    private javax.swing.JTextField mostrar_id_proyecto;
    private javax.swing.JTextField mostrar_nombre_proyecto;
    private javax.swing.JTextField mostrar_numero_trabajadores;
    private javax.swing.JTextField mostrar_persona_responsable;
    private javax.swing.JTextField mostrar_presupuesto;
    private javax.swing.JPanel panel_actividades;
    private javax.swing.JPanel panel_de_fondo;
    private javax.swing.JPanel panel_informarcion_general;
    private javax.swing.JPanel panel_lateral;
    // End of variables declaration//GEN-END:variables
}