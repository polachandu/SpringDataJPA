package com.example.SpringDataJPA.API.dao;

import com.example.SpringDataJPA.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByProfession(String profession);

    public long countByAge(int age);

    public List<User> deleteByName(String name);

    public List<User> findByProfessionAndAge(String profession, int age);

    //made it case in-sensitive
    public List<User> findByProfessionIgnoreCase(String profession);

    @Query("SELECT u FROM User u")
    public List<User> getUsersCustomQuery();
}
