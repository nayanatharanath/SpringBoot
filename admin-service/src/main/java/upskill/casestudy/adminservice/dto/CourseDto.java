package upskill.casestudy.adminservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Schema(
        description = "CourseDto model information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Long courseId;

    @Schema(
            description = "Course Name"
    )
    @NotEmpty(message = "Course Name should not be null or empty ")
    private String courseName;

    @Schema(
            description = "startDate"
    )
    @NotEmpty(message = "Start Date should not be null or empty ")
    private LocalDate startDate;

    @Schema(
            description = "End Date"
    )
    @NotEmpty(message = "End Date should not be null or empty ")
    private LocalDate endDate;

    @Schema(
            description = "Course Code"
    )
    @NotEmpty(message = "Course Code should not be null or empty ")
    private String courseCode;
}
