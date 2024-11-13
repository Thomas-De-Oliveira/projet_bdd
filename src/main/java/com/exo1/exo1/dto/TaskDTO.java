package com.exo1.exo1.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDTO {
    private Long id;
    private String title;
    private String statue;
    private ProjectDTO project;
    private UserDTO user;
}
