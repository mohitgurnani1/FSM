package fsm.service.impl;

import fsm.dao.CountryDao;
import fsm.model.domain.Country;
import fsm.service.CountryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-spring-context.xml")
public class CountryServiceImplTest {

    @Mock
    private CountryDao countryDao;

    @InjectMocks
    private CountryService countryService=new CountryServiceImpl();

    @Before
    public  void  init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Rollback(true)
    public void addCountry() throws Exception {
        Country sample=new Country("Dubai");

        when(countryService.addCountry(sample)).thenReturn(1);

        int id=countryService.addCountry(sample);
        System.out.println(id);
        Assert.assertEquals(true,id==1);
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