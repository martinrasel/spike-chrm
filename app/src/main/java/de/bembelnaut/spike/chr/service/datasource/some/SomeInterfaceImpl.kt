package de.bembelnaut.spike.chr.service.datasource.some

import de.bembelnaut.spike.chr.domain.SomeModel
import de.bembelnaut.spike.chr.service.datasource.SomeInterface
import javax.inject.Inject

// Hilt: 1.10) Impl. für Binds
class SomeInterfaceImpl
@Inject constructor(
    private val myModel: SomeModel
) : SomeInterface {

    override fun getSomeModel(): SomeModel {
        return myModel
    }
}