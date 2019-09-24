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
import travelagency.Dao.SummaryDao;
import travelagency.Pojo.Client;
import travelagency.Pojo.Summary;

/**
 *
 * @author User
 */
public class SummaryDaoImpli implements SummaryDao {

    Connection conn = DBConnection.getConnect();

    @Override
    public void createTable() {
        String sql = "create table if not exists summary(id int(11) auto_increment primary key,totalAmount double,paidAmount double,dueAmount double, purposeOfPayment varchar(20), paymentType varchar(20),paymentDate date, payment_place varchar(20),note varchar(20),c_id int(20),foreign key (c_id) references client(id))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Summary ps) {
        //totalAmount double,paidAmount double,dueAmount double, purposeOfPayment varchar(20), paymentType varchar(20),paymentDate date, payment_place varchar(20),note varchar(20),c_id int(20),foreign key (c_id) references client(id))
       String sql = "insert into summary(totalAmount,paidAmount,dueAmount,purposeOfPayment,paymentType,paymentDate,payment_place,note,c_id) values (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setDouble(1, ps.getTotalAmount());
            pstm.setDouble(2, ps.getPaidAmount());
            pstm.setDouble(3, ps.getDueAmount());
            pstm.setString(4, ps.getPurposeOfPayment());
            pstm.setString(5, ps.getPaymentType());
            pstm.setDate(6, ps.getPaymentDate());
            pstm.setString(7, ps.getPaymentPlace());
            pstm.setString(8, ps.getNote());
            pstm.setDouble(9, ps.getClient().getId());
            pstm.executeUpdate();
            System.out.println("Insert success");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Summary getClientById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Summary getClientByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Summary> getList() {
        List<Summary> list = new ArrayList<>();
        String sql = "select * from summary";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                //totalAmount double,paidAmount double,dueAmount double, purposeOfPayment varchar(20), paymentType varchar(20),paymentDate date, payment_place varchar(20),note varchar(20),c_id int(20),foreign key (c_id) references client(id))
                Summary s = new Summary(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), new Client(rs.getInt(10)));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
