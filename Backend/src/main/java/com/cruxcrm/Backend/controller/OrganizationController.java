package com.cruxcrm.Backend.controller;

import com.cruxcrm.Backend.DTO.Request.OrganizationRequestDto;
import com.cruxcrm.Backend.DTO.Response.OrganizationResponseDto;
import com.cruxcrm.Backend.model.Organization;
import com.cruxcrm.Backend.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganizationController {

    @Autowired
    private OrganizationService orgService;

    @GetMapping("/")
    public String greet() {
        return "Welcome to Spring";
    }

    @PostMapping("/org")
    public ResponseEntity<OrganizationResponseDto> addOrg(@RequestBody OrganizationRequestDto orgDto) {
        return new ResponseEntity<>(orgService.addOrg(orgDto), HttpStatus.OK);
    }

    @GetMapping("/org")
    public ResponseEntity<List<OrganizationResponseDto>> getOrgs() {
        return new ResponseEntity<>(orgService.getOrgs(), HttpStatus.OK);
    }
}
