package com.study.box.server.service.implementations;

import com.study.box.server.models.entity.Module;
import com.study.box.server.models.entity.Resource;
import com.study.box.server.models.entity.User;
import com.study.box.server.models.exception.ResourceNotFoundException;
import com.study.box.server.models.payload.request.ResourceRequest;
import com.study.box.server.repositories.ResourceRepository;
import com.study.box.server.service.BaseService;
import com.study.box.server.service.ResourceService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService, BaseService<Resource, Integer> {
    private final ResourceRepository resourceRepository;
    private final ModuleServiceImpl moduleService;

    @Override
    public Resource findById(Integer id) {
        return resourceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Resource with id %s was not found.", id))
        );
    }

    @Override
    public Resource createResource(ResourceRequest resourceRequest) {
        Module module = moduleService.findById(resourceRequest.getModuleId());

        return resourceRepository.save(Resource.builder()
                .title(resourceRequest.getTitle())
                .isPreview(resourceRequest.getIsPreview())
                .orderNumber(resourceRequest.getOrderNumber())
                .type(resourceRequest.getType())
                .format(resourceRequest.getFormat())
                .url(resourceRequest.getUrl())
                .transcript(resourceRequest.getTranscript())
                .module(module)
                .build());
    }

    @Override
    public Resource updateResource(Integer id, ResourceRequest resourceRequest) {
        findById(id);
        Module module = moduleService.findById(resourceRequest.getModuleId());

        return resourceRepository.save(Resource.builder()
                .id(id)
                .title(resourceRequest.getTitle())
                .isPreview(resourceRequest.getIsPreview())
                .orderNumber(resourceRequest.getOrderNumber())
                .type(resourceRequest.getType())
                .format(resourceRequest.getFormat())
                .url(resourceRequest.getUrl())
                .transcript(resourceRequest.getTranscript())
                .module(module)
                .build());
    }

    @Override
    public Resource delete(Integer integer) {
        Resource resource = findById(integer);
        resourceRepository.delete(resource);
        return resource;
    }

    @Override
    public Boolean canModifyResource(Integer resourceId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Resource resource = findById(resourceId);
        return resource.getModule().getCourse().getInstructor().getEmail().equals(user.getEmail());
    }
}
