/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency.Dao;

import java.util.List;
import travelagency.Pojo.Flight;

/**
 *
 * @author User
 */
public interface FlightDao {
    void createTable();
    void insert(Flight pm);
    void update(Flight pm);
    void delete(Flight pm);
    
    List<Flight> getList();
    
    Flight getClientBYId(int id);
    Flight getClientBYName(String name);
}
