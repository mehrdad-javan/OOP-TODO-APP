package se.lexicon.dao.impl;

import se.lexicon.dao.TodoItemDAO;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.List;

public class TodoItemDAOImpl implements TodoItemDAO {

    // todo: needs to be completed

    @Override
    public TodoItem persist(TodoItem todoItem) {
        return null;
    }

    @Override
    public TodoItem findById(int id) {
        return null;
    }

    @Override
    public List<TodoItem> findAll() {
        return null;
    }

    @Override
    public List<TodoItem> findAllByDoneStatus(boolean doneStatus) {
        return null;
    }

    @Override
    public List<TodoItem> findByTitleContains(String query) {
        return null;
    }

    @Override
    public List<TodoItem> findByPersonId(int id) {
        return null;
    }

    @Override
    public List<TodoItem> findByDeadlineBefore(LocalDate date) {
        return null;
    }

    @Override
    public List<TodoItem> findByDeadlineAfter(LocalDate date) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
