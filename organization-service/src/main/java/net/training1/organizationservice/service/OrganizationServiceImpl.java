package net.training1.organizationservice.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.training1.organizationservice.dto.OrganizationDto;
import net.training1.organizationservice.entity.Organization;
import net.training1.organizationservice.mapper.OrganizationMapper;
import net.training1.organizationservice.repository.OrganizationRepository;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

	private OrganizationRepository organizationRepository;

	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		// convert OrganizationDto into Organization jpa entity
		Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

		Organization savedOrganization = organizationRepository.save(organization);

		return OrganizationMapper.mapToOrganizationDto(savedOrganization);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {
		Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
		return OrganizationMapper.mapToOrganizationDto(organization);
	}

}
