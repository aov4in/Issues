package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issues {
        private int id;
        private String author;
        private Set<Label>label;
        private String projects;
        private String milestones;
        private Set<Author>assignee;
        private String date;
        private boolean isOpen;
        private boolean isClosed;
        private boolean status;

}
