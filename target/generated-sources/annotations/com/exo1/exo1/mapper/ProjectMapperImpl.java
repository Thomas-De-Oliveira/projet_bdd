package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjectDTO;
import com.exo1.exo1.dto.TaskDTO;
import com.exo1.exo1.dto.UserDTO;
import com.exo1.exo1.entities.Project;
import com.exo1.exo1.entities.Task;
import com.exo1.exo1.entities.User;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T16:34:03+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class ProjectMapperImpl implements ProjectMapper {

    private final UserMapper userMapper = UserMapper.INSTANCE;
    private final TaskMapper taskMapper = TaskMapper.INSTANCE;

    @Override
    public ProjectDTO toProjectDTO(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDTO projectDTO = new ProjectDTO();

        projectDTO.setId( project.getId() );
        projectDTO.setTitle( project.getTitle() );
        projectDTO.setDescription( project.getDescription() );
        projectDTO.setUsers( userSetToUserDTOList( project.getUsers() ) );
        projectDTO.setTasks( taskSetToTaskDTOList( project.getTasks() ) );

        return projectDTO;
    }

    @Override
    public Project toProjectEntity(ProjectDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( dto.getId() );
        project.setTitle( dto.getTitle() );
        project.setDescription( dto.getDescription() );
        project.setUsers( userDTOListToUserSet( dto.getUsers() ) );
        project.setTasks( taskDTOListToTaskSet( dto.getTasks() ) );

        return project;
    }

    protected List<UserDTO> userSetToUserDTOList(Set<User> set) {
        if ( set == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( set.size() );
        for ( User user : set ) {
            list.add( userMapper.toUserDTO( user ) );
        }

        return list;
    }

    protected List<TaskDTO> taskSetToTaskDTOList(Set<Task> set) {
        if ( set == null ) {
            return null;
        }

        List<TaskDTO> list = new ArrayList<TaskDTO>( set.size() );
        for ( Task task : set ) {
            list.add( taskMapper.toTaskDTO( task ) );
        }

        return list;
    }

    protected Set<User> userDTOListToUserSet(List<UserDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<User> set = new LinkedHashSet<User>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( UserDTO userDTO : list ) {
            set.add( userMapper.toUserEntity( userDTO ) );
        }

        return set;
    }

    protected Set<Task> taskDTOListToTaskSet(List<TaskDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Task> set = new LinkedHashSet<Task>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( TaskDTO taskDTO : list ) {
            set.add( taskMapper.toTaskEntity( taskDTO ) );
        }

        return set;
    }
}
