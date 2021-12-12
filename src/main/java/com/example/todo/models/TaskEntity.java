package com.example.todo.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private Boolean completed;

    public TaskEntity(TaskDescription taskDescription, Boolean completed) {
        this.description = taskDescription.getTaskDescription();
        this.completed = completed;
    }
}
