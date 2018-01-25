/**
 * 
 */
package com.loserbird.blog.thymeleaf.repository;

import com.loserbird.blog.thymeleaf.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
