//package com.example.accessingdatarest;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//import java.util.List;
//
//@RepositoryRestResource(collectionResourceRel = "Member", path = "Member")
//public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
//
//    List<Member> findByLastName(@Param("lastname") String lastname);
//    List<Member> findByFirstName(@Param("firstname") String firstname);
//    List<Member> findByAddress(@Param("address") String address);
//    List<Member> findByEmail(@Param("email") String email);
//    List<Member> findByPhone(@Param("phone") String phone);
//    List<Member> findByDurationOfMembership(@Param("durationOfMembership") String durationOfMembership);
//    List<Member> findByMembershipType(@Param("membershipType") String membershipType);
//    List<Member> findByCurrentNumTournaments(@Param("currentNumTournaments") String currentNumTournaments);
//    List<Member> findByPastNumTournaments(@Param("pastNumTournaments") String pastNumTournaments);
//    List<Member> findByFutureNumTournaments(@Param("futureNumTournaments") String futureNumTournaments);



//}