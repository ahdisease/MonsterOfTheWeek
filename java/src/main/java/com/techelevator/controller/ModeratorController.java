package com.techelevator.controller;

import com.techelevator.dao.CharacterImageDao;
import com.techelevator.dao.ModeratorDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.CharacterImage;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;


@CrossOrigin
@RestController
@PreAuthorize("hasAnyRole('ADMIN', 'MOD')")
public class ModeratorController {

    @Autowired
    private ModeratorDao modDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CharacterImageDao imageDao;


    //moderator services
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/moderator/characters/{id}", method = RequestMethod.DELETE)
    public void deleteCharacterById(@PathVariable int id) {
        if(!modDao.deleteCharacterById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/moderator/ban/{id}", method = RequestMethod.PUT)
    public void banUser(@PathVariable int id) {
        if(!modDao.banUser(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/moderator/review/{id}", method = RequestMethod.PUT)
    public void reviewFlaggedCharacter(@PathVariable int id) {
        if(!modDao.reviewFlaggedCharacter(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/moderator/users/", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/moderator/images/", method = RequestMethod.GET)
    public List<CharacterImage> getUnapprovedImages() {
        return imageDao.getUnapprovedImages();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/moderator/images/{id}", method = RequestMethod.PUT)
    public void approveImage(@PathVariable int id) {
        if(!imageDao.approveImage(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }




}
