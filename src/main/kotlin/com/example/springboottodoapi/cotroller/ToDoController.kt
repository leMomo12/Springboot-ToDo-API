package com.example.springboottodoapi.cotroller

import com.example.springboottodoapi.model.ToDo
import com.example.springboottodoapi.repository.ToDoRepository
import com.example.springboottodoapi.service.ToDoService
import com.sun.xml.bind.v2.TODO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("todo")
class ToDoController(private val service: ToDoService) {

    @GetMapping
    fun getAllToDoItems(): Collection<ToDo> = service.getAllToDoItems()

    @GetMapping("/{id}")
    fun getToDoItemById(@PathVariable id: Long): ToDo = service.getToDoItemById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addToDoItem(@RequestBody toDo: ToDo): ToDo = service.addToDoItem(toDo)

    @PatchMapping
    fun updateToDo(@RequestBody toDo: ToDo): ToDo = service.updateToDo(toDo)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteToDo(@PathVariable id: Long): Unit = service.deleteToDo(id)

}