package upskill.casestudy.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upskill.casestudy.adminservice.entity.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByEmail(String email);
}
