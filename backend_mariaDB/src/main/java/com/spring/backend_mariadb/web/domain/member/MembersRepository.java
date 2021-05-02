package com.spring.backend_mariadb.web.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembersRepository extends JpaRepository<Members, Long> {
    List<Members> findByIdAndPw(String id, String pw);
}
