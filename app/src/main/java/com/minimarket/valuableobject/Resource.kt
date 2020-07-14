package com.minimarket.valuableobject

data class Resource<out T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val exception: Exception? = null
) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data)
        }

        fun <T> error(exception: Exception): Resource<T> {
            return Resource(Status.ERROR, exception = exception)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data)
        }
    }
}