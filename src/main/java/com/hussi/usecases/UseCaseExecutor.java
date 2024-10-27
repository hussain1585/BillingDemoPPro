package com.hussi.usecases;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface UseCaseExecutor {
    <RX, DTO, R> CompletableFuture<RX> execute(UseCase<DTO, R> useCase, DTO input, Function<R, RX> dtoToResponseWrapper);

}
