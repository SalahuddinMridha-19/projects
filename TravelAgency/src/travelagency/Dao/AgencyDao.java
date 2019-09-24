
package travelagency.Dao;

import java.util.List;
import travelagency.Pojo.Agency;

public interface AgencyDao {
     void createTable();
    void insert(Agency insertCompany);
    Void updete(Agency insertCompany);

    
     List<Agency> getInsertCompany();
     
     
     Agency getInsertCompanyById(int id);
     Agency getInsertCompanyByName(String companyName);
}
