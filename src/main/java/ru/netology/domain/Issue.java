package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue implements Comparable<Issue>{
        private int id;
        private String author;
        private Set<Label>label;
        private String projects;
        private String milestones;
        private Set<Author>assignee;
        private Calendar date;
        private boolean isOpen;
        private boolean isClosed;
        private boolean status;

    public static Calendar setDate(int year, int month, int day) {
        Calendar setCalendar1 = new GregorianCalendar();
        setCalendar1.set(year, month, day);
        return setCalendar1;
    }

    @Override
    public int compareTo(Issue o) {
        return id - o.id;
    }

}
