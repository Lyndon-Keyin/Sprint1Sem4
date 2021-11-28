package com.example.Repositories;

import com.example.accessingdatarest.Member;
import com.example.accessingdatarest.MembershipType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Member", path="member")
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

    List<Member> findByLastName(@Param("lastname") String lastname);
//    List<Member> findAllByCurrentNumTournaments(@Param("all")String all);
//    List<Member> findById(@Param("id") String id);
    List<Member> findByPhone(@Param("phone") int phone);
    List<Member> findByCurrentNumTournaments(@Param("currentNumTournaments") int currentNumTournaments);
    List<Member> findByPastNumTournaments(@Param("pastNumTournaments") int pastNumTournaments);
    List<Member> findByFutureNumTournaments(@Param("futureNumTournaments") int futureNumTournaments);
//    List<Member> findByFirstName(@Param("firstname") String firstname);
//    List<Member> findByAddress(@Param("address") String address);
//    List<Member> findByEmail(@Param("email") String email);
//    List<Member> findByDurationOfMembership(@Param("durationOfMembership") String durationOfMembership);
//    List<Member> findByStartOfMembership(@Param("startOfMembership") LocalDate startOfMembership);
//    List<Member> findByMembershipType(@Param("membershipType") MembershipType membershipType);
//    List<Member> findMemberByMembershipTypeId(@Param("membershipTypeId")String membershipTypeId);
//    List<Member>findMembersByCurrentNumTournaments(@Param("membershipCurNumTour")int membershipCurNumTour);
//    List<Member>findMembersByPastNumTournaments(@Param("membershipPastNumTour")int membershipPastNumTour);
//    List<Member>findMembersByFutureNumTournaments(@Param("membershipFutureNumTour")String membershipFutureNumTour);
//    List<Member> deleteById(@Param("deleteMember")String deleteMember);

}
