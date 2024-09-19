package com.sboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TermsService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TermsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getTerms() {
        String sql = "SELECT terms FROM terms";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    public String getPrivacy() {
        String sql = "SELECT privacy FROM terms";
        return jdbcTemplate.queryForObject(sql, String.class);
    }
}
