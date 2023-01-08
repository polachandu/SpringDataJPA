package com.example.SpringDataJPA.API.controller;

import com.example.SpringDataJPA.API.model.User;
import com.example.SpringDataJPA.API.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/findByProfession/{profession}")
    public List<User> getAllByProfession(@PathVariable String profession){
        return userService.getUserByProfession(profession);
    }

    @GetMapping("/getUserCount/{age}")
    public long getCountByAge(@PathVariable int age){
        long count = userService.getCountByAge(age);
        return count;
    }

    @DeleteMapping("/deleteUserByName/{name}")
    public List<User> deleteUserByName(@PathVariable String name){
        return userService.deleteUserByName(name);
    }

    @GetMapping("/getUsersByProfessionAndAge/{profession}/{age}")
    public List<User> findByMultiCondition(@PathVariable String profession,@PathVariable int age){
        return userService.getUserByProfessionAndAge(profession,age);
    }

    //pathvariable
    @GetMapping("/getUserByProfessionByIgnoreCase/{profession}")
    public List<User> getUsersByProfessionIgnoreCasePathVariable(@PathVariable String profession){
        return userService.getUserIgnoreCase(profession);
    }

    //requestparam
    @GetMapping("/getUserByProfessionByIgnoreCase")
    public List<User> getUsersByProfessionIgnoreCaseRequestParam(@RequestParam("profession") String profession){
        return userService.getUserIgnoreCase(profession);
    }

    @GetMapping("/getUserBySort/{field}")
    public List<User> getUserBySort(@PathVariable String field){
        return userService.getUserSort(field);
    }

    @GetMapping("/getPaginatedRecords")
    public Page<User> getPaginatedRecords(){
        return userService.getPaginatedUser();
    }

    @GetMapping("/getUsersByCustomQuery")
    public List<User> getUserByCustomQuery(){
        return userService.getUsersCustomQuery();
    }


}
