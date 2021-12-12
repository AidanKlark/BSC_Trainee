package com.example.todo.repository;

import com.example.todo.models.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Modifying
    @Query(value = "UPDATE TaskEntity t SET t.completed =" +
            " (case t.completed when false then true else false end) WHERE t.id = ?1")
    void toggleTask(Long id);

    @Modifying
    @Query(value = "UPDATE TaskEntity t SET t.description = ?2 WHERE t.id = ?1")
    void editTask(Long id, String newTask);

    @Query(value = "SELECT t FROM TaskEntity t WHERE (:all = true OR t.completed = :all) AND " +
            "((:substring = '') OR t.description LIKE %:substring%)")
    List<TaskEntity> getTasks(@Param("all") Boolean all, @Param("substring") String substring);
}
