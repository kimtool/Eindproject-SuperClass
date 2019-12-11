package com.in28minutes.rest.webservices.WebServices.demo;


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
@CrossOrigin(origins = "http://localhost:4200")
public class FileBoundary {

    private final DemoJpaRespository fileEntityRepository;

    public FileBoundary(DemoJpaRespository fileEntityRepository) {
        this.fileEntityRepository = fileEntityRepository;
    }

//    @RequestMapping("/users/{username}/demos")
//    public ResponseEntity<byte[]> getRandomFile() {
//
//        long amountOfFiles = fileEntityRepository.count();
//        Long randomPrimaryKey;
//
//        if (amountOfFiles == 0) {
//            return ResponseEntity.ok(new byte[0]);
//        } else if (amountOfFiles == 1) {
//            randomPrimaryKey = 1L;
//        } else {
//            randomPrimaryKey = ThreadLocalRandom.current().nextLong(1, amountOfFiles + 1);
//        }
//
//        Demo fileEntity = fileEntityRepository.findById(randomPrimaryKey).get();
//
//        HttpHeaders header = new HttpHeaders();
//
//        header.setContentType(MediaType.valueOf(fileEntity.getContentType()));
//        header.setContentLength(fileEntity.getData().length);
//        header.set("Content-Disposition", "attachment; filename=" + fileEntity.getFileName());
//
//        return new ResponseEntity<>(fileEntity.getData(), header, HttpStatus.OK);
//    }


    @PostMapping("/users/{username}/demos")
    public String uploadDemo (@PathVariable String username, Demo demo, @NotNull @RequestParam("trackname") String trackname,@RequestParam("file") MultipartFile multipartFile){
        String status="";
        if (!multipartFile.isEmpty()) {
            try {
                Demo fileEntity = new Demo(multipartFile.getOriginalFilename(), multipartFile.getContentType(), 
                        demo.getUsername(), demo.getDescription(), multipartFile.getBytes());
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