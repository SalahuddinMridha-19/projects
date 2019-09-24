/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency.DaoImpli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import travelagency.Connection.DBConnection;
import travelagency.Dao.TransactionDao;
import travelagency.Pojo.Client;
import travelagency.Pojo.Transaction;

/**
 *
 * @author User
 */
public class TransactionDaoImpli implements TransactionDao{
    public static void main(String[] args) {
       TransactionDao dao=new TransactionDaoImpli();
       dao.createTable();
    }
Connection conn=DBConnection.getConnect();
    @Override
    public void createTable() {
        String sql="create table if not exists transaction (id int(11) auto_increment primary key,totalAmount double,paidAmount double, purposeOfPayment varchar(20), paymentType varchar(20),paymentDate date, payment_place varchar(20),note varchar(20),c_id int(20),foreign key (c_id) references client(id))";
    try {
        PreparedStatement pstm=conn.prepareStatement(sql);
        pstm.execute();
        System.out.println("Table Created");
    } catch (SQLException ex) {
        Logger.getLogger(TransactionDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void save(Transaction ps) {
    String sql="insert into transaction(totalAmount ,paidAmount,purposeOfPayment,paymentType,paymentDate,payment_place,note,c_id) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setDouble(1, ps.getTotalAmount());
            pstm.setDouble(2, ps.getPaidAmount());
            pstm.setString(3, ps.getPurposeOfPayment());
            pstm.setString(4, ps.getPaymentType());
            pstm.setDate(5, ps.getPaymentDate());
           pstm.setString(6, ps.getPaymentPlace());
            pstm.setString(7, ps.getNote());
            pstm.setDouble(8, ps.getClient().getId());
           pstm.executeUpdate();
            System.out.println("Insert success");
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Transaction getClientById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaction getClientByName(String name) {
     Transaction transection=null;
     String sql="select * from transaction where ";
     return transection;
    }

    @Override
    public List<Transaction> getList() {
      List<Transaction> list=new ArrayList<>();
      String sql="select * from transaction";
        try {
            PreparedStatement pstm=conn.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                Transaction t=new Transaction(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getString(4),  rs.getString(5), rs.getDate(6),  rs.getString(7),  rs.getString(8), new Client(rs.getInt(9)));
                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list;
    }
    
}
