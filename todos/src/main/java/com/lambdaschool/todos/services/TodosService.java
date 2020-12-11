package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;

public interface TodosService
{
    Todos markComplete(long todoid);
}
