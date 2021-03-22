package ru.netology.repository;

import ru.netology.domain.Issues;

import java.util.ArrayList;
import java.util.List;

public class IssuesRepository {
    private List<Issues> issues = new ArrayList<>();

    public void add(Issues item) {
        issues.add(item);
    }

    public List<Issues> findAll() {
        return issues;
    }

    public List<Issues> getAll() {
        return issues;
    }

    public List<Issues> findOpen(List<Issues> issues) {
        List<Issues> result = new ArrayList<>();
        for (Issues issue : issues) {
            if (issue.isStatus() == true) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issues> findClose(List<Issues> issues) {
        List<Issues> result = new ArrayList<>();
        for (Issues issue : issues) {
            if (issue.isStatus() == false) {
                result.add(issue);
            }
        }
        return result;
    }

    public void openById(List<Issues> issues, int id) {
        for (Issues issue : issues) {
            if (issue.getId() == id) {
                issue.setStatus(true);
            }
        }
    }

    public void closeById(List<Issues> issues, int id) {
        for (Issues issue : issues) {
            if (issue.getId() == id) {
                issue.setStatus(false);
            }
        }
    }

}
