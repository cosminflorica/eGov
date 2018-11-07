package ro.eGov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.eGov.dto.UserLogDTO;
import ro.eGov.entities.Log;
import ro.eGov.repositories.LogRepository;

@Service
public class LogService {
    private static Long id = Long.valueOf(1);
    private final LogRepository logRepository;
    @Autowired
    public LogService(LogRepository logRepository){this.logRepository=logRepository;}
    public Boolean insertLog(String nume, String prenume, String email, String judet, String valoare){

        Log log= new Log(id++, nume, prenume, email, judet, Long.parseLong(valoare));

        logRepository.save(log);
        return true;
    }

}
