
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
import travelagency.Dao.CountryDao;
import travelagency.Pojo.Country;

public class CountryDaoImpli implements CountryDao{
   Connection conn = DBConnection.getConnect();
    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS country(id int(5) auto_increment primary key,country_code varchar(20), Country_name varchar(20) unique)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(CountryDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Country con) {
       String sql = "insert into country(country_code,Country_name) values(?,?)";
        try {
           PreparedStatement ps=conn.prepareStatement(sql);
           
            ps.setString(1, con.getCountryCode());
            ps.setString(2, con.getCountryName());
            ps.executeUpdate();
            System.out.println("Insert success!");
        } catch (SQLException ex) {
            Logger.getLogger(CountryDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Country con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Country getCountryById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Country getIdByCountryName(String CountryName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Country> getList() {
         List<Country> list=new ArrayList<>();
           String sql="select * from country"; 
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                Country cun=new Country(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(cun);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CountryDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
