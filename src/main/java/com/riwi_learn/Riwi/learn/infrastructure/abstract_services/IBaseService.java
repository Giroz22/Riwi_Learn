package com.riwi_learn.Riwi.learn.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface IBaseService <RQC, RQU, RS, ID> {
    public Page<RS> getAll (int page, int size);
    public RS getById (ID id);
    public RS create (RQC request);
    public RS update (ID id, RQU request);
    public void delete (ID id);
}
