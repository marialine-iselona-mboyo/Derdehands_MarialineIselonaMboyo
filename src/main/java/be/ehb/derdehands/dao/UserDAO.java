package be.ehb.derdehands.dao;

import be.ehb.derdehands.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Integer> {
}
