package fsm.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Mohit on 12/8/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-spring-context.xml")
public class IndexControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private IndexController indexController;

    @Before
    public void init(){
     //   MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }


    @Test
    public void showFloorPlanPage() throws Exception {
        mockMvc.perform(get("/floorPlan"))
                .andExpect(status().isOk())
                .andExpect(view().name("index2.html"));
}

}