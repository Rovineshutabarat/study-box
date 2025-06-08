package com.study.box.server.controllers;

import com.study.box.server.models.payload.response.common.SuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseController<T, ID> {
    default ResponseEntity<SuccessResponse<List<T>>> findAll() {
        throw new UnsupportedOperationException("Method findAll was not implemented.");
    }

    default ResponseEntity<SuccessResponse<T>> findById(ID id) {
        throw new UnsupportedOperationException("Method findById was not implemented.");
    }

    default ResponseEntity<SuccessResponse<T>> create(T entity) {
        throw new UnsupportedOperationException("Method create was not implemented.");
    }

    default ResponseEntity<SuccessResponse<T>> update(ID id, T entity) {
        throw new UnsupportedOperationException("Method update was not implemented.");
    }

    default ResponseEntity<SuccessResponse<T>> delete(ID id) {
        throw new UnsupportedOperationException("Method delete was not implemented.");
    }
}
