package com.company.signupform.Services;

import com.company.signupform.Model.User;
import com.company.signupform.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormServices {
    @Autowired
    private FormRepository formRepository;
    List<User> users=new ArrayList<>();
    public List<User> getAllUsers()
    {
        formRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User addUser( User user)
    {
        formRepository.save(user);
        return user;
    }


    public Optional<User> getUsersInfo(String email)
    {
        return formRepository.findById(email);
    }

    public Optional<User> editUser(User user, String email)
    {
        formRepository.deleteById(email);
        formRepository.save(user);

        return formRepository.findById(email);
    }

    public void deleteUser(String email)
    {
        formRepository.deleteById(email);
    }

    public void deleteAllUser() {
        formRepository.deleteAll();
    }
}
