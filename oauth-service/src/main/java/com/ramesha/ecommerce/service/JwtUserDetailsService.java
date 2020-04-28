package com.ramesha.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ramesha.ecommerce.dao.UserDao;
import com.ramesha.ecommerce.model.DAOUser;
import com.ramesha.ecommerce.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setFname(user.getFname());
        newUser.setLname(user.getLname());
        newUser.setImageUrl(user.getImageUrl());
        return userDao.save(newUser);
    }

    public String updateUser(DAOUser newUserData) {
        String msg = null;
        if (newUserData.getUsername() != null) {

            userDao.save(newUserData);
            msg = "Data Updated";
            return msg;
        } else {
            msg = "Error";
            return msg;
        }
    }

    public List<DAOUser> findByID(String username) {
        return userDao.findAllByUsername(username);
    }
}
