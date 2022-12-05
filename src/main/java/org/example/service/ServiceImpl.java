package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.example.exeption.MyException;
import org.example.model.User;
import org.example.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Log
@Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceUser {
    private final Repository repository;

    @Override
    public User addUser(User user) {
        User saveUser = repository.saveAndFlush(user);
        log.info("Пользователь добавлен и сохранен в БД");
        return saveUser;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
        log.info("Пользователь с id: " + id + " удален");
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
        log.info("Все пользователи удалены");
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) throws MyException {
        return repository.findById(id).orElseThrow(() -> new MyException("Пользователь с id: " + id + " не найден"));
    }

    @Override
    public User updateUser(User user) {
        User updateUser = repository.saveAndFlush(user);
        return updateUser;
    }
}
