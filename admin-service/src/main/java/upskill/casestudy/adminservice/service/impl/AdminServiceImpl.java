package upskill.casestudy.adminservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import upskill.casestudy.adminservice.dto.APIResponseDto;
import upskill.casestudy.adminservice.dto.AdminDto;
import upskill.casestudy.adminservice.dto.MentorDto;
import upskill.casestudy.adminservice.entity.Admin;
import upskill.casestudy.adminservice.exception.EmailAlreadyExistException;
import upskill.casestudy.adminservice.exception.ResourceNotFoundException;
import upskill.casestudy.adminservice.mapper.AdminMapper;
import upskill.casestudy.adminservice.repository.AdminRepository;
import upskill.casestudy.adminservice.service.AdminService;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    private WebClient webClient;

    private AdminRepository adminRepository;

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Optional<Admin> optionalAdmin = adminRepository.findByEmail(adminDto.getEmail());
        if (optionalAdmin.isPresent()) {
            throw new EmailAlreadyExistException("Email Already Exists for Admin");
        }
        Admin admin = AdminMapper.mapToAdmin(adminDto);
        Admin savedAdmin = adminRepository.save(admin);
        AdminDto savedAdminDto = AdminMapper.mapToAdminDto(savedAdmin);
        return savedAdminDto;
    }

    @Override
    public AdminDto getAdminByID(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
    .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminId));
       AdminDto adminDto= AdminMapper.mapToAdminDto(admin);
        return adminDto;

    }

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDafaultCourse")
//    @Override
//    public APIResponseDto getAdminByID(Long id) {
//        Admin admin = adminRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
//        AdminDto courseDto = webClient.get()
//                .uri("http://localhost:8081/api/course/" + admin.getCourseCode())
//                .retrieve()
//                .bodyToMono(AdminDto.class)
//                .block();
//        AdminDto adminDto = AdminMapper.mapToAdminDto(admin);
//        APIResponseDto apiResponseDto = new APIResponseDto();
//        apiResponseDto.setCourse(courseDto);
//        apiResponseDto.setAdmin(adminDto);
//        return apiResponseDto;
//    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<Admin> admin = adminRepository.findAll();
        return admin.stream().map(AdminMapper::mapToAdminDto).collect(Collectors.toList());
    }

    @Override
    public AdminDto updateAdmin(AdminDto adminDto) {

        Admin admin = adminRepository.findById(adminDto.getAdminId())
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminDto.getAdminId()));
        admin.setAdminName(adminDto.getAdminName());
        admin.setEmail(adminDto.getEmail());
        Admin updatedAdmin = adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(updatedAdmin);
    }

    @Override
    public String deleteAdmin(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminId));
        adminRepository.deleteById(adminId);
        return "Deleted Successfully!!";

    }

	@Override
	public List<MentorDto> getAllMentors() {
		// TODO Auto-generated method stub
		return null;
	}


//    public APIResponseDto getDafaultCourse(Long id, Exception exception) {
//        LOGGER.info("inside getDafaultCourse() method");
//        Admin admin = adminRepository.findById(id).get();
//
//        AdminDto courseDto = new AdminDto();
//        courseDto.setAdminName("Cloud");
//        courseDto.setStartDate(LocalDate.of(2024, 01, 03));
//        courseDto.setEndDate(LocalDate.of(2024, 05, 23));
//        courseDto.setCourseCode("CL01");
//
//        AdminDto adminDto = AdminMapper.mapToAdminDto(admin);
//
//        APIResponseDto apiResponseDto = new APIResponseDto();
//        apiResponseDto.setCourse(courseDto);
//        apiResponseDto.setAdmin(adminDto);
//
//        return apiResponseDto;
//    }
}
