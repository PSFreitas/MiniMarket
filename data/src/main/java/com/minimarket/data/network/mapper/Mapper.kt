package com.minimarket.data.network.mapper

interface Mapper<I, O> {
    fun map(input: I): O
    fun reverseMap(input: O): I
}