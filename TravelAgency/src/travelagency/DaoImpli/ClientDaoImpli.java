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
import travelagency.Dao.ClientDao;
import travelagency.Pojo.Client;

public class ClientDaoImpli implements ClientDao {
    public static void main(String[] args) {
        ClientDao dao=new ClientDaoImpli();
        dao.createTable();
   }

    Connection conn = DBConnection.getConnect();

    @Override
    public void createTable() {
        String sql = "create table if not exists client(id int(10) auto_increment primary key,name varchar(20),fathername varchar(20),gender varchar(20),age int(10),email varchar(20),mobile int(11),address varchar(20))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("table created");
        } catch (SQLException ex) {
            Logger.getLogger(ClientDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Client p) {

        String sql = "insert into client(name,fathername,gender,age,email,mobile,address) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getFatherName());
            ps.setString(3, p.getGenger());
            ps.setInt(4, p.getAge());
            ps.setString(5, p.getEmail());
            ps.setInt(6, p.getMobile());
            ps.setString(7, p.getAddress());
            ps.executeUpdate();
            System.out.println("Insert success");
        } catch (SQLException ex) {
            Logger.getLogger(ClientDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Client p) {

    }

    @Override
    public void delete(Client p) {
    }

    @Override
    public List<Client> getList() {
        List<Client> list = new ArrayList<>();
        String sql = "select * from client";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client p = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8));
            list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Client getClientBYId(int id) {
        Client client=null;
        String sql="select * from client where id=?";
        try {
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                client=new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }

    @Override
    public Client getClientBYName(String name) {
       Client client=null;
        String sql="select * from client where name=?";
        try {
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                client=new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }

}
