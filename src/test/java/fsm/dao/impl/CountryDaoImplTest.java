package fsm.dao.impl;

import fsm.controller.rest.CountryRestController;
import fsm.model.domain.Country;
import fsm.service.CountryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-spring-context.xml")
public class CountryDaoImplTest {

    @Autowired
    private CountryDaoImpl countryDao;


    @Test
    public void doesCountryDaoExist(){
        Assert.assertEquals(true,countryDao!=null);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void addCountry() throws Exception {

        Country expectedCountry=new Country("Wilmington");
        countryDao.addCountry(expectedCountry);
        Country actualCountry=countryDao.getCountryByName("Wilmington");
        Assert.assertEquals(expectedCountry.getName(),actualCountry.getName());
    }

    @Test
    public void removeCountry() throws Exception {

    }

    @Test
    public void updateCountry() throws Exception {

    }

    @Test
    public void getCountryById() throws Exception {

    }

    @Test
    public void getCountryByName() throws Exception {

    }

    @Test
    public void getAllCountries() throws Exception {

    }

}