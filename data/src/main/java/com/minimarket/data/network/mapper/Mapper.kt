package com.minimarket.data.network.mapper

/**
 * A interface that contains the methods that will be implemented for any Mapper class
 * */
interface Mapper<I, O> {
    fun map(input: I): O
    fun reverseMap(input: O): I
}