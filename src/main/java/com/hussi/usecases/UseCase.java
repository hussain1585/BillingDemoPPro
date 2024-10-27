package com.hussi.usecases;

public abstract class UseCase<Input, Output> {
    public abstract Output execute(Input input);
}