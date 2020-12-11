package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosRepository;

    @Override
    public Todos markComplete(long todoid)
    {
        Todos completeTodo = todosRepository.findById(todoid)
            .orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " Not Found!"));
        completeTodo.setCompleted(true);
        return todosRepository.save(completeTodo);
    }
}
