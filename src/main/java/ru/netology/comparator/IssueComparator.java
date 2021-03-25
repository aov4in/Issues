package ru.netology.comparator;

import ru.netology.domain.Issue;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class IssueComparator<date2> implements Comparator<Issue> {

    @Override
    public int compare(Issue o1, Issue o2) {
        return Integer.compare(o1.getId(), o2.getId());

    }
}