package com.ekklc101.cheesemvc.models.data;

import com.ekklc101.cheesemvc.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
//import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ekk on 13-Jun-17.
 */

@Repository
@Transactional
public interface CheeseDao extends CrudRepository<Cheese, Integer> {
}
