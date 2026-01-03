package com.example.instructor.service;


import com.example.instructor.dto.request.InstructorRequest;
import com.example.instructor.dto.response.InstructorResponse;
import com.example.instructor.mapper.InstructorMapper;
import com.example.instructor.model.Instructor;
import com.example.instructor.repository.InstructorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository repository;
    private InstructorMapper mapper;

    public InstructorService(InstructorRepository repository, InstructorMapper mapper) {
        this.repository = repository;
    }

    public InstructorResponse createInstructor(InstructorRequest request) {
        Instructor instructor = mapper.toEntity(request);
        Instructor saved = repository.save(instructor);
        return mapper.toResponse(saved);
    }

    public List<InstructorResponse> getInstructor() {
        List<Instructor> fetchedInstructors = repository.findAll();
        return fetchedInstructors.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public InstructorResponse getInstructorById(Long id) {
        Instructor fetchedInstructor = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find instructor with id: " + id));
        return mapper.toResponse(fetchedInstructor);
    }

    @Transactional
    public void updateInstructor(Long id, InstructorRequest request) {
        Instructor fetchedInstructor = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find instructor with id: " + id));

        mapper.updateFromRequest(request, fetchedInstructor);
    }

    @Transactional
    public void deleteInstructor(Long id) {
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("Cannot find instructor with id: " + id);
        }
        repository.deleteById(id);
    }

}
