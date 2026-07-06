package com.satya.StudentCourseManagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardStatsResponse {
    private long totalStudents;
    private long totalCourses;
    private long totalMaleStudents;
    private long totalFemaleStudents;
}
