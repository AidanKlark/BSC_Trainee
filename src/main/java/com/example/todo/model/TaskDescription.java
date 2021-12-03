package com.example.todo.model;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TaskDescription {

    @NotNull
    @NotBlank
    private String taskDescription;
}
