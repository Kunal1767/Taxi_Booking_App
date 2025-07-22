package com.taxibooking.taxibooking.service;

import com.taxibooking.taxibooking.entity.ServiceForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ServiceFormService {
    public ServiceForm addService(ServiceForm serviceForm, MultipartFile multipartFile) throws Exception;
    public List<ServiceForm> readAllService();
}
