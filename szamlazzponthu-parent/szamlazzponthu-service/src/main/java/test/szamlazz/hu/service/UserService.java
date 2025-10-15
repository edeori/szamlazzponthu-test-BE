package test.szamlazz.hu.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import test.szamlazz.hu.api.dto.Usr;
import test.szamlazz.hu.api.dto.UsrCreate;
import test.szamlazz.hu.api.dto.UsrPut;
import test.szamlazz.hu.persistence.entity.UsrEntity;
import test.szamlazz.hu.persistence.mapper.UsrMapper;
import test.szamlazz.hu.persistence.repository.UsrRepository;
import test.szamlazz.hu.service.exception.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsrRepository usrRepository;
    private final UsrMapper usrMapper;

    public List<Usr> getUsers(Integer limit, Integer offset) {
        int pageSize = (limit == null || limit <= 0) ? 50 : limit;
        int pageIndex = (offset == null || offset < 0) ? 0 : offset / pageSize;

        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        return usrRepository.findAll(pageable)
                .stream()
                .map(usrMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteUserById(Long id) {
        usrRepository.deleteById(id);
    }

    public Usr getUserById(Long id) {
        usrRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return usrMapper.toDto(usrRepository.findById(id).get());
    }

    public Usr createNewUser(UsrCreate usrCreate) {
        UsrEntity created = usrRepository.save(usrMapper.toEntity(usrCreate));

        return usrMapper.toDto(created);
    }

    public Usr updateUser(Long id, UsrPut usrPut) {
        var existing = usrRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));

        existing.setFirstname(usrPut.getFirstname());
        existing.setLastname(usrPut.getLastname());
        existing.setAddress(usrPut.getAddress());
        existing.setTelephone(usrPut.getTelephone());
        existing.setActive(usrPut.getActive());
        existing.setJob(usrPut.getJob());

        var saved = usrRepository.save(existing);
        return usrMapper.toDto(saved);
    }

}
