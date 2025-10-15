package test.szamlazz.hu.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.szamlazz.hu.persistence.entity.UsrEntity;

public interface UsrRepository extends JpaRepository<UsrEntity, Long> {

}
