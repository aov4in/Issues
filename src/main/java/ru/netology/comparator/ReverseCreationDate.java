package ru.netology.comparator;

import ru.netology.domain.Issue;

import java.util.Comparator;

public class ReverseCreationDate implements Comparator<Issue> {
    @Override
    public int compare(Issue o1, Issue o2) {
        return o2.getDate().compareTo(o1.getDate());
    }
}
