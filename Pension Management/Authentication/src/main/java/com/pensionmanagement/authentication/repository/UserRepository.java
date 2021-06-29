package com.pensionmanagement.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pensionmanagement.authentication.model.UserLoginCredential;

@Repository
public interface UserRepository extends JpaRepository<UserLoginCredential, String> {

}
