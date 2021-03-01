package com.br.systemvoting.repository;

import com.br.systemvoting.domain.Associate;
import com.br.systemvoting.domain.Schedule;
import com.br.systemvoting.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findByAssociateAndSchedule(Associate associate, Schedule schedule);
    
}
