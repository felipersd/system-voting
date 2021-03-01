package com.br.systemvoting.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
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

import com.br.systemvoting.feature.VoteScenarioFactory;
import com.br.systemvoting.service.VoteService;
import com.br.systemvoting.utils.AbstractMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(VoteController.class)
public class VoteControllerTest extends AbstractMapper  {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VoteService service;

    @Test
    public void insertVote_WhenSendAVoteValid_ExpectedOk() throws Exception {
        when(service.insertVote(any())).thenReturn(VoteScenarioFactory.VOTE_RESPONSE);
        mockMvc.perform(post("/votes").contentType(MediaType.APPLICATION_JSON).content(asJsonString(VoteScenarioFactory.VOTE_REQUEST))).andExpect(status().isOk());
    }
}
