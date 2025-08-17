package com.cruxcrm.Backend.service;

import com.cruxcrm.Backend.DTO.Request.MemberRequestDto;
import com.cruxcrm.Backend.DTO.Response.MemberResponseDto;

import java.util.List;

public interface MemberService {
    MemberResponseDto addMember(MemberRequestDto memberDto);
    List<MemberResponseDto> getMembers();
}
