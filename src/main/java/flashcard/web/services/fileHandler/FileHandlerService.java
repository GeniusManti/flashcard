package flashcard.web.services.fileHandler;

import org.springframework.web.multipart.MultipartFile;

public interface FileHandlerService {
    String uploadFile(MultipartFile file);

    String deleteFileFromS3Bucket(String fileUrl);
}
