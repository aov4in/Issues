package ru.netology.manager;

import ru.netology.comparator.CreationDate;
import ru.netology.comparator.IssueComparator;
import ru.netology.domain.Author;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssuesRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class IssuesManager<ComparatorByCreationDate> {
    private IssuesRepository repository;

    public IssuesManager(IssuesRepository repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.add(issue);
    }

    public List<Issue> getAll() {
        return repository.getAll();
    }

    public List<Issue> filterAuthor(Author author) {
        List<Issue> issues = repository.getAll();
        Predicate<Issue> predicate = obj -> (obj.getAssignee()).contains(author);
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (predicate.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> filterLabel(Label label) {
        List<Issue> issues = repository.getAll();
        Predicate<Issue> predicate = obj -> (obj.getLabel()).contains(label);
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (predicate.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> filterAssignee(Author author) {
        List<Issue> issues = repository.getAll();
        Predicate<Issue> predicate = obj -> (obj.getAssignee()).contains(author);
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (predicate.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

}
