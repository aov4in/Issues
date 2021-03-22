package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Author;
import ru.netology.domain.Issues;
import ru.netology.domain.Label;
import ru.netology.manager.IssuesManager;
import ru.netology.repository.IssuesRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssuesManagerTest {

    IssuesRepository repository = new IssuesRepository();
    IssuesManager manager = new IssuesManager(repository);
    private Author author = new Author(1, "Ivan Petrov");
    private Author author1 = new Author(2, "Petr Ivanov");
    private Author author2 = new Author(3, "Ivan Susanin");
    private Set<Author> assignees = new HashSet<>();
    private Label label = new Label(1,"bug","Red");
    private Label label2 = new Label(2,"documentation","Blue");
    private Label label3 = new Label(3,"invalid","");
    private Set<Label> labels = new HashSet<>();
    private Issues issue = new Issues(1, "Ivan Petrov", labels, "java", "Open", assignees, "03.03.2021", true, true, false);
    private Issues issue2 = new Issues(2, "Petr Ivanov", labels, "java", "Close", assignees, "03.03.2021", true, true, false);
    private Issues issue3 = new Issues(3, "Ivan Susanin", labels, "java", "Open", assignees, "03.03.2021", true, true, false);

    @Nested
    class MultipleIssue {
        @BeforeEach
        public void setUp() {
            labels.add(label);
            labels.add(label2);
            assignees.add(author);
            assignees.add(author2);
            manager.add(issue);
            manager.add(issue2);
            manager.add(issue3);
        }

        @Test
        void shouldFilterAuthorNo() {
            List<Issues> actual = manager.filterAuthor(author1);
            List<Issues> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAuthorYes() {
            List<Issues> actual = manager.filterAuthor(author2);
            List<Issues> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelNo() {
            List<Issues> actual = manager.filterLabel(label3);
            List<Issues> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelYes() {
            List<Issues> actual = manager.filterLabel(label2);
            List<Issues> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeNo() {
            List<Issues> actual = manager.filterAssignee(author1);
            List<Issues> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeYes() {
            List<Issues> actual = manager.filterAssignee(author2);
            List<Issues> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }
    }


    @Nested
    class Empty {
        @Test
        void shouldFilterAuthorNo() {
            List<Issues> actual = manager.filterAuthor(author1);
            List<Issues> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelNo() {
            List<Issues> actual = manager.filterLabel(label3);
            List<Issues> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeNo() {
            List<Issues> actual = manager.filterAssignee(author1);
            List<Issues> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

    }

    @Nested
    class SingleIssue {
        @BeforeEach
        public void setUp() {
            labels.add(label);
            labels.add(label2);
            assignees.add(author);
            assignees.add(author2);
            manager.add(issue);
            manager.add(issue2);
            manager.add(issue3);

        }

        @Test
        void shouldFilterAuthorNo() {
            List<Issues> actual = manager.filterAuthor(author1);
            List<Issues> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAuthorYes() {
            List<Issues> actual = manager.filterAuthor(author2);
            List<Issues> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelNo() {
            List<Issues> actual = manager.filterLabel(label3);
            List<Issues> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelYes() {
            List<Issues> actual = manager.filterLabel(label);
            List<Issues> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeNo() {
            List<Issues> actual = manager.filterAssignee(author1);
            List<Issues> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeYes() {
            List<Issues> actual = manager.filterAssignee(author);
            List<Issues> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }
    }
}