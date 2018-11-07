package ro.eGov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.eGov.dto.UserLogDTO;
import ro.eGov.entities.Log;

@Repository
public interface LogRepository extends JpaRepository<Log,Long> {
}
