package upskill.casestudy.adminservice.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {

    private AdminDto admin;
    private MentorDto mentor;
//    private CourseDto course;
}

