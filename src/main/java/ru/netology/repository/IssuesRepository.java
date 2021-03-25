package ru.netology.repository;

import ru.netology.comparator.CreationDate;
import ru.netology.comparator.IssueComparator;
import ru.netology.comparator.ReverseCreationDate;
import ru.netology.domain.Issue;
import ru.netology.exeption.NotFoundException;

import javax.management.openmbean.CompositeData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IssuesRepository {
    IssuesRepository repository;
    private IssueComparator issueComparator = new IssueComparator();
    private CreationDate comparator = new CreationDate();
    private ReverseCreationDate reverseCreationDate = new ReverseCreationDate();

    private List<Issue> issues = new ArrayList<>();

    public void add(Issue item) {
        issues.add(item);
    }

    public List<Issue> findAll() {
        return issues;
    }

    public List<Issue> getAll() {
        return issues;
    }

    public List<Issue> findOpen(List<Issue> issues) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (issue.isStatus()) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> findClose(List<Issue> issues) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (issue.isStatus() == false) {
                result.add(issue);
            }
        }
        return result;
    }

    public void openById(List<Issue> issues, int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                issue.setStatus(true);
            }
        }
    }

    public void closeById(List<Issue> issues, int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                issue.setStatus(false);
            }
        }
    }

    public Issue findById(int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                return issue;
            }
        }
        throw new NotFoundException(" Element with id: " + id + " not found");
    }

    public int compare(Issue o1, Issue o2) {
        return o1.getDate().compareTo(o2.getDate());
    }

    public Collection<Issue> sortByCreationDate(ReverseCreationDate dateOfCreation) {
        List<Issue> result = repository.getAll();
        Collections.sort(result, dateOfCreation);
        return result;
    }

    public Collection<Issue> sortByCreationDateReverse(CreationDate creationDateReverse) {
        List<Issue> result = repository.getAll();
        Collections.sort(result, creationDateReverse);
        return result;
    }

}
