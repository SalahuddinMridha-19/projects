/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency.Dao;

import java.util.List;
import travelagency.Pojo.Employee;

/**
 *
 * @author user
 */
public interface EmployeeDao {
    void createTable();
    void insert(Employee pm);
    void update(Employee pm);
    void delete(Employee pm);
    
    List<Employee> getList();
    
    Employee getClientBYId(int id);
    Employee getClientBYName(String name);
}
