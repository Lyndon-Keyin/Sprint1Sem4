package com.example.Repositories;


import java.time.LocalDate;

import com.example.accessingdatarest.CurrentTournaments;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "CurrentTournaments", path = "CurrentTournaments")
public interface CurrentTournamentsRepository extends PagingAndSortingRepository<CurrentTournaments, Long> {


      List<CurrentTournaments> findByParticipatingMembers(@Param("participatingMembers") String participatingMembers);
//      List<CurrentTournaments> findById(@Param("id") String id);
//      List<CurrentTournaments> findByCashPrize (@Param("cashPrize") String cashPrize);
//      List<CurrentTournaments> findByEndDate (@Param("endDate") LocalDate endDate);
//      List<CurrentTournaments> findByStartDate (@Param("startDate") LocalDate startDate);
//      List<CurrentTournaments> findByLocation (@Param("location") String location);
//      List<CurrentTournaments> findByEntryFee (@Param("entryFee") String entryFee);
//      List<CurrentTournaments> findByFinalStandings (@Param("finalStandings") String finalStandings);


}


