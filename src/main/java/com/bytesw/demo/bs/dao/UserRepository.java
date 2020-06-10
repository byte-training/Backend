package com.bytesw.demo.bs.dao;

import com.bytesw.demo.bs.eis.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
