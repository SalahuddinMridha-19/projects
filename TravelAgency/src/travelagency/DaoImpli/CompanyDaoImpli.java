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

import travelagency.Dao.CompanyDao;
import travelagency.Pojo.Company;

/**
 *
 * @author User
 */
public class CompanyDaoImpli implements CompanyDao{
 Connection conn=DBConnection.getConnect();
    @Override
    public void createTable() {
        String sql = "create table if not exists company(company_id int(5) auto_increment  primary key,company_name varchar(20),company_country varchar(20),company_email varchar(20),company_contactNo varchar(20),company_address varchar(20))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("insertcompany table Created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Company insertCompany) {
          String sql = "insert into company(company_name,company_country,company_email,company_contactNo,company_address) values(?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, insertCompany.getCompanyName());
            pstm.setString(2, insertCompany.getCompanyCountry());
            pstm.setString(3, insertCompany.getCompanyEmail());
            pstm.setString(4, insertCompany.getCompanyContactNo());
            pstm.setString(5, insertCompany.getCompanyAddress());
            pstm.executeUpdate();
            System.out.println("Data inserted into company table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Void updete(Company insertCompany) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Company> getInsertCompany() {
     List<Company> list = new ArrayList<>();
        String sql = "select * from company";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Company ic = new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(ic);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public Company getInsertCompanyById(int id) {
        Company com = null;
        String sql = "select * from company where company_id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                com = new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }

        return com;
    }
    

    @Override
    public Company getInsertCompanyByName(String companyName) {
         Company com = null;
        String sql = "select * from company where company_name = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, companyName);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                com = new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDaoImpli.class.getName()).log(Level.SEVERE, null, ex);
        }

        return com;
    }
    }

   
    

