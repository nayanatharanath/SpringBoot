package upskill.casestudy.adminservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.casestudy.adminservice.dto.AdminDto;
import upskill.casestudy.adminservice.mapper.AdminMapper;
import upskill.casestudy.adminservice.service.AdminService;


import java.util.List;

@Tag(
        name = "Admin-Controller",
        description = "Admin Controller Exposes REST APIs for Admin-Service")
@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {

    private AdminService adminService;
    @Operation(
            summary = "Save Admin REST API",
            description = "Save Admin REST API is used to save admin object in database"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@RequestBody @Valid AdminDto adminDto) {
        AdminDto savedAdmin = adminService.createAdmin(adminDto);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get admin By ID REST API",
            description = "Get admin By REST API is used to get a admin object from the database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{adminId}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable Long adminId) {
        AdminDto adminDto = adminService.getAdminByID(adminId);
        return new ResponseEntity<>(adminDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get admin By REST API",
            description = "Get admin By REST API is used to get a admin object from the database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping()
    public ResponseEntity<List<AdminDto>> getAllAdmin(){
        List<AdminDto> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @Operation(
            summary = "Put admin By REST API",
            description = "put admin By REST API is used to update a admin object from the database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("{id}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable Long id, @RequestBody @Valid  AdminDto adminDto){
        adminDto.setAdminId(id);
        AdminDto updateAdmin = adminService.updateAdmin(adminDto);
        return new ResponseEntity<AdminDto>(updateAdmin, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete admin By ID REST API",
            description = "Delete admin By REST API is used to delete a admin  from the database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return new ResponseEntity<String>("Admin successfully deleted!!", HttpStatus.OK);
    }
}
