package com.alimama.mealgpt.dao;

import com.alimama.mealgpt.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {
    Authorities findAuthoritiesByUserName(String userName);
}
