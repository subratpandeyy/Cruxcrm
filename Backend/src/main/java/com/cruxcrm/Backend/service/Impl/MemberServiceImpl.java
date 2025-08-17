package com.cruxcrm.Backend.service.Impl;

import com.cruxcrm.Backend.DTO.Request.MemberRequestDto;
import com.cruxcrm.Backend.DTO.Response.MemberResponseDto;
import com.cruxcrm.Backend.model.Member;
import com.cruxcrm.Backend.model.Organization;
import com.cruxcrm.Backend.model.Role;
import com.cruxcrm.Backend.repository.MemberRepository;
import com.cruxcrm.Backend.repository.OrganizationRepository;
import com.cruxcrm.Backend.repository.RoleRepository;
import com.cruxcrm.Backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    OrganizationRepository orgRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<MemberResponseDto> getMembers() {
        return memberRepository.findAll().
                stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MemberResponseDto addMember(MemberRequestDto memberDto) {
        Member member = new Member();
        member.setMemberName(memberDto.getMemberName());
        member.setMemberEmail(memberDto.getMemberEmail());
        member.setMemberPassword(memberDto.getMemberPassword());

        Organization org = orgRepository.findById(memberDto.getOrgId())
                .orElseThrow(() -> new RuntimeException("Organization not found" + memberDto.getOrgId()));
        member.setOrg(org);

        Role role = roleRepository.findById(memberDto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found" + memberDto.getRoleId()));
        member.setRole(role);

        Member saved = memberRepository.save(member);
        return mapToResponse(saved);
    }

    private MemberResponseDto mapToResponse(Member member) {
        MemberResponseDto response = new MemberResponseDto();
        response.setMemberId(member.getMemberId());
        response.setMemberName(member.getMemberName());
        response.setMemberEmail(member.getMemberEmail());

        if(member.getOrg()!=null) {
            response.setOrgName(member.getOrg().getOrgName());
        }

        if(member.getRole()!=null) {
            response.setRoleName(member.getRole().getRoleName());
        }

        return response;
    }
}
