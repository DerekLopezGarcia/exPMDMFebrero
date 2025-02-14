package com.example.expmdmfebrero.core

sealed class ErrorApp(message: String, cause: Throwable? = null) : Throwable(message, cause) {
    class Network(message: String = "Network error occurred", cause: Throwable? = null) : ErrorApp(message, cause)
    class Server(message: String = "Server error occurred", cause: Throwable? = null) : ErrorApp(message, cause)
    class Database(message: String = "Database error occurred", cause: Throwable? = null) : ErrorApp(message, cause)
    class Unknown(message: String = "Unknown error occurred", cause: Throwable? = null) : ErrorApp(message, cause)
}