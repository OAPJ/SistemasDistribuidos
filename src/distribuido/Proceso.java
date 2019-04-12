/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuido;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author <Mikel>
 */
public class Proceso extends javax.swing.JFrame implements Runnable{
    private ArrayList<Proceso> grupo;
    private ArrayList<String> cola;
    private boolean token, tokenEnUso;
    private boolean primetaVez;
    Thread ejecucion;
    /**
     * Creates new form Proceso
     */
    public Proceso() {
        initComponents();
        this.grupo=new ArrayList<>();
        this.grupo.add(this);
        
    }
    public Proceso(int id) {
        initComponents();
        this.primetaVez=true;
        this.grupo=new ArrayList<>();
        this.cola=new ArrayList<>();
        this.id.setText(id+"");
        this.colaLabel.setText("");
        this.token=true;
        this.tokenEnUso=false;
        this.grupo.add(this);
    }
    public void agregarAGrupo(Proceso nuevoProc){
        this.grupo.add(nuevoProc);
    }
    @Override
    public void run(){
        try{
            this.tiempo.setText(this.tiempoInicio.getText());
        while(true){
            int auxiliar=Integer.parseInt(this.tiempo.getText())+1;
            if(tokenEnUso)
                this.estadoRecursoLabel.setText("Si");
            else this.estadoRecursoLabel.setText("No");
            Thread.sleep(1000);
            this.tiempo.setText(auxiliar +"");
        }
        }catch(NumberFormatException e){
            System.out.println("murió por el numero");
        } catch (InterruptedException ex) {
            System.out.println("Murió por la espera");
        }
    }
    public boolean verificarRecDisponible(){
        
        if(!token) {System.out.println("d ");return false;}
            System.out.println("a");
            token=false;
        
        return true;
    }
    public boolean agregarCola(String id){
        if(this.cola.indexOf(id)==-1){ 
            this.cola.add(id);
            actualizarCola();
            return true;
        }
        return false;
    }
    public void actualizarCola(){
        String mensaje="";
        for(String i:this.cola){
            mensaje+=i+"|";
        }
        this.colaLabel.setText(mensaje);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        id = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tiempoInicio = new javax.swing.JTextField();
        tiempo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        estadoRecursoLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        colaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        id.setText("id");

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tiempo.setText("0");

        jButton2.setText("Soliicitar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Usando recurso");

        estadoRecursoLabel.setText("--");

        jButton3.setText("Liberar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        colaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tiempoInicio)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(colaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estadoRecursoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiempoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiempo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(estadoRecursoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getId() {
        return id.getText();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.ejecucion= new Thread(this);
        this.ejecucion.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(tokenEnUso){
            this.tokenEnUso=false;
        if(this.cola.size()>0){
            String eliminado="";
            for(Proceso p: this.grupo){
                eliminado=p.pasarSigRecurso();
            }
            for(Proceso p: this.grupo){
                if(p.getId().equals(eliminado)){
                    p.usarToken();
                    break;
                }
            }
        }
        else{
            for(Proceso p: this.grupo){
                p.liberarToken();
                p.setPrimetaVez(true);
            }
        }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void setPrimetaVez(boolean primetaVez) {
        this.primetaVez = primetaVez;
    }
    public String pasarSigRecurso(){
        String sigRecurso= this.cola.remove(0);
        actualizarCola();
        return sigRecurso;
    }
    public void liberarToken(){
        token=false;
    }
    public void usarToken(){
        this.tokenEnUso=true;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       boolean resultado=true;
        for(Proceso p: grupo){
           if(!p.verificarRecDisponible()){
               resultado=false;
               break;
           }
               
       }
       if(resultado){
           this.tokenEnUso=true;
       }else{
           for(Proceso p: grupo){
               p.agregarCola(this.id.getText());
           }
       }
       
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel colaLabel;
    private javax.swing.JLabel estadoRecursoLabel;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel tiempo;
    private javax.swing.JTextField tiempoInicio;
    // End of variables declaration//GEN-END:variables

    
}
