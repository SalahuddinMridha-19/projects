
package travelagency.Dao;

import java.util.List;
import travelagency.Pojo.Company;

public interface CompanyDao {
    void createTable();
    void insert(Company insertCompany);
    Void updete(Company insertCompany);

    
     List<Company> getInsertCompany();
     
     
     Company getInsertCompanyById(int id);
     Company getInsertCompanyByName(String companyName);
}
