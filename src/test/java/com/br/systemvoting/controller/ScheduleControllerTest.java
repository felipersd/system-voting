package com.br.systemvoting.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.br.systemvoting.feature.ScheduleScenarioFactory;
import com.br.systemvoting.service.ScheduleService;
import com.br.systemvoting.utils.AbstractMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(ScheduleController.class)
public class ScheduleControllerTest extends AbstractMapper{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScheduleService service;
 
    @Test
    public void insertSchedule_WhenSendValidSchedule_ExpectedOk() throws Exception {
        when(service.insertSchedule(any())).thenReturn(ScheduleScenarioFactory.SCHEDULE_RESPONSE);
        mockMvc.perform(post("/schedules").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(ScheduleScenarioFactory.SCHEDULE_REQUEST))).andExpect(status().isCreated());
    }

    @Test
    public void listAllSchedules_ExpectedOk() throws Exception{
        when(service.listAllSchedules()).thenReturn(ScheduleScenarioFactory.SCHEDULE_RESPONSES_LIST);
        mockMvc.perform(get("/schedules").contentType(MediaType.APPLICATION_JSON).content(asJsonString(ScheduleScenarioFactory.SCHEDULE_RESPONSES_LIST)))
        .andExpect(status().isOk());
    }
}
