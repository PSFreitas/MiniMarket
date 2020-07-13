package com.example.data.network.mapper

import com.example.data.network.SizeNetwork
import com.example.domain.entities.SizeEntity

class SizeListMapper : Mapper<List<SizeNetwork>, List<SizeEntity>> {

    override fun map(input: List<SizeNetwork>): List<SizeEntity> {
        val sizesEntity = mutableListOf<SizeEntity>()

        for (sizeNetwork in input) {
            sizesEntity.add(
                SizeEntity(
                    size = sizeNetwork.size,
                    isAvailable = sizeNetwork.isAvailable
                )
            )
        }
        return sizesEntity
    }

    override fun reverseMap(input: List<SizeEntity>): List<SizeNetwork> {
        val sizesNetwork = mutableListOf<SizeNetwork>()

        for (sizeEntity in input) {
            sizesNetwork.add(
                SizeNetwork(
                    size = sizeEntity.size,
                    isAvailable = sizeEntity.isAvailable,
                    sku = ""
                )
            )
        }

        return sizesNetwork
    }
}