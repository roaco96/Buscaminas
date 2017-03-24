
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Pantalla extends javax.swing.JFrame {

    private Pantalla ventana;
    private static int n_bombas=10;
    private ArrayList<ArrayList<JButton>> array;
    private ArrayList<JButton> fila;
    private Random aleatorio;
    private ArrayList<Integer> bombas;
    
    private int numeroBombas;
    
    public void borrarBuscaminas()
    {
        lNumeroMinas.setText("0");
        lNumeroPuntos.setText("0");
        pBotones.removeAll();
        validate();
        array.clear();
        fila.clear();
        bombas.clear();
        crearBuscaminas();
    }
    
    
    public int comprobarCuadrante(int posicion)
    {
        int n_bombas=0, pos_anterior, pos_siguiente, arriba1, arriba2, arriba3, abajo1, abajo2, abajo3;
        pos_anterior=posicion-1;
        pos_siguiente=posicion+1;
        arriba1=posicion-11;
        arriba2=posicion-10;
        arriba3=posicion-9;
        abajo1=posicion+9;
        abajo2=posicion+10;
        abajo3=posicion+11;
        
        
        if (pos_anterior>-1) 
        {
            if(bombas.get(pos_anterior)==1)
            {
                n_bombas++;
            }
        }
        
        
        if (pos_siguiente<100) 
        {
            if(bombas.get(pos_siguiente)==1)
            {
                n_bombas++;
            }
        }
        
        if (arriba1>-1) 
        {
            if(bombas.get(arriba1)==1)
            {
                n_bombas++;
            }
        }
        
        if (arriba2>-1) 
        {
            if(bombas.get(arriba2)==1 )
            {
                n_bombas++;
            }
        }
        
        if (arriba3>-1) 
        {
            if(bombas.get(arriba3)==1)
            {
                n_bombas++;
            }
        }
        
        if (abajo3<100) 
        {
            if(bombas.get(abajo1)==1)
            {
                n_bombas++;
            }
            if(bombas.get(abajo3)==1)
            {
                n_bombas++;
            }
            if(bombas.get(abajo2)==1)
            {
                n_bombas++;
            }
        }
        
        
        return n_bombas;
        
        
    }
   
    
    
    public void crearBuscaminas()
    {
        
        for (int i = 0; i < 100; i++) 
        {
            bombas.add(0);
            
        }
        
        
        
        for (int i = 0; i < 100; i++) 
        {
            
           
            int posicion=i;
            final JButton boton= new JButton();
            pBotones.add(boton);
            fila.add(boton);
            boton.setIcon(new ImageIcon(this.getClass().getResource("imagenes/interrogacion_azul.png")));
            boton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(bombas.get(posicion)==1)
                    {
                        String r_icono ="imagenes/game_over.png";
                        ImageIcon icono = new ImageIcon(getClass().getResource(r_icono));

                        
                        JOptionPane.showMessageDialog(ventana,
                            "Perdiste.\nPuntos: "+lNumeroPuntos.getText(),
                            "GAME OVER",
                            JOptionPane.INFORMATION_MESSAGE,
                            icono); 
                        
                        
                        borrarBuscaminas();
                        
                    }
                    else
                    {
                        
                        int numero=Integer.valueOf(lNumeroPuntos.getText())+15;
                        lNumeroPuntos.setText(String.valueOf(numero));
                        
                        numeroBombas=comprobarCuadrante(posicion);
                        
                        boton.setText(String.valueOf(numeroBombas));
                        boton.setIcon(null);
                        boton.setEnabled(false);
                        
                    }
                                 
                }
            });
            
            
            
        }
        
        for (int i = 0; i < fila.size(); i=i+10) 
        {
            ArrayList<JButton> filas=new ArrayList<>();
            for (int j = i; j < i+10; j++) 
            {
                filas.add(fila.get(j));
            }
            array.add(filas);
            
        }
    }
    
    /**
     * Creates new form Pantalla
     */
    public Pantalla() {
        initComponents();
        
        bombas=new ArrayList<>();
        aleatorio=new Random();
        array= new ArrayList<>();
        fila= new ArrayList<>();

            
        ventana=this;
        
        
        crearBuscaminas();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pInformacion = new javax.swing.JPanel();
        lMinas = new javax.swing.JLabel();
        lNumeroMinas = new javax.swing.JLabel();
        bNuevo = new javax.swing.JButton();
        lPuntos = new javax.swing.JLabel();
        lNumeroPuntos = new javax.swing.JLabel();
        pBotones = new javax.swing.JPanel();
        mMenuJuego = new javax.swing.JMenuBar();
        mJuego = new javax.swing.JMenu();
        mColores = new javax.swing.JMenu();
        miAzul = new javax.swing.JMenuItem();
        miMorado = new javax.swing.JMenuItem();
        miRojo = new javax.swing.JMenuItem();
        miVerde = new javax.swing.JMenuItem();
        miCartia = new javax.swing.JMenuItem();
        mDificultad = new javax.swing.JMenu();
        miFacil = new javax.swing.JMenuItem();
        miMedio = new javax.swing.JMenuItem();
        miDificil = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pInformacion.setLayout(new java.awt.GridLayout(1, 5, 10, 10));

        lMinas.setText("Minas restantes");
        pInformacion.add(lMinas);

        lNumeroMinas.setText("0");
        pInformacion.add(lNumeroMinas);

        bNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_nuevo.png"))); // NOI18N
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });
        pInformacion.add(bNuevo);

        lPuntos.setText("Puntos");
        pInformacion.add(lPuntos);

        lNumeroPuntos.setText("0");
        pInformacion.add(lNumeroPuntos);

        getContentPane().add(pInformacion, java.awt.BorderLayout.NORTH);

        pBotones.setLayout(new java.awt.GridLayout(10, 10));
        getContentPane().add(pBotones, java.awt.BorderLayout.CENTER);

        mJuego.setText("Juego");

        mColores.setText("Color de las interrogaciones");

        miAzul.setText("Azul");
        miAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAzulActionPerformed(evt);
            }
        });
        mColores.add(miAzul);

        miMorado.setText("Morado");
        miMorado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMoradoActionPerformed(evt);
            }
        });
        mColores.add(miMorado);

        miRojo.setText("Rojo");
        miRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRojoActionPerformed(evt);
            }
        });
        mColores.add(miRojo);

        miVerde.setText("Verde");
        miVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVerdeActionPerformed(evt);
            }
        });
        mColores.add(miVerde);

        miCartia.setText("Carita pensante");
        miCartia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCartiaActionPerformed(evt);
            }
        });
        mColores.add(miCartia);

        mJuego.add(mColores);

        mDificultad.setText("Dificultad");

        miFacil.setText("Fácil (10 bombas)");
        miFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFacilActionPerformed(evt);
            }
        });
        mDificultad.add(miFacil);

        miMedio.setText("Media (20 bombas)");
        miMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMedioActionPerformed(evt);
            }
        });
        mDificultad.add(miMedio);

        miDificil.setText("Difícil (30 bombas)");
        miDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDificilActionPerformed(evt);
            }
        });
        mDificultad.add(miDificil);

        mJuego.add(mDificultad);

        mMenuJuego.add(mJuego);

        setJMenuBar(mMenuJuego);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        
        borrarBuscaminas();
        lNumeroPuntos.setText("0");
        lNumeroMinas.setText("0");
        
    }//GEN-LAST:event_bNuevoActionPerformed

    private void miAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAzulActionPerformed
        
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                array.get(i).get(j).setIcon(new ImageIcon(this.getClass().getResource("imagenes/interrogacion_azul.png")));
                
            }
            
        }
        
        
        
    }//GEN-LAST:event_miAzulActionPerformed

    private void miMoradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMoradoActionPerformed
        
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                array.get(i).get(j).setIcon(new ImageIcon(this.getClass().getResource("imagenes/interrogacion_morada.png")));
                
            }
            
        }
        
    }//GEN-LAST:event_miMoradoActionPerformed

    private void miRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRojoActionPerformed
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                array.get(i).get(j).setIcon(new ImageIcon(this.getClass().getResource("imagenes/interrogacion_roja.png")));
                
            }
            
        }
    }//GEN-LAST:event_miRojoActionPerformed

    private void miVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVerdeActionPerformed
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                array.get(i).get(j).setIcon(new ImageIcon(this.getClass().getResource("imagenes/interrogacion_verde.png")));
                
            }
            
        }
    }//GEN-LAST:event_miVerdeActionPerformed

    private void miCartiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCartiaActionPerformed
        
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                array.get(i).get(j).setIcon(new ImageIcon(this.getClass().getResource("imagenes/cara.png")));
                
            }
            
        }
    }//GEN-LAST:event_miCartiaActionPerformed

    private void miFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFacilActionPerformed
        n_bombas=10;
        if(bombas.isEmpty()==true)
        {
            bombas.clear();
        }
        
        for (int i = 0; i < n_bombas; i++) 
        {
            int n_aleatorio=aleatorio.nextInt(100-0)+0;
            bombas.set(n_aleatorio, 1);
            
            
        }
        lNumeroMinas.setText("10");
        
        
    }//GEN-LAST:event_miFacilActionPerformed

    private void miMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMedioActionPerformed
        
        n_bombas=20;
        if(bombas.isEmpty()==true)
        {
            bombas.clear();
        }
        for (int i = 0; i < n_bombas; i++) 
        {
            int n_aleatorio=aleatorio.nextInt(100-0)+0;
            bombas.set(n_aleatorio, 1);
            
            
        }
        lNumeroMinas.setText("20");
    }//GEN-LAST:event_miMedioActionPerformed

    private void miDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDificilActionPerformed
        lNumeroMinas.setText("30");
        n_bombas=30;
        if(bombas.isEmpty()==true)
        {
            bombas.clear();
        }
        for (int i = 0; i < n_bombas; i++) 
        {
            int n_aleatorio=aleatorio.nextInt(100-0)+0;
            bombas.set(n_aleatorio, 1);
            
            
        }
    }//GEN-LAST:event_miDificilActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNuevo;
    private javax.swing.JLabel lMinas;
    private javax.swing.JLabel lNumeroMinas;
    private javax.swing.JLabel lNumeroPuntos;
    private javax.swing.JLabel lPuntos;
    private javax.swing.JMenu mColores;
    private javax.swing.JMenu mDificultad;
    private javax.swing.JMenu mJuego;
    private javax.swing.JMenuBar mMenuJuego;
    private javax.swing.JMenuItem miAzul;
    private javax.swing.JMenuItem miCartia;
    private javax.swing.JMenuItem miDificil;
    private javax.swing.JMenuItem miFacil;
    private javax.swing.JMenuItem miMedio;
    private javax.swing.JMenuItem miMorado;
    private javax.swing.JMenuItem miRojo;
    private javax.swing.JMenuItem miVerde;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pInformacion;
    // End of variables declaration//GEN-END:variables
}
