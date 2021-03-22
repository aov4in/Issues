package ru.netology.comparator;

import ru.netology.domain.Issues;

import java.util.Comparator;

public class IssueComparator implements Comparator<Issues> {

        @Override
        public int compare(Issues o1, Issues o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }

}
