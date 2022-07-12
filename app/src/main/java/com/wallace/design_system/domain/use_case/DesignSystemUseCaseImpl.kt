package com.wallace.design_system.domain.use_case

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.storage.DesignSystemDAO
import com.wallace.design_system.data.storage.entities.*
import com.wallace.design_system.domain.repository.DesignSystemRepository

class DesignSystemUseCaseImpl(
    val dao: DesignSystemDAO,
    val repository: DesignSystemRepository
): DesignSystemUseCase {
    override fun saveDesignSystem(model: DesignSystemModel.Response) {
        dao.insertDesignSystem(parseDesignSystemToEntity(model))
    }

    override fun getDesignSystemStorage(): DesignSystemModel.Response {
        return parseDesignSystemToModel(dao.getDesignSystem().value ?: DesignSystemEntity())
    }

    override suspend fun getDesignSystem() = repository.getDesignSystem()

    override fun parseDesignSystemToEntity(model: DesignSystemModel.Response): DesignSystemEntity {
        var value: DesignSystemValueEntity
        val listValues = ArrayList<DesignSystemValueEntity>()

        var dsToken: DesignSystemDsTokenEntity
        val listDsTokens = ArrayList<DesignSystemDsTokenEntity>()

        var item: DesignSystemModelItemEntity
        val listItems = ArrayList<DesignSystemModelItemEntity>()

        var data: DesignSystemDataEntity
        val listData = ArrayList<DesignSystemDataEntity>()

        model.listData?.forEach { dataItem ->
            data = DesignSystemDataEntity().apply {
                this.id = null
                this.items = listItems
            }
            listData.add(data)

            dataItem.tokens?.forEach { modelItem ->
                item = DesignSystemModelItemEntity().apply {
                    this.id = null
                    this.category = modelItem.category
                    this.dsTokens = listDsTokens
                }
                listItems.add(item)

                modelItem.dsTokens?.forEach { tokenItem ->
                    dsToken = DesignSystemDsTokenEntity().apply {
                        this.id = null
                        this.name = tokenItem.name
                        this.type = tokenItem.type
                        this.values = listValues
                    }
                    listDsTokens.add(dsToken)

                    tokenItem.values?.forEach { valueItem ->
                        value = DesignSystemValueEntity().apply {
                            this.id = null
                            this.value = valueItem.value
                            this.reference = valueItem.reference
                            this.alpha = valueItem.alpha
                            this.weight = valueItem.weight
                        }
                        listValues.add(value)
                    }
                }
            }
        }
        return DesignSystemEntity().apply {
            this.version = model.version ?: 1L
            this.data = listData
        }
    }

    override fun parseDesignSystemToModel(entity: DesignSystemEntity): DesignSystemModel.Response {
        var value: DesignSystemModel.Value
        val listValues = ArrayList<DesignSystemModel.Value>()

        var dsToken: DesignSystemModel.DsToken
        val listDsTokens = ArrayList<DesignSystemModel.DsToken>()

        var item: DesignSystemModel.DesignSystemModelItem
        val listItems = ArrayList<DesignSystemModel.DesignSystemModelItem>()

        var data: DesignSystemModel.Data
        val listData = ArrayList<DesignSystemModel.Data>()

        entity.data?.forEach { dataItem ->
            data = DesignSystemModel.Data().apply {
                this.tokens = listItems
            }
            listData.add(data)

            dataItem.items?.forEach { modelItem ->
                item = DesignSystemModel.DesignSystemModelItem().apply {
                    this.category = modelItem.category
                    this.dsTokens = listDsTokens
                }
                listItems.add(item)

                modelItem.dsTokens?.forEach { tokenItem ->
                    dsToken = DesignSystemModel.DsToken().apply {
                        this.name = tokenItem.name
                        this.type = tokenItem.type
                        this.values = listValues
                    }
                    listDsTokens.add(dsToken)

                    tokenItem.values?.forEach { valueItem ->
                        value = DesignSystemModel.Value().apply {
                            this.value = valueItem.value
                            this.reference = valueItem.reference
                            this.alpha = valueItem.alpha
                            this.weight = valueItem.weight
                        }
                        listValues.add(value)
                    }
                }
            }
        }

        return DesignSystemModel.Response().apply {
            this.version = entity.version ?: 1L
            this.listData = listData
        }
    }
}