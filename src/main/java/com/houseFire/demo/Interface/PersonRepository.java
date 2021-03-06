/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.houseFire.demo.Interface;

import com.houseFire.demo.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author admin
 */

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    Boolean existsByEmail(String email);
    PersonEntity findPersonByEmail(String email);
}
