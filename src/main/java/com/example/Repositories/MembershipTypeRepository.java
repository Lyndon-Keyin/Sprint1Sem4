package com.example.Repositories;

import com.example.accessingdatarest.MembershipType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "membership_type", path="membership_type")
public interface MembershipTypeRepository extends PagingAndSortingRepository<MembershipType, Long> {
    List<MembershipType>findById(@Param("id") String id);
   // List<MembershipType>findByMembershipType(@Param("membership_type")String membership_type);
   // List<MembershipType>findMembershipTypeById(@Param("membership_type_id")String membership_type_id);

//    List<MembershipType>findByNormal(@Param("normal") String normal);
//    List<MembershipType>findBySpecialOffer(@Param("specialOffer")String specialOffer);
//    List<MembershipType>findByTrial(@Param("trial")String trial);
//    List<MembershipType>findByFamilyPlan(@Param("familyPlan")String familyPlan);
}
