package test.szamlazz.hu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import test.szamlazz.hu.api.dto.JobType;
import test.szamlazz.hu.api.interfaces.JobTypesApi;
import test.szamlazz.hu.service.JobTypesService;

@RestController
@RequiredArgsConstructor
public class JobTypesApiImpl implements JobTypesApi {

    private final JobTypesService jobTypesService;

    @Override
    public ResponseEntity<List<JobType>> _jobTypesGet() {
        List<JobType> jobs = jobTypesService.getJobs();
        return ResponseEntity.ok(jobs);
    }

}
