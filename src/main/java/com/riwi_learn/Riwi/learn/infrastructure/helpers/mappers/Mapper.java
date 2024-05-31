package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class Mapper {
    /**
     * Copy all attributes of source to target
     * @param <S> Type data of source
     * @param <T> Type data of target
     * @param source 
     * @param target
     * @return target with info copy from source
     */
    public static<S, T> T sourceToTarget(S source, T target){
        BeanUtils.copyProperties(source,  target);

        return target;
    }   
}
