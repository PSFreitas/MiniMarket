package com.minimarket

import com.minimarket.data.network.mapper.Mapper
import com.minimarket.domain.entities.SizeEntity
import com.minimarket.entity.SizeViewEntity

class SizeViewEntityMapper : Mapper<List<SizeEntity>, List<SizeViewEntity>> {
    override fun map(input: List<SizeEntity>): List<SizeViewEntity> {
        var sizeList = mutableListOf<SizeViewEntity>()

        for (size in input) {
            sizeList.add(
                SizeViewEntity(
                    isAvailable = size.isAvailable,
                    size = size.size
                )
            )
        }
        return sizeList
    }

    override fun reverseMap(input: List<SizeViewEntity>): List<SizeEntity> {
        TODO("Not yet implemented")
    }
}