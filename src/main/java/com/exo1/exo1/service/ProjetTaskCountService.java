package com.exo1.exo1.service;

import com.exo1.exo1.dto.ProjetTaskCountDto;
import com.exo1.exo1.entity.ProjetTaskCount;
import com.exo1.exo1.mapper.ProjetTaskCountMapper;
import com.exo1.exo1.repository.ProjetTaskCountRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetTaskCountService {

    private ProjetTaskCountRepository projetTaskCountRepository;
    private ProjetTaskCountMapper projetTaskCountMapper;
    private JdbcTemplate jdbcTemplate;


    public List<ProjetTaskCountDto> findAll() { return projetTaskCountMapper.toDtos(projetTaskCountRepository.findAll());}

    public void refreshMaterializedView() {
        jdbcTemplate.execute("REFRESH MATERIALIZED VIEW projet_task_count");
    }
}
