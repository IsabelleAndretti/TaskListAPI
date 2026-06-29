package com.br.isa.TaskListProj.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TaskEntity {
    private int id;
    private String name;
    private String description;
    private String category;
    private String dayOfWeek;
    private String status;
}

