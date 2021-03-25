package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.comparator.CreationDate;
import ru.netology.comparator.IssueComparator;
import ru.netology.comparator.ReverseCreationDate;
import ru.netology.domain.Author;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.exeption.NotFoundException;
import ru.netology.manager.IssuesManager;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    private IssuesRepository repository = new IssuesRepository();
    private IssueComparator issueComparator = new IssueComparator();
    private CreationDate comparator = new CreationDate();
    private ReverseCreationDate reverseCreationDate = new ReverseCreationDate();
    private Author author = new Author(1, "Ivan Petrov");
    private Author author1 = new Author(2, "Petr Ivanov");
    private Author author2 = new Author(3, "Ivan Susanin");
    private Set<Author> assignees = new HashSet<>();
    private Label label = new Label(1,"bug","Red");
    private Label label2 = new Label(2,"documentation","Blue");
    private Label label3 = new Label(3,"invalid","");
    private Set<Label> labels = new HashSet<>();
    private Issue issue = new Issue(1, "Ivan Petrov", labels, "java", "Open", assignees, Issue.setDate(2019,03,01), true, false, true);
    private Issue issue2 = new Issue(2, "Petr Ivanov", labels, "java", "Close", assignees, Issue.setDate(2020,04,02), true, false, false);
    private Issue issue3 = new Issue(3, "Ivan Susanin", labels, "java", "Close", assignees, Issue.setDate(2021,05,03), true, false, false);

    @BeforeEach
    public void setUp() {
        labels.add(label);
        labels.add(label2);
        assignees.add(author2);
        repository.add(issue);
        repository.add(issue2);
        repository.add(issue3);
    }

    @Test
    void shouldOutputListAllOpenIssue() {
        List<Issue> actual = repository.findOpen(repository.getAll());
        List<Issue> expected = new ArrayList<>();
        expected.add(issue);
        assertEquals(expected, actual);
    }

    @Test
    void shouldOutputListAllCloseIssue() {
        List<Issue> actual = repository.findClose(repository.getAll());
        List<Issue> expected = new ArrayList<>();
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldOpenIssue() {
        repository.openById(repository.getAll(), 1);
        List<Issue> actual = repository.getAll();
        List<Issue> expected = new ArrayList<>();
        expected.add(issue);
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCloseIssue() {
        repository.closeById(repository.getAll(), 2);
        List<Issue> actual = repository.getAll();
        List<Issue> expected = new ArrayList<>();
        expected.add(issue);
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldSortDateCreationNew() {
        Collections.sort(repository.getAll(), comparator);
        List<Issue> actual = repository.getAll();
        List<Issue> expected = new ArrayList<>();
        expected.add(issue);
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldSortDateUpdateNew() {
        Collections.sort(repository.getAll(), comparator);
        List<Issue> actual = repository.getAll();
        List<Issue> expected = new ArrayList<>();
        expected.add(issue);
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, actual);
    }

}