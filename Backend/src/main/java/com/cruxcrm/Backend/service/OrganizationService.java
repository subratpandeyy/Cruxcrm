package com.cruxcrm.Backend.service;

import com.cruxcrm.Backend.DTO.Request.OrganizationRequestDto;
import com.cruxcrm.Backend.DTO.Response.OrganizationResponseDto;

import java.util.List;

public interface OrganizationService {
    OrganizationResponseDto addOrg(OrganizationRequestDto orgDto);
    List<OrganizationResponseDto> getOrgs();
}
