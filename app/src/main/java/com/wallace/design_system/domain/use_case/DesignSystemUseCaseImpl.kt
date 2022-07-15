package com.wallace.design_system.domain.use_case

import android.content.Context
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.storage.entities.DesignSystemDataEntity
import com.wallace.design_system.data.storage.entities.DesignSystemDsTokenEntity
import com.wallace.design_system.data.storage.entities.DesignSystemEntity
import com.wallace.design_system.data.storage.entities.DesignSystemValueEntity
import com.wallace.design_system.data.storage.room.DesignSystemDAO
import com.wallace.design_system.data.storage.singleton.DesignSystemSingleton
import com.wallace.design_system.domain.repository.DesignSystemRepository
import retrofit2.Response

class DesignSystemUseCaseImpl(
    val context: Context,
    val dao: DesignSystemDAO,
    val repository: DesignSystemRepository
) : DesignSystemUseCase {
    override suspend fun saveDesignSystem(model: DesignSystemModel.Response) {
        val parsed = parseDesignSystemToEntity(model)
        dao.insert(parsed)
        DesignSystemSingleton.getInstance(context).model = model
    }

    override suspend fun getDesignSystemStorage(): DesignSystemModel.Response {
        return parseDesignSystemToModel(
            dao.getData()
        )
//        return DesignSystemSingleton.getInstance(context).model ?: DesignSystemModel.Response()
    }

    override suspend fun getDesignSystem(): Response<DesignSystemModel.Response> {
        val response = repository.getDesignSystem()
        response.body()?.let {
            saveDesignSystem(it)
        }
        return response
    }

    override suspend fun parseDesignSystemToEntity(model: DesignSystemModel.Response): DesignSystemEntity {
        var value: DesignSystemValueEntity
        val listValues = ArrayList<DesignSystemValueEntity>()

        var dsToken: DesignSystemDsTokenEntity
        val listDsTokens = ArrayList<DesignSystemDsTokenEntity>()

        var data: DesignSystemDataEntity
        val listData = ArrayList<DesignSystemDataEntity>()

        model.listData?.forEach { dataItem ->
            data = DesignSystemDataEntity(
                category = dataItem.category ?: "",
                dsTokens = listDsTokens
            )

            dataItem.dsTokens?.forEach { modelItem ->
                dsToken = DesignSystemDsTokenEntity(
                    name = modelItem.name ?: "",
                    type = modelItem.type ?: "",
                    values = listValues
                )

                modelItem.values?.forEach { valueItem ->
                    value = DesignSystemValueEntity(
                        alpha = valueItem.alpha ?: 0.0,
                        reference = valueItem.reference ?: "",
                        value = valueItem.value ?: "",
                        weight = valueItem.weight ?: 0.0
                    )
                    listValues.add(value)
                }

                listDsTokens.add(dsToken)
            }
            listData.add(data)
        }
        return DesignSystemEntity(version = model.version ?: 1L, data = listData)
    }

    override suspend fun parseDesignSystemToModel(entity: DesignSystemEntity): DesignSystemModel.Response {
        var value: DesignSystemModel.Value
        val listValues = ArrayList<DesignSystemModel.Value>()

        var dsToken: DesignSystemModel.DsToken
        val listDsTokens = ArrayList<DesignSystemModel.DsToken>()

        var data: DesignSystemModel.Data
        val listData = ArrayList<DesignSystemModel.Data>()

        entity.data?.forEach { dataItem ->
            data = DesignSystemModel.Data().apply {
                this.category = dataItem.category
                this.dsTokens = listDsTokens
            }

            dataItem.dsTokens?.forEach { modelItem ->
                dsToken = DesignSystemModel.DsToken().apply {
                    this.name = modelItem.name
                    this.type = modelItem.type
                    this.values = listValues
                }

                modelItem.values?.forEach { valueItem ->
                    value = DesignSystemModel.Value().apply {
                        this.value = valueItem.value
                        this.reference = valueItem.reference
                        this.alpha = valueItem.alpha
                        this.weight = valueItem.weight
                    }
                    listValues.add(value)
                }
                listDsTokens.add(dsToken)
            }
            listData.add(data)
        }
        return DesignSystemModel.Response().apply {
            this.version = entity.version ?: 1L
            this.listData = listData
        }
    }
}