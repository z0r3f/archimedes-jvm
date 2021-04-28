package io.archimedesfw.data.tx.spring

import io.micronaut.spring.tx.annotation.Transactional
import org.springframework.transaction.annotation.Propagation
import javax.inject.Singleton

/**
 * `open class` because Micronaut needs to do their magic
 */
@Singleton
open class SpringTransactional : io.archimedesfw.data.tx.Transactional {

    @Transactional(propagation = Propagation.REQUIRED)
    override fun <R> writable(block: () -> R): R = block()

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    override fun <R> readOnly(block: () -> R): R = block()

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun <R> newWritable(block: () -> R): R = block()

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    override fun <R> newReadOnly(block: () -> R): R = block()

}
