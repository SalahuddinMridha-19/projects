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
import travelagency.Dao.EmployeeDao;

import travelagency.Pojo.Employee;

public class EmployeeDaoImpli implements EmployeeDao {
    public static void main(String[] args) {
        EmployeeDao dao=new EmployeeDaoImpli();
        dao.createTable();
    }

    Connection conn = DBConnection.getConnect();
    

    @Override
    public void createTable() {
        String sql = "create table if not exists employee(id int(10) auto_increment primary key,name varchar(20),fathername varchar(20),gender varchar(20),age int(10),email varchar(20),mobile int(11),address varchar(20))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("table created");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Employee p) {

        String sql = "insert into employee(name,fathername,gender,age,email,mobile,address) values(?,?,?,?,?,?,?)";
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
            Logger.getLogger(EmployeeDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Employee p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Employee p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getList() {
        List<Employee> list = new ArrayList<>();
        String sql = "select * from employee";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee p = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Employee getClientBYId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getClientBYName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
