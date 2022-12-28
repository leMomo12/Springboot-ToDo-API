package com.example.springboottodoapi.service

import com.example.springboottodoapi.model.ToDo
import com.example.springboottodoapi.repository.ToDoRepository
import org.springframework.stereotype.Service

@Service
class ToDoService(private val repository: ToDoRepository) {

    fun getAllToDoItems(): Collection<ToDo> = repository.findAll()

    fun getToDoItemById(id: Long): ToDo {
        val toDo = repository.findById(id)

        if (toDo.isEmpty) {
            throw NoSuchElementException("ToDo item with given id can't be found")
        }
        return toDo.get()
    }

    fun addToDoItem(toDo: ToDo): ToDo = repository.save(toDo)

    fun updateToDo(toDo: ToDo): ToDo  = repository.save(toDo)

    fun deleteToDo(id: Long) = repository.deleteById(id)

}