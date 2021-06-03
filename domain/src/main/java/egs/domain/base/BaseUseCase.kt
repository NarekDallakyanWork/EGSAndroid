package egs.domain.base

import egs.domain.model.State

interface BaseUseCase<T : Any, R : Any> {
    suspend operator fun invoke(param: T): State<R>
}