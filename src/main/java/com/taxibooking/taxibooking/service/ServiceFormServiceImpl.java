package com.taxibooking.taxibooking.service;

import com.taxibooking.taxibooking.entity.ServiceForm;
import com.taxibooking.taxibooking.repository.ServiceFormCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;


@Service
public class ServiceFormServiceImpl implements ServiceFormService {

    @Autowired
    private ServiceFormCrud serviceFormCrud;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServiceForm addService(ServiceForm serviceForm, MultipartFile multipartFile) throws Exception {
        ServiceForm save = null;
        try {
            save = serviceFormCrud.save(serviceForm);

            if (save != null && multipartFile != null && !multipartFile.isEmpty()) {
                String path = "C:\\Users\\kunal\\Desktop\\taxibooking\\src\\main\\resources\\static\\myserviceimg\\"
                        + multipartFile.getOriginalFilename();
                byte[] bytes = multipartFile.getBytes();
                try (FileOutputStream fos = new FileOutputStream(path)) {
                    fos.write(bytes);
                }
            }
        } catch (Exception e) {
            save=null;
            throw e;
        }
        return save;
    }

    @Override
    public List<ServiceForm> readAllService() {
        return serviceFormCrud.findAll();
    }
}
