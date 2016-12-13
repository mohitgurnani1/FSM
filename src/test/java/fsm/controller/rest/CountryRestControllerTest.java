package fsm.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by Mohit on 12/7/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-spring-context.xml")
public class CountryRestControllerTest {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private CountryRestController countryRestController;

    private MockMvc mockMvc;

    @Before
    public void init(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(countryRestController).build();
    }



    @Test
    public void testGetAllCountries() throws Exception {


        mockMvc.perform(get("/countries/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[0].id").value("1"))
                .andExpect(jsonPath("$.[0].name").value("India"))
                .andExpect(jsonPath("$.length()").value(2));

    }

    @Test
    public void testGetCountryById() throws Exception {


        mockMvc.perform(get("/countries/{id}","1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("id").value("1"))
                .andExpect(jsonPath("name").value("India"));

    }

    @Test
    public void testGetCitiesInCountry() throws Exception {

        mockMvc.perform(get("/countries/{id}/cities","1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[0].id").value("1"))
                .andExpect(jsonPath("$.[0].name").value("Pune"))
                .andExpect(jsonPath("$.length()").value(2));

    }

}