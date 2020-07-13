package com.example.domain

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class ResultData<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultData<T>()
    data class Error(val exception: Exception) : ResultData<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}