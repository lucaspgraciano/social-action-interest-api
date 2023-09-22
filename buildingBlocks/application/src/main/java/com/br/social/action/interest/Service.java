package com.br.social.action.interest;

public interface Service<TRequest, TResponse> {
    TResponse execute(TRequest request) throws Exception;
}
