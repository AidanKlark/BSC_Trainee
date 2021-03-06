package com.example.todo.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private Boolean completed;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @NotNull
    private AccountEntity account;

    public TaskEntity(TaskDescription taskDescription, Boolean completed, AccountEntity account) {
        this.description = taskDescription.getTaskDescription();
        this.completed = completed;
        this.account = account;
    }
}
