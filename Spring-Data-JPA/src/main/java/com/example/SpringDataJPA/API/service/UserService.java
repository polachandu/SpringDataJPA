package com.example.SpringDataJPA.API.service;

import com.example.SpringDataJPA.API.dao.UserRepository;
import com.example.SpringDataJPA.API.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initDB(){
        List<User> users = new ArrayList<>();
        users.add(new User(111,"Chandu","IT",23));
        users.add(new User(123,"Teja","UPSC",28));
        users.add(new User(134,"Ramesh","MBA",32));
        users.add(new User(143,"Arjun","CIVIL", 45));
        userRepository.saveAll(users);

    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<User> getUserByProfession(String profession){
        return userRepository.findByProfession(profession);
    }

    public long getCountByAge(int age){
        return userRepository.countByAge(age);
    }

    public List<User> deleteUserByName(String name){
        return userRepository.deleteByName(name);
    }

    public List<User> getUserByProfessionAndAge(String profession, int age){
        return userRepository.findByProfessionAndAge(profession,age);
    }

    public List<User> findByMultiCondition(String profession, int age){
        return userRepository.findByProfessionAndAge(profession, age);
    }

    public List<User> getUserIgnoreCase(String profession){
        return userRepository.findByProfessionIgnoreCase(profession);
    }

    public List<User> getUserSort(String field){
        return userRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    public Page<User> getPaginatedUser(){
        return userRepository.findAll(PageRequest.of(0, 3));
    }


    public List<User> getUsersCustomQuery(){
        return userRepository.getUsersCustomQuery();
    }

}
