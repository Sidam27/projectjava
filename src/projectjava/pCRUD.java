/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SIDAM
 */
public class pCRUD extends javax.swing.JPanel {
    private static int id;

    /**
     * Creates new form pJurusan
     */
    public pCRUD()  throws ClassNotFoundException {
        initComponents() ;
       Show_data("select * from obat");
    Cek_jenis();

   
        
    }
private void Cek_jenis() throws ClassNotFoundException{
       
        try{
      int no=1;
            String sql = "select * from jenis";
            java.sql.Connection db = (Connection) Koneksi.configDB();
            java.sql.Statement stm;
            stm = db.createStatement();
            java.sql.ResultSet result = stm.executeQuery(sql);
            cbJenis.insertItemAt("pilih..", 0);
            while(result.next()){
            int index=Integer.valueOf(result.getString(1));

            cbJenis.insertItemAt(result.getString(2), no);
            no++;
            }
   
            
        }catch(SQLException e){
            System.out.println("Error : "+e.getMessage());
        }
    }
    private void Empty_form(){
      // t.setEditable(true);
      tKode.setText(null);
      tKode.setEditable(true);
      tNama.setText(null);
       tHarga.setText(null);
       tStok.setText(null);
       tJenis.setText(null);
       cbJenis.setSelectedIndex(0);
    }
    private void Show_data(String query) throws ClassNotFoundException{
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("KODE");
        model.addColumn("NAMA");
        model.addColumn("HARGA");
        model.addColumn("STOK");
        model.addColumn("JENIS");
        try{
            int no = 1;
            String sql = query;
            java.sql.Connection db = (Connection) Koneksi.configDB();
            java.sql.Statement stm;
            stm = db.createStatement();
            java.sql.ResultSet result = stm.executeQuery(sql);
            while(result.next()){
                model.addRow(new Object[]{result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)});
            }
            tObat.setModel(model);
        }catch(SQLException e){
            System.out.println("Error : "+e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tObat = new javax.swing.JTable();
        bTambah = new javax.swing.JButton();
        tKode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        tHarga = new javax.swing.JTextField();
        tStok = new javax.swing.JTextField();
        tJenis = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bEdit = new javax.swing.JButton();
        cbJenis = new javax.swing.JComboBox<>();
        tCari = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();
        bJenis = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DATA OBAT");

        tObat.setModel(new javax.swing.table.DefaultTableModel(
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
        tObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tObatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tObat);

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("OBAT");

        jLabel3.setText("Kode  =");

        jLabel4.setText("Nama =");

        jLabel5.setText("Harga =");

        jLabel6.setText("Stok  =");

        jLabel7.setText("Jenis =");

        tNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaActionPerformed(evt);
            }
        });

        tHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tHargaActionPerformed(evt);
            }
        });

        tStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tStokActionPerformed(evt);
            }
        });

        tJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tJenisActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("JENIS OBAT");

        jLabel9.setText("Jenis = ");

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        bCari.setText("Cari");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        bJenis.setText("Tambah");
        bJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bJenisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tStok)
                    .addComponent(tHarga)
                    .addComponent(jLabel2)
                    .addComponent(tKode)
                    .addComponent(tNama)
                    .addComponent(cbJenis, 0, 134, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bJenis)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(tJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(83, 83, 83))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bTambah)
                                    .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(128, 128, 128))))
            .addGroup(layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bCari)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bEdit)
                        .addComponent(bJenis)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaActionPerformed

    private void tHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tHargaActionPerformed

    private void tStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tStokActionPerformed

    private void tJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tJenisActionPerformed

    private void tObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tObatMouseClicked
        // TODO add your handling code here:
        int baris = tObat.rowAtPoint(evt.getPoint());
        String sid = tObat.getValueAt(baris, 0).toString();
        id=Integer.valueOf(sid);
        String kode = tObat.getValueAt(baris, 1).toString();
        tKode.setText(kode);
        String nama = tObat.getValueAt(baris, 2).toString();
        tNama.setText(nama);
        String harga = tObat.getValueAt(baris, 3).toString();
        tHarga.setText(harga);
        String stok = tObat.getValueAt(baris, 4).toString();
        tStok.setText(stok);
        String jenis = tObat.getValueAt(baris, 5).toString();
        int jenis1 = Integer.valueOf(jenis);
        cbJenis.setSelectedIndex(jenis1);
    }//GEN-LAST:event_tObatMouseClicked

    private void bJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bJenisActionPerformed
        // TODO add your handling code here:
        try{   
  
        
            String sql = "INSERT INTO jenis VALUES(NULL,'"+tJenis.getText()+"')";
            java.sql.Connection db = (Connection) Koneksi.configDB();
            java.sql.PreparedStatement pstm = db.prepareStatement(sql);
            pstm.execute(); 
            JOptionPane.showMessageDialog(null, "Berhasil disimpan");
            cbJenis.removeAllItems();
            Cek_jenis();
            Empty_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bJenisActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
        try{   
  
        
            String sql = "INSERT INTO obat VALUES(NULL,'"+tKode.getText()+"','"+tNama.getText()+"','"+tHarga.getText()+"','"+tStok.getText()+"','"+cbJenis.getSelectedIndex()+"')";
            java.sql.Connection db = (Connection) Koneksi.configDB();
            java.sql.PreparedStatement pstm = db.prepareStatement(sql);
            pstm.execute(); 
            JOptionPane.showMessageDialog(null, "Berhasil disimpan");
            Show_data("select * from obat");
            Empty_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bTambahActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "UPDATE obat SET kode = '"+tKode.getText()
                    +"',nama = '"+tNama.getText()
                    +"',harga = '"+tHarga.getText()
                    +"',stok = '"+tStok.getText()
                    +"',jenis = '"+cbJenis.getSelectedIndex()
                    +"'WHERE id_obat = '"+id+"'";
            java.sql.Connection db = (Connection) Koneksi.configDB();
            java.sql.PreparedStatement pstm = db.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Berhasil diedit");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Show_data("select * from obat");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Empty_form();
    }//GEN-LAST:event_bEditActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
          try {
           String sql = "SELECT * FROM obat WHERE kode LIKE '%"+tCari.getText()
                   +"%'"+"OR nama LIKE '%"+tCari.getText()+"%'";
            Show_data(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        tCari.setText(null);
    }//GEN-LAST:event_bCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCari;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bJenis;
    private javax.swing.JButton bTambah;
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tHarga;
    private javax.swing.JTextField tJenis;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tNama;
    private javax.swing.JTable tObat;
    private javax.swing.JTextField tStok;
    // End of variables declaration//GEN-END:variables
}
