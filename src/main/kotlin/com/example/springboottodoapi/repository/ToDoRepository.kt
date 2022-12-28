package com.example.springboottodoapi.repository

import com.example.springboottodoapi.model.ToDo
import org.springframework.data.jpa.repository.JpaRepository

interface ToDoRepository : JpaRepository<ToDo, Long> {
}