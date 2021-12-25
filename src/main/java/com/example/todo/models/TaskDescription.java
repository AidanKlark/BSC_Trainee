package com.example.todo.models;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class TaskDescription {

    @NotBlank
    private String taskDescription;
}
