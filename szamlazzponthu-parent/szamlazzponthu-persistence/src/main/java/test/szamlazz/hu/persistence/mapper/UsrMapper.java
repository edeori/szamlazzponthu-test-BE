package test.szamlazz.hu.persistence.mapper;

import org.springframework.stereotype.Component;

import test.szamlazz.hu.api.dto.Usr;
import test.szamlazz.hu.api.dto.UsrCreate;
import test.szamlazz.hu.persistence.entity.UsrEntity;

@Component
public class UsrMapper {

    public Usr toDto(UsrEntity e) {
        Usr dto = new Usr();
        dto.setId(e.getId());
        dto.setFirstname(e.getFirstname());
        dto.setLastname(e.getLastname());
        dto.setAddress(e.getAddress());
        dto.setTelephone(e.getTelephone());
        dto.setActive(e.isActive());
        dto.setJob(e.getJob());
        return dto;
    }

    public UsrEntity toEntity(UsrCreate usrCreate) {
        UsrEntity entity = new UsrEntity();
        entity.setFirstname(usrCreate.getFirstname());
        entity.setLastname(usrCreate.getLastname());
        entity.setAddress(usrCreate.getAddress());
        entity.setTelephone(usrCreate.getTelephone());
        entity.setActive(usrCreate.getActive());
        entity.setJob(usrCreate.getJob());
        return entity;
    }
}
