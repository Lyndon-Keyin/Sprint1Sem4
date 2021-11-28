package com.example.Repositories;


import com.example.accessingdatarest.PastTournaments;
import com.example.accessingdatarest.PastTournaments;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "PastTournaments", path = "PastTournaments")
public interface PastTournamentsRepository extends PagingAndSortingRepository<PastTournaments, Long> {

    List<PastTournaments> findByParticipatingMembers(@Param("participatingMembers") String participatingMembers);
//    List<PastTournaments> findById(@Param("id") String id);
//    List<PastTournaments> findByCashPrize (@Param("cashPrize") String cashPrize);
//    List<PastTournaments> findByEndDate (@Param("endDate") LocalDate endDate);
//    List<PastTournaments> findByStartDate (@Param("startDate") LocalDate startDate);
//    List<PastTournaments> findByLocation (@Param("location") String location);
//    List<PastTournaments> findByEntryFee (@Param("entryFee") String entryFee);
//    List<PastTournaments> findByFinalStandings (@Param("finalStandings") String finalStandings);
}
