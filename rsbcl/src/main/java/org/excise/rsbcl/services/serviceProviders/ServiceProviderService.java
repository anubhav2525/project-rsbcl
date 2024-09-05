package org.excise.rsbcl.services.serviceProviders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.serviceProviders.ServiceProviders;
import org.excise.rsbcl.repository.serviceProviders.ServiceProvidersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceProviderService {
    @Autowired
    private final ServiceProvidersRepo serviceProvidersRepo;

    public ServiceProviderService(ServiceProvidersRepo serviceProvidersRepo) {
        this.serviceProvidersRepo = serviceProvidersRepo;
    }

    public Response<ServiceProviders> saveService(ServiceProviders serviceProviders) {
        try {
            serviceProviders.setLastUpdate(LocalDateTime.now());
            ServiceProviders saved = serviceProvidersRepo.save(serviceProviders);
            return new Response<>("Saved", "Service saved", saved);
        } catch (Exception e) {
            return new Response<>("Error", "Error while saving the record: " + e.getMessage(), null);
        }
    }

    public Response<?> getServiceById(ObjectId id) {
        try {
            ServiceProviders serviceProviders = serviceProvidersRepo.findById(id).orElse(null);
            if (serviceProviders == null) return new Response<>("Error404", "Serivce not Found", null);
            return new Response<>("Success", "Serivce Found", serviceProviders);
        } catch (Exception e) {
            return new Response<>("Error", "Error while saving the record: " + e.getMessage(), null);
        }
    }

    public Response<?> getAllServices(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<ServiceProviders> serviceProvidersPage = serviceProvidersRepo.findAll(pageRequest);
            return new Response<>("Success", "Data found", serviceProvidersPage);
        } catch (Exception e) {
            return new Response<>("Error", "Error while fetching the records:" + e.getMessage(), null);
        }
    }

    public Response<?> deleteServiceById(ObjectId id) {
        try {
            ServiceProviders oldService = serviceProvidersRepo.findById(id).orElse(null);
            if (oldService == null) return new Response<>("Error404", "Service not found", null);
            serviceProvidersRepo.deleteById(id);
            return new Response<>("Success", "Service deleted", null);
        } catch (Exception e) {
            return new Response<>("Error", "Error while deletion: " + e.getMessage(), null);
        }
    }

    public Response<?> updateServiceById(ObjectId id, ServiceProviders newService) {
        try {
            ServiceProviders oldService = serviceProvidersRepo.findById(id).orElse(null);
            if (oldService == null) return new Response<>("Error404", "Service not found", newService);
            oldService.setLink(newService.getLink() != null && newService.getLink().equals(oldService.getLink()) ? newService.getLink() : oldService.getLink());
            oldService.setTitle(newService.getTitle() != null && newService.getTitle().equals(oldService.getTitle()) ? newService.getTitle() : oldService.getTitle());
            oldService.setStatus(newService.getStatus() != null && newService.getStatus().equals(oldService.getStatus()) ? newService.getStatus() : oldService.getStatus());
            oldService.setCategory(newService.getCategory() != null && newService.getCategory().equals(oldService.getCategory()) ? newService.getCategory() : oldService.getCategory());
            oldService.setLastUpdate(LocalDateTime.now());
            serviceProvidersRepo.save(oldService);
            return new Response<>("Success", "Service updated", oldService);
        } catch (Exception e) {
            return new Response<>("Error", "Error while deletion: " + e.getMessage(), null);
        }
    }

    public Response<List<ServiceProviders>> getAllServicesList() {
        try {
            List<ServiceProviders> serviceProviders = serviceProvidersRepo.findAll();
            if (serviceProviders.isEmpty()) return new Response<>("Error404", "NO data found", null);
            return new Response<>("Success", "Data found", serviceProviders);
        } catch (Exception e) {
            return new Response<>("Error", "Error while fetching data: " + e.getMessage(), null);
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response<T> {
        private String status;
        private String message;
        private T data;
    }
}
