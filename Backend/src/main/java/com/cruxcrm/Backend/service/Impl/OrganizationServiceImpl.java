package com.cruxcrm.Backend.service.Impl;

import com.cruxcrm.Backend.DTO.Request.OrganizationRequestDto;
import com.cruxcrm.Backend.DTO.Response.OrganizationResponseDto;
import com.cruxcrm.Backend.model.Organization;
import com.cruxcrm.Backend.repository.OrganizationRepository;
import com.cruxcrm.Backend.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository orgRepo;

    @Override
    public OrganizationResponseDto addOrg(OrganizationRequestDto orgDto) {
        Organization org = new Organization();
        org.setOrgName(orgDto.getOrgName());
        org.setOrgEmail(orgDto.getOrgEmail());

        Organization saved = orgRepo.save(org);
        return mapToResponse(saved);
    }

    @Override
    public OrganizationResponseDto getOrgById(Long id) {
        Organization org = orgRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Organization not found" + id));

        return mapToResponse(org);
    }

    @Override
    public List<OrganizationResponseDto> getOrgs() {
        return orgRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationResponseDto updateOrg(OrganizationRequestDto orgDto, Long id) {
        Organization org = orgRepo.findById(id)
                        .orElseThrow(()-> new RuntimeException("Organization not found" + id));

        org.setOrgName(orgDto.getOrgName());
        org.setOrgEmail(orgDto.getOrgEmail());

        Organization saved = orgRepo.save(org);
        return mapToResponse(saved);
    }

    @Override
    public OrganizationResponseDto deleteOrg(Long id) {
        Organization org = orgRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found" + id));
        orgRepo.delete(org);
        return mapToResponse(org);
    }

    private OrganizationResponseDto mapToResponse(Organization org) {
        OrganizationResponseDto response = new OrganizationResponseDto();
        response.setOrgId(org.getOrgId());
        response.setOrgName(org.getOrgName());
        response.setOrgEmail(org.getOrgEmail());

        return response;
    }

}
