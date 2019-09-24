
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
import travelagency.Dao.AgencyDao;
import travelagency.Pojo.Agency;


public class AgencyDaoImpli implements AgencyDao{
 Connection conn=DBConnection.getConnect();
    @Override
    public void createTable() {
        String sql = "create table if not exists agency(company_id int(5) auto_increment  primary key,company_name varchar(20),company_country varchar(20),company_email varchar(20),company_contactNo varchar(20),company_address varchar(20))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("insertcompany table Created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(AgencyDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Agency insertCompany) {
       String sql = "insert into agency(company_name,company_country,company_email,company_contactNo,company_address) values(?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, insertCompany.getAgencyName());
            pstm.setString(2, insertCompany.getAgencyCountry());
            pstm.setString(3, insertCompany.getAgencyEmail());
            pstm.setString(4, insertCompany.getAgencyContactNo());
            pstm.setString(5, insertCompany.getAgencyAddress());
            pstm.executeUpdate();
            System.out.println("Data inserted into company table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(AgencyDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Void updete(Agency insertCompany) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Agency> getInsertCompany() {
        List<Agency> list = new ArrayList<>();
        String sql = "select * from agency";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Agency ic = new Agency(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(ic);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgencyDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public Agency getInsertCompanyById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Agency getInsertCompanyByName(String companyName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
