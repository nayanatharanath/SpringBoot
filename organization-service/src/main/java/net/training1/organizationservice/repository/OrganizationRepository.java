package net.training1.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.training1.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	Organization findByOrganizationCode(String organizationCode);

}
