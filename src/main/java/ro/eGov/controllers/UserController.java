package ro.eGov.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.eGov.dto.UserAuthDTO;
import ro.eGov.dto.UserDTO;
import ro.eGov.dto.UserLogDTO;
import ro.eGov.entities.Log;
import ro.eGov.repositories.LogRepository;
import ro.eGov.service.LogService;
import ro.eGov.service.UserService;
import ro.eGov.entities.User;

import java.util.List;

@RestController
//toate requesturile api/user ajung aici

@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    LogService logService;

    @PostMapping(value="/auth")
    @CrossOrigin
    public UserDTO authUser(@RequestBody UserAuthDTO userAuthDTO){
        System.out.println("Check auth user...");
        System.out.println(userService.verifyUser(userAuthDTO.getEmail(),userAuthDTO.getPassword()));
        return userService.verifyUser(userAuthDTO.getEmail(),userAuthDTO.getPassword());
    }

    @PostMapping(value="/xml")
    @CrossOrigin
    public UserLogDTO postXML(@RequestBody UserLogDTO userLogDTO) {
        System.out.println(userLogDTO.getNume());
        System.out.println(userLogDTO.getPrenume());
        System.out.println(userLogDTO.getEmail());
        System.out.println(userLogDTO.getJudet());
        System.out.println(userLogDTO.getValoare());
        userService.createXML(userLogDTO);

        logService.insertLog(userLogDTO.getNume(), userLogDTO.getPrenume(), userLogDTO.getEmail(), userLogDTO.getJudet(), userLogDTO.getValoare());

        return userLogDTO;
    }

    @RequestMapping("/all")
    public List<User> getUsers(){
        return userService.findUsers();
    }
}
