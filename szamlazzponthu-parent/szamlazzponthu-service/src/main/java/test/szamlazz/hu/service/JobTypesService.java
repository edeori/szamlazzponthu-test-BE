package test.szamlazz.hu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import test.szamlazz.hu.api.dto.JobType;
import test.szamlazz.hu.persistence.mapper.JobTypeMapper;
import test.szamlazz.hu.persistence.repository.JobTypeRepository;

@Service
@RequiredArgsConstructor
public class JobTypesService {

    private final JobTypeRepository jobTypeRepository;
    private final JobTypeMapper jobTypeMapper;

    public List<JobType> getJobs() {
        return jobTypeRepository.findAll().stream().map(jobTypeMapper::toDto).toList();
    }

}
