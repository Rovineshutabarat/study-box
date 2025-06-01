package com.study.box.server.repositories;

import com.study.box.server.models.entity.OneTimePassword;
import com.study.box.server.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OneTimePasswordRepository extends JpaRepository<OneTimePassword, Integer> {
    Optional<OneTimePassword> findByCode(String code);

    Optional<OneTimePassword> findByUser(User user);
}
