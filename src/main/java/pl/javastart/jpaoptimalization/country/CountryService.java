package pl.javastart.jpaoptimalization.country;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryWithBiggestCity> findAllWithBiggestCity() {
        return countryRepository.findAllWithBiggestCity();
    }

    public List<Country> findAllWithLanguages() {
        return countryRepository.findAllWithLanguages();
    }
}
