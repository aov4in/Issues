package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.comparator.IssueComparator;
import ru.netology.domain.Author;
import ru.netology.domain.Issues;
import ru.netology.domain.Label;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssuesRepositoryTest {
    private IssuesRepository repository = new IssuesRepository();
    private IssueComparator comparator = new IssueComparator();
    private Author author = new Author(1, "Ivan Petrov");
    private Author author1 = new Author(2, "Petr Ivanov");
    private Author author2 = new Author(3, "Ivan Susanin");
    private Set<Author> assignees = new HashSet<>();
    private Label label = new Label(1,"bug","Red");
    private Label label2 = new Label(2,"documentation","Blue");
    private Label label3 = new Label(3,"invalid","");
    private Set<Label> labels = new HashSet<>();
    private Issues issue = new Issues(1, "Ivan Petrov", labels, "java", "Open", assignees, "01.03.2019", true, false, true);
    private Issues issue2 = new Issues(2, "Petr Ivanov", labels, "java", "Close", assignees, "02.04.2020", true, false, false);
    private Issues issue3 = new Issues(3, "Ivan Susanin", labels, "java", "Close", assignees, "03.05.2021", true, false, false);

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
        List<Issues> actual = repository.findOpen(repository.getAll());
        List<Issues> expected = new ArrayList<>();
        expected.add(issue);
        assertEquals(expected, actual);
    }

    @Test
    void shouldOutputListAllCloseIssue() {
        List<Issues> actual = repository.findClose(repository.getAll());
        List<Issues> expected = new ArrayList<>();
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldOpenIssue() {
        repository.openById(repository.getAll(), 1);
        List<Issues> actual = repository.getAll();
        List<Issues> expected = new ArrayList<>();
        expected.add(issue);
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCloseIssue() {
        repository.closeById(repository.getAll(), 2);
        List<Issues> actual = repository.getAll();
        List<Issues> expected = new ArrayList<>();
        expected.add(issue);
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldSortDateCreationNew() {
        Collections.sort(repository.getAll(), comparator);
        List<Issues> actual = repository.getAll();
        List<Issues> expected = new ArrayList<>();
        expected.add(issue);
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldSortDateUpdateNew() {
        Collections.sort(repository.getAll(), comparator);
        List<Issues> actual = repository.getAll();
        List<Issues> expected = new ArrayList<>();
        expected.add(issue);
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, actual);
    }
}