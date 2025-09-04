package com.cruxcrm.Backend.service;

import com.cruxcrm.Backend.DTO.Request.OrganizationRequestDto;
import com.cruxcrm.Backend.DTO.Response.OrganizationResponseDto;

import java.util.List;

public interface OrganizationService {
    OrganizationResponseDto addOrg(OrganizationRequestDto orgDto);
    List<OrganizationResponseDto> getOrgs();
    OrganizationResponseDto getOrgById(Long id);
    OrganizationResponseDto updateOrg(OrganizationRequestDto orgDto, Long id);
    OrganizationResponseDto deleteOrg(Long id);
}
