package test.szamlazz.hu.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.szamlazz.hu.persistence.entity.JobTypeEntity;

public interface JobTypeRepository extends JpaRepository<JobTypeEntity, String> {

}
