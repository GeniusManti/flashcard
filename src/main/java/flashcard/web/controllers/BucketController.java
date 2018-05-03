package flashcard.web.controllers;

import flashcard.web.services.fileHandler.FileHandlerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/storage")
public class BucketController {

    private final FileHandlerService fileHandlerService;

    public BucketController(FileHandlerService fileHandler) {
        this.fileHandlerService = fileHandler;

    }

    @PostMapping("/uploadFile")
    public ResponseEntity<String> handleFileUpload(@RequestParam MultipartFile file) {
        return new ResponseEntity<>(fileHandlerService.uploadFile(file), HttpStatus.OK);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart String fileUrl) {
        return fileHandlerService.deleteFileFromS3Bucket(fileUrl);
    }

}