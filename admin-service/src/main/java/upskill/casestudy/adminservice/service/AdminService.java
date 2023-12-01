package upskill.casestudy.adminservice.service;

import upskill.casestudy.adminservice.dto.APIResponseDto;
import upskill.casestudy.adminservice.dto.AdminDto;
import upskill.casestudy.adminservice.dto.MentorDto;

import java.util.List;

public interface AdminService {


    public AdminDto createAdmin(AdminDto adminDto);

    public AdminDto getAdminByID(Long adminId);

    public List<AdminDto> getAllAdmins();

    public AdminDto updateAdmin(AdminDto adminDto);

    public String deleteAdmin(Long adminId);

    public List<MentorDto> getAllMentors();
}


