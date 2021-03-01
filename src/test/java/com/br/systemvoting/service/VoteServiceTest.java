package com.br.systemvoting.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.br.systemvoting.feature.AssociateScenarioFactory;
import com.br.systemvoting.feature.SessionScenarioFactory;
import com.br.systemvoting.feature.VoteScenarioFactory;
import com.br.systemvoting.repository.AssociateRepository;
import com.br.systemvoting.repository.SessionRepository;
import com.br.systemvoting.repository.VoteRepository;

@RunWith(MockitoJUnitRunner.class)
public class VoteServiceTest {

    @InjectMocks
    VoteService service;

    @Mock
    VoteRepository voteRepository;

    @Mock
    AssociateRepository associateRepository;

    @Mock
    SessionRepository sessionRepository;

    @Mock
    UserInfoService userInfoService;

    @Test
    public void insertVote_WhenVoteRequestIsValid_ExpectedOk() {        
        when(sessionRepository.findById(any())).thenReturn(Optional.of(SessionScenarioFactory.SESSION));
        when(associateRepository.findByCpf(any())).thenReturn(Optional.of(AssociateScenarioFactory.ASSOCIATE));
        when(userInfoService.checkAssociateCanVote(any())).thenReturn(true);
        when(voteRepository.findByAssociateAndSchedule(any(),any())).thenReturn(new ArrayList<>());
        when(voteRepository.save(any())).thenReturn(VoteScenarioFactory.VOTE);
        assertNotNull(service.insertVote(VoteScenarioFactory.VOTE_REQUEST));
        verify(voteRepository,times(1)).save(any());
    }
    
}
