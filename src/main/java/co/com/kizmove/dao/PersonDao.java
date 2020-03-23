package co.com.kizmove.dao;

import co.com.kizmove.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Long> {
}
