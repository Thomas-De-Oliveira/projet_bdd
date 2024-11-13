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
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setProjects( projectSetToProjectDTOList( user.getProjects() ) );

        return userDTO;
    }

    @Override
    public User toUserEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setName( dto.getName() );
        user.setEmail( dto.getEmail() );
        user.setProjects( projectDTOListToProjectSet( dto.getProjects() ) );

        return user;
    }

    protected List<UserDTO> userSetToUserDTOList(Set<User> set) {
        if ( set == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( set.size() );
        for ( User user : set ) {
            list.add( toUserDTO( user ) );
        }

        return list;
    }

    protected TaskDTO taskToTaskDTO(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId( task.getId() );
        taskDTO.setTitle( task.getTitle() );
        taskDTO.setStatue( task.getStatue() );
        taskDTO.setProject( projectToProjectDTO( task.getProject() ) );
        taskDTO.setUser( toUserDTO( task.getUser() ) );

        return taskDTO;
    }

    protected List<TaskDTO> taskSetToTaskDTOList(Set<Task> set) {
        if ( set == null ) {
            return null;
        }

        List<TaskDTO> list = new ArrayList<TaskDTO>( set.size() );
        for ( Task task : set ) {
            list.add( taskToTaskDTO( task ) );
        }

        return list;
    }

    protected ProjectDTO projectToProjectDTO(Project project) {
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

    protected List<ProjectDTO> projectSetToProjectDTOList(Set<Project> set) {
        if ( set == null ) {
            return null;
        }

        List<ProjectDTO> list = new ArrayList<ProjectDTO>( set.size() );
        for ( Project project : set ) {
            list.add( projectToProjectDTO( project ) );
        }

        return list;
    }

    protected Set<User> userDTOListToUserSet(List<UserDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<User> set = new LinkedHashSet<User>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( UserDTO userDTO : list ) {
            set.add( toUserEntity( userDTO ) );
        }

        return set;
    }

    protected Task taskDTOToTask(TaskDTO taskDTO) {
        if ( taskDTO == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskDTO.getId() );
        task.setTitle( taskDTO.getTitle() );
        task.setStatue( taskDTO.getStatue() );
        task.setProject( projectDTOToProject( taskDTO.getProject() ) );
        task.setUser( toUserEntity( taskDTO.getUser() ) );

        return task;
    }

    protected Set<Task> taskDTOListToTaskSet(List<TaskDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Task> set = new LinkedHashSet<Task>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( TaskDTO taskDTO : list ) {
            set.add( taskDTOToTask( taskDTO ) );
        }

        return set;
    }

    protected Project projectDTOToProject(ProjectDTO projectDTO) {
        if ( projectDTO == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDTO.getId() );
        project.setTitle( projectDTO.getTitle() );
        project.setDescription( projectDTO.getDescription() );
        project.setUsers( userDTOListToUserSet( projectDTO.getUsers() ) );
        project.setTasks( taskDTOListToTaskSet( projectDTO.getTasks() ) );

        return project;
    }

    protected Set<Project> projectDTOListToProjectSet(List<ProjectDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Project> set = new LinkedHashSet<Project>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( ProjectDTO projectDTO : list ) {
            set.add( projectDTOToProject( projectDTO ) );
        }

        return set;
    }
}
