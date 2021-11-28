package com.example.Repositories;


import com.example.accessingdatarest.FutureTournaments;
import com.example.accessingdatarest.PastTournaments;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "FutureTournaments", path = "FutureTournaments")
public interface FutureTournamentsRepository extends PagingAndSortingRepository<FutureTournaments, Long> {
//    List<FutureTournaments> findByParticipatingMembers(@Param("participatingMembers") String participatingMembers);
//    List<FutureTournaments> deleteById(@Param("id")String id);
//    List<FutureTournaments> findById(@Param("id") String id);
//    List<FutureTournaments> findByCashPrize (@Param("cashPrize") String cashPrize);
//    List<FutureTournaments> findByEndDate (@Param("endDate") LocalDate endDate);
//    List<FutureTournaments> findByStartDate (@Param("startDate") LocalDate startDate);
//    List<FutureTournaments> findByLocation (@Param("location") String location);
//    List<FutureTournaments> findByEntryFee (@Param("entryFee") String entryFee);
//    List<FutureTournaments> findByFinalStandings (@Param("finalStandings") String finalStandings);
}
