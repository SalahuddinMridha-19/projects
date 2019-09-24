
package travelagency.Dao;

import java.util.List;
import travelagency.Pojo.Transaction;


public interface TransactionDao {
    void createTable();

    void save(Transaction ps);   

    Transaction getClientById(int id);

    Transaction getClientByName(String name);   

    List<Transaction> getList();
}
