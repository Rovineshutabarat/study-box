package com.study.box.server.service;

import java.util.List;

public interface BaseService<T, ID> {
    default List<T> findAll() {
        throw new UnsupportedOperationException("Method findAll was not implemented.");
    }

    default T findById(ID id) {
        throw new UnsupportedOperationException("Method findById was not implemented.");
    }

    default T create(T entity) {
        throw new UnsupportedOperationException("Method create was not implemented.");
    }

    default T update(ID id, T entity) {
        throw new UnsupportedOperationException("Method update was not implemented.");
    }

    default T delete(ID id) {
        throw new UnsupportedOperationException("Method delete was not implemented.");
    }
}
