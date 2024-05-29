package com.riwi_learn.Riwi.learn.infrastructure.helpers.DtoConverters;

public interface IBaseConvert<E, RQ, RS> {
    public E requestToEntity(RQ request,  E entity);
    public RS EntityToResponse(E entity);
}
