package com.example.demodd.model;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:4200")
public class FileBoundary {

    private final FileEntityRepository fileEntityRepository;

    public FileBoundary(FileEntityRepository fileEntityRepository) {
        this.fileEntityRepository = fileEntityRepository;
    }

    @GetMapping
    public ResponseEntity<byte[]> getRandomFile() {

        long amountOfFiles = fileEntityRepository.count();
        Long randomPrimaryKey;

        if (amountOfFiles == 0) {
            return ResponseEntity.ok(new byte[0]);
        } else if (amountOfFiles == 1) {
            randomPrimaryKey = 1L;
        } else {
            randomPrimaryKey = ThreadLocalRandom.current().nextLong(1, amountOfFiles + 1);
        }

        FileEntity fileEntity = fileEntityRepository.findById(randomPrimaryKey).get();

        HttpHeaders header = new HttpHeaders();

        header.setContentType(MediaType.valueOf(fileEntity.getContentType()));
        header.setContentLength(fileEntity.getData().length);
        header.set("Content-Disposition", "attachment; filename=" + fileEntity.getFileName());

        return new ResponseEntity<>(fileEntity.getData(), header, HttpStatus.OK);
    }

    @PostMapping
    public String uploadDemo (@NotNull @RequestParam("trackname") String trackname,@RequestParam("file") MultipartFile multipartFile){
        String status="";
        if (!multipartFile.isEmpty()) {
            try {
                FileEntity fileEntity = new FileEntity(multipartFile.getOriginalFilename(), multipartFile.getContentType(),
                        multipartFile.getBytes());
                fileEntity.setTrackName(trackname);

                fileEntityRepository.save(fileEntity);

                status = status +  " Successfully uploaded file=" + multipartFile.getOriginalFilename();
            } catch (Exception e) {
                status = status +  "Failed to upload " + multipartFile.getOriginalFilename()+ " " + e.getMessage();
            }
        }

        return status;
    }

}