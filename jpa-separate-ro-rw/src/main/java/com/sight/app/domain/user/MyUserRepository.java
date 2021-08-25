package com.sight.app.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Long>, MyUserRepositoryCustom {

}