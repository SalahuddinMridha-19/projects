
package travelagency.Dao;

import java.util.List;
import travelagency.Pojo.Summary;



public interface SummaryDao {
    void createTable();

    void save(Summary ps);   

    Summary getClientById(int id);

    Summary getClientByName(String name);   

    List<Summary> getList();
}
