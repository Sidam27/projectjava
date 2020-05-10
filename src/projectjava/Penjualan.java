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

/**
 *
 * @author SIDAM
 */
public class Penjualan extends ProducFlow{
    int lastid;

    @Override
    public void tambahDetail(int newido, int newjumlah, int newharga) {
        //To change body of generated methods, choose Tools | Templates.
        try{   

            String sql = "UPDATE obat SET stok = (SELECT stok from obat where id_obat='"+newido+"')-'"+newjumlah+"' WHERE id_obat='"+newido+"'";
            java.sql.Connection db = (Connection) Koneksi.configDB();
            java.sql.PreparedStatement pstm = db.prepareStatement(sql);
            pstm.execute();
        }catch(HeadlessException | SQLException e){
              System.out.println("Error3 : "+lastid);
        } catch (ClassNotFoundException ex) {
               System.out.println("Error4 : "+ex.getMessage());
        }
          try{   
            String sql = "INSERT INTO jual VALUES(NULL,'"+newido+"','"+lastid+"','"+newjumlah+"','"+newharga+"')";
            java.sql.Connection db = (Connection) Koneksi.configDB();
            java.sql.PreparedStatement pstm = db.prepareStatement(sql);
            pstm.execute();
        
        }catch(HeadlessException | SQLException e){
              System.out.println("Error3 : "+lastid);
        } catch (ClassNotFoundException ex) {
               System.out.println("Error4 : "+ex.getMessage());
        }
  
    }

    @Override
    public void tambahData(String newnama, int newtharga) {
        //To change body of generated methods, choose Tools | Templates.
         try{   
            String sql = "INSERT INTO transaksi_jual VALUES(NULL,'"+newnama+"','"+newtharga+"')";
            java.sql.Connection db = (Connection) Koneksi.configDB();
            java.sql.PreparedStatement pstm = db.prepareStatement(sql);
            pstm.execute(); 
             JOptionPane.showMessageDialog(null, "Transaksi berhasil");
        }catch(HeadlessException | SQLException e){
              JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         lastid=getLastid();
    }

    @Override
    public int getLastid() {
        //To change body of generated methods, choose Tools | Templates.
        int cek=0;
        try{
            int no = 1;
            String sql = "SELECT id_transaksi FROM transaksi_jual ORDER BY id_transaksi DESC LIMIT 1";
            java.sql.Connection db = (Connection) Koneksi.configDB();
            java.sql.Statement stm;
            stm = db.createStatement();
            java.sql.ResultSet result = stm.executeQuery(sql);
            while(result.next()){
                cek = result.getInt(1);
            }
        }catch(SQLException e){
            System.out.println("Error1 : "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error2 : "+ex.getMessage());
        }
        return cek;
    }
    
    
}
