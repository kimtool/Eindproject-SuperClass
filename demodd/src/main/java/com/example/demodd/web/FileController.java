package com.example.demodd.web;

import java.io.InputStream;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

import com.example.demodd.model.FileEntity;
import com.example.demodd.model.FileEntityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/demos")
@CrossOrigin(origins = "http://localhost:3000")
public class FileController {
    private static final Logger logger = Logger.getLogger(FileController.class.getName());
//    private final org.slf4j.Logger log = LoggerFactory.getLogger(FileController.class);
    private FileEntityRepository fileEntityRepository;

    public FileController(FileEntityRepository fileEntityRepository){this.fileEntityRepository = fileEntityRepository; }

    @GetMapping("/all")
    public Collection<FileEntity> fileEntitys() {
        return fileEntityRepository.findAll();
    }
    @GetMapping("/fileEntity/{id}")
    ResponseEntity<?> getDemo(@PathVariable Long id) {
        Optional<FileEntity> fileEntity = fileEntityRepository.findById(id);
        return fileEntity.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/fileEntity/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        fileEntityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }
        InputStream inputStream = file.getInputStream();
        String originalName = file.getOriginalFilename();
        String name = file.getName();
        String contentType = file.getContentType();
        long size = file.getSize();
        logger.info("inputStream: " + inputStream);
        logger.info("originalName: " + originalName);
        logger.info("name: " + name);
        logger.info("contentType: " + contentType);
        logger.info("size: " + size);
        // Do processing with uploaded file data in Service layer
        return new ResponseEntity<String>(originalName, HttpStatus.OK);
    }

        //@PostMapping("/upload")
//    public String handleUpload(HttpServletRequest request) throws Exception {
//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        factory.setRepository(
//                new File(System.getProperty("java.io.tmpdir")));
//        factory.setSizeThreshold(
//                DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD);
//        factory.setFileCleaningTracker(null);
//
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//        List items = upload.parseRequest(request);
//
//        Iterator iter = items.iterator();
//        while (iter.hasNext()) {
//            FileItem item = iter.next();
//
//            if (!item.isFormField()) {
//                try (
//                        InputStream uploadedStream = item.getInputStream();
//                        OutputStream out = new FileOutputStream("file.mov");) {
//
//                    IOUtils.copy(uploadedStream, out);
//                }
//            }
//        }
//        return "success!";
////    }
//    @PostMapping("/upload-avatar")
//    @ResponseBody
//    public ResponseEntity<String> fileUpload(MultipartFile avatar) {
//        try {
//
//            // upload directory - change it to your own
//            String UPLOAD_DIR = "/opt/uploads";
//
//            // create a path from file name
//            Path path = Paths.get(UPLOAD_DIR, avatar.getOriginalFilename());
//
//            // save the file to `UPLOAD_DIR`
//            // make sure you have permission to write
//            Files.write(path, avatar.getBytes());
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//            return new ResponseEntity<>("Invalid file format!!", HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>("File uploaded!!", HttpStatus.OK);
//    }
}
