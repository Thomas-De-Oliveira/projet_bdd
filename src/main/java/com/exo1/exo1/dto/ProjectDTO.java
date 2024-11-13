package com.exo1.exo1.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class ProjectDTO {
    private Long id;
    private String title;
    private String description;
    private List<UserDTO> users;
    private List<TaskDTO> tasks;
}
