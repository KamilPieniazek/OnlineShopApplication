package pl.osa.osaapplication.services.uploadFile;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadSerivce {


    public  void uploadToLocal(MultipartFile file);
}
