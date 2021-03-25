package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Author;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssuesRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {

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
    private Issue issue = new Issue(1, "Ivan Petrov", labels, "java", "Open", assignees, Issue.setDate(2019,03,01), true, true, false);
    private Issue issue2 = new Issue(2, "Petr Ivanov", labels, "java", "Close", assignees, Issue.setDate(2019,03,01), true, true, false);
    private Issue issue3 = new Issue(3, "Ivan Susanin", labels, "java", "Open", assignees, Issue.setDate(2019,03,01), true, true, false);

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
            List<Issue> actual = manager.filterAuthor(author1);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAuthorYes() {
            List<Issue> actual = manager.filterAuthor(author2);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelNo() {
            List<Issue> actual = manager.filterLabel(label3);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelYes() {
            List<Issue> actual = manager.filterLabel(label2);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeNo() {
            List<Issue> actual = manager.filterAssignee(author1);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeYes() {
            List<Issue> actual = manager.filterAssignee(author2);
            List<Issue> expected = new ArrayList<>();
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
            List<Issue> actual = manager.filterAuthor(author1);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelNo() {
            List<Issue> actual = manager.filterLabel(label3);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeNo() {
            List<Issue> actual = manager.filterAssignee(author1);
            List<Issue> expected = new ArrayList<>();
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
            List<Issue> actual = manager.filterAuthor(author1);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAuthorYes() {
            List<Issue> actual = manager.filterAuthor(author2);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelNo() {
            List<Issue> actual = manager.filterLabel(label3);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelYes() {
            List<Issue> actual = manager.filterLabel(label);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeNo() {
            List<Issue> actual = manager.filterAssignee(author1);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeYes() {
            List<Issue> actual = manager.filterAssignee(author);
            List<Issue> expected = new ArrayList<>();
            expected.add(issue);
            expected.add(issue2);
            expected.add(issue3);
            assertEquals(expected, actual);
        }
    }
}