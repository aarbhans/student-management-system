package com.example.instructor.mapper;

import com.example.instructor.dto.request.InstructorRequest;
import com.example.instructor.dto.response.InstructorResponse;
import com.example.instructor.model.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    Instructor toEntity(InstructorRequest request);
    InstructorResponse toResponse(Instructor instructor);
    void updateFromRequest(InstructorRequest request,
                           @MappingTarget Instructor entity);
}
