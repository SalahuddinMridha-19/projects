
package travelagency.Dao;

import java.util.List;
import travelagency.Pojo.Client;

public interface ClientDao {
    void createTable();
    void insert(Client p);
    void update(Client p);
    void delete(Client p);
    
    List<Client> getList();
    
    Client getClientBYId(int id);
    Client getClientBYName(String name);
}
