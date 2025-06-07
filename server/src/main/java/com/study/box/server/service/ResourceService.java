package com.study.box.server.service;

import com.study.box.server.models.entity.Resource;
import com.study.box.server.models.payload.request.ResourceRequest;

public interface ResourceService {
    Resource createResource(ResourceRequest resourceRequest);

    Resource updateResource(Integer id, ResourceRequest resourceRequest);
}
