package ru.netology.manager;

import ru.netology.domain.Assignee;
import ru.netology.domain.Author;
import ru.netology.domain.Issues;
import ru.netology.domain.Label;
import ru.netology.repository.IssuesRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class IssuesManager {
    private IssuesRepository repository;

    public IssuesManager() {
    }

    public IssuesManager(IssuesRepository repository) {
        this.repository = repository;
    }

    public void add(Issues issue) {
        repository.add(issue);
    }

    public List<Issues> getAll() {
        return repository.getAll();
    }

    public List<Issues> filterAuthor(Author author) {
        List<Issues> issues = repository.getAll();
        Predicate<Issues> predicate = obj -> (obj.getAssignee()).contains(author);
        List<Issues> result = new ArrayList<>();
        for (Issues issue : repository.getAll()) {
            if (predicate.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issues> filterLabel(Label label) {
        List<Issues> issues = repository.getAll();
        Predicate<Issues> predicate = obj -> (obj.getLabel()).contains(label);
        List<Issues> result = new ArrayList<>();
        for (Issues issue : repository.getAll()) {
            if (predicate.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issues> filterAssignee(Author author) {
        List<Issues> issues = repository.getAll();
        Predicate<Issues> predicate = obj -> (obj.getAssignee()).contains(author);
        List<Issues> result = new ArrayList<>();
        for (Issues issue : repository.getAll()) {
            if (predicate.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

}
