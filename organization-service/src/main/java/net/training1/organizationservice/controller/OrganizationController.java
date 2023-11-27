package net.training1.organizationservice.controller;

import lombok.AllArgsConstructor;
import net.training1.organizationservice.dto.OrganizationDto;
import net.training1.organizationservice.service.OrganizationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Organization Service", description = "Organization Service CRUD APIs")
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

	private OrganizationService organizationService;

	// Build Save Organization REST API
	@Operation(summary = "Organization-Service POST API", description = "POST API to add/create/save organization")
	@ApiResponse(responseCode = "201", description = "Shows 201 CREATED Response code")
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
		OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
	}

	// Build Get Organization by Code REST API
	@Operation(summary = "Organization-Service GET API", description = "GET API to get organization by organization-code")
	@ApiResponse(responseCode = "200", description = "Shows 200 OK Response code")
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode) {
		OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
		return ResponseEntity.ok(organizationDto);
	}

}
