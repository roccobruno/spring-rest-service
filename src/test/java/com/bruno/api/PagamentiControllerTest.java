package com.bruno.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:test-context.xml"})

public class PagamentiControllerTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();

    }


    @Test
    public void testGET() {

        try {

            mockMvc.perform(MockMvcRequestBuilders.get("/pagamenti").accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(
                            MockMvcResultMatchers.content().string(
                                    "[{\"id\":\"id1\",\"descrizione\":\"desc1\",\"cig\":\"2322\"},{\"id\":\"id2\",\"descrizione\":\"desc1\",\"cig\":\"2322\"},{\"id\":\"id3\",\"descrizione\":\"desc1\",\"cig\":\"2322\"}]"));


        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}