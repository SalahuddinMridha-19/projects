
package travelagency.Dao;

import java.util.List;
import travelagency.Pojo.Country;

public interface CountryDao {
    void createTable();

    void save(Country con);

    void update(Country con);

    Country getCountryById(int id);

    Country getIdByCountryName(String CountryName);

    void delete(int id);

    List<Country> getList();
}
