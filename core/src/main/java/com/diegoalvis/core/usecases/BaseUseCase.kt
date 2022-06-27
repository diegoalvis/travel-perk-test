package com.diegoalvis.core.usecases

abstract class BaseUseCase<in Params, out Type> {

    abstract suspend fun execute(input: Params): Result<Type>

}