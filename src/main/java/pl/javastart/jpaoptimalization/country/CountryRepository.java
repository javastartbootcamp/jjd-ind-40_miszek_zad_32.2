package pl.javastart.jpaoptimalization.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Query("SELECT  c.name as countryName, ci.name as cityName, ci.population as population " +
            "FROM Country c " +
            "LEFT JOIN c.cities ci " +
            "WHERE ci.name is null OR ci.population = (SELECT MAX(ci2.population) FROM City ci2 WHERE ci2.country = c) " +
            "ORDER BY c.name ASC")
    List<CountryWithBiggestCity> findAllWithBiggestCity();

    @Query("SELECT DISTINCT c FROM Country c LEFT JOIN FETCH c.languages ORDER BY c.name")
    List<Country> findAllWithLanguages();

}
