package test.szamlazz.hu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import test.szamlazz.hu.api.dto.Usr;
import test.szamlazz.hu.api.dto.UsrCreate;
import test.szamlazz.hu.api.dto.UsrPut;
import test.szamlazz.hu.api.interfaces.UsersApi;
import test.szamlazz.hu.service.UserService;

@RestController
@RequiredArgsConstructor
public class UsersApiImpl implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<List<Usr>> _usersGet(@Min(1) @Max(200) @Valid Integer limit, @Min(0) @Valid Integer offset) {
        List<Usr> users = userService.getUsers(limit, offset);
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<Void> _usersIdDelete(@Min(1) Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Usr> _usersIdGet(@Min(1) Long id) {
        Usr usr = userService.getUserById(id);
        return ResponseEntity.ok(usr);
    }

    @Override
    public ResponseEntity<Usr> _usersIdPut(@Min(1) Long id, @Valid UsrPut usrPut) {
        Usr usr = userService.updateUser(id, usrPut);
        return ResponseEntity.ok(usr);
    }

    @Override
    public ResponseEntity<Usr> _usersPost(@Valid UsrCreate usrCreate) {
        Usr usr = userService.createNewUser(usrCreate);
        return ResponseEntity.ok(usr);
    }

}
