package pl.osa.osaapplication.services.uploadFile;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadImp implements FileUploadSerivce {

    private String uploadFolderPath="";
    @Override
    public void uploadToLocal(MultipartFile file) {

    }
}
