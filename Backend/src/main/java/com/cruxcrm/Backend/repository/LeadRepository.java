package com.cruxcrm.Backend.repository;

import com.cruxcrm.Backend.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    List<Lead> findByOrg_OrgId(Long orgId);
    List<Lead> findByMember_MemberId(Long memberId);
}
