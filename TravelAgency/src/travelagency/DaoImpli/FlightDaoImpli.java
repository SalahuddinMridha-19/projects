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
import travelagency.Dao.FlightDao;
import travelagency.Pojo.Flight;

/**
 *
 * @author User
 */
public class FlightDaoImpli implements FlightDao{
   
Connection conn=DBConnection.getConnect();
    @Override
    public void createTable() {
   String sql="create table if not exists flight (id int(10) auto_increment primary key , flight_name varchar(20),flight_class varchar(20), flight_charge double, seats varchar(20),destination varchar(20),departure_time varchar(20), arival_time varchar(20), ticket_no varchar(20))";
    try {
        PreparedStatement pstm=conn.prepareStatement(sql);
        pstm.execute();
        System.out.println("Table Created");
    } catch (SQLException ex) {
        Logger.getLogger(FlightDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void insert(Flight pm) {
        String sql="insert into flight(flight_name,flight_class,flight_charge,seats,destination,departure_time,arival_time ,ticket_no)values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setString(1, pm.getFlightName());
            pstm.setString(2, pm.getFlightClass());
            pstm.setDouble(3, pm.getFlightCharge());
            pstm.setString(4, pm.getSeats());
            pstm.setString(5, pm.getDestination());
            pstm.setString(6, pm.getDepartureTime());
            pstm.setString(7, pm.getArivalTime());
            pstm.setString(8, pm.getTicketNo());
            pstm.executeUpdate();
            System.out.println("Insert success");
        } catch (SQLException ex) {
            Logger.getLogger(FlightDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Flight pm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Flight pm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Flight> getList() {
    List<Flight> list=new ArrayList<>();
    String sql="select * from flight";
        try {
            PreparedStatement pstm=conn.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                Flight f=new Flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return list;
    }

    @Override
    public Flight getClientBYId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Flight getClientBYName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
