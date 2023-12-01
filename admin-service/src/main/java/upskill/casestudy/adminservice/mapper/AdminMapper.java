package upskill.casestudy.adminservice.mapper;

import upskill.casestudy.adminservice.dto.AdminDto;
import upskill.casestudy.adminservice.entity.Admin;

public class AdminMapper {

    //convert JPA Entity to DTO
    public static AdminDto mapToAdminDto(Admin admin) {
        AdminDto AdminDto = new AdminDto(
                admin.getAdminId(),
                admin.getAdminName(),
                admin.getEmail()
        );
        return AdminDto;
    }

    //convert DTO to JPA Entity
    public static Admin mapToAdmin(AdminDto AdminDto) {
        Admin admin = new Admin(
                AdminDto.getAdminId(),
                AdminDto.getAdminName(),
                AdminDto.getEmail()
        );
        return admin;
    }
}

