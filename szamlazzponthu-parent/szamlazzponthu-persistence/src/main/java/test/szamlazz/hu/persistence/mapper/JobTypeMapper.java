package test.szamlazz.hu.persistence.mapper;

import org.springframework.stereotype.Component;

import test.szamlazz.hu.api.dto.JobType;
import test.szamlazz.hu.persistence.entity.JobTypeEntity;

@Component
public class JobTypeMapper {

    public JobType toDto(JobTypeEntity e) {
        JobType dto = new JobType();
        dto.setCode(e.getCode());
        dto.setLabelHu(e.getLabelHu());
        dto.setLabelEn(e.getLabelEn());
        return dto;
    }

}
