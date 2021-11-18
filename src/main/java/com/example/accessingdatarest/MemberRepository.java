package com.example.accessingdatarest;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Member", path = "Member")
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

    List<Member> findByLastName(@Param("lastname") String lastname);



}