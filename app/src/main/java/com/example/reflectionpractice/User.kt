package com.example.reflectionpractice

data class User(val id: Int, val name: String, private val description: String) {

    private fun getFullInfo(): String {
        return "This user's id is $id, name is $name"
    }
}