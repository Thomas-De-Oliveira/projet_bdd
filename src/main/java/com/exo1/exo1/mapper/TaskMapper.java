package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.TaskDTO;
import com.exo1.exo1.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "project.id", target = "project.id")
    @Mapping(source = "user.id", target = "user.id")
    TaskDTO toTaskDTO(Task task);

    Task toTaskEntity(TaskDTO dto);
}
