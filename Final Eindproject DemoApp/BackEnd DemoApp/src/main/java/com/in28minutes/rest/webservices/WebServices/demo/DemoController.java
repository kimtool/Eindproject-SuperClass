package com.in28minutes.rest.webservices.WebServices.demo;

import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Gebruiker
 */

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class DemoController {   
    
    public DemoController(DemoJpaRespository fileEntityRepository){this.demoJpaRespository = fileEntityRepository; }
    
    private static final Logger logger = Logger.getLogger(DemoController.class.getName());
    
    @Autowired
    private DemoJpaRespository demoJpaRespository;
    
    @GetMapping("/users/{username}/demos")
    public List<Demo> getAllDemos(@PathVariable String username){
        return demoJpaRespository.findByUsername(username);
        //return demoService.findAll();
    }    
    @GetMapping("/users/{username}/demos/{id}")
    public Demo getDemo(@PathVariable String username, @PathVariable long id){
        return demoJpaRespository.findById(id).get();
        //return demoService.findById(id);
    } 
    
    //DELETE /users/{username}/demos/{id}
    @DeleteMapping("/users/{username}/demos/{id}")
    public ResponseEntity<Void> deleteDemo(@PathVariable String username, @PathVariable long id){
        demoJpaRespository.deleteById(id);
        
        return ResponseEntity.noContent().build();           
    }
    
//    //Edit/Update a Demo
    @PutMapping("/users/{username}/demos/{id}")
    public ResponseEntity<Demo> updateDemo(
            @PathVariable String username, 
            @PathVariable long id, @RequestBody Demo demo){
        demo.setUsername(username);
        Demo demoUpdated = demoJpaRespository.save(demo);
        return new ResponseEntity<Demo>(demo, HttpStatus.OK); //gives more options in the future if you want to return other statusses
    }
    
//    @PutMapping("/users/{username}/demos/{id}")
//    public Demo updateDemo(@PathVariable String username, @PathVariable long id, @RequestBody Demo demo){
//        Demo demoUpdated = demoService.save(demo);
//        return demoUpdated;
//    }

    //Create a new Demo
//    @PostMapping("/users/{username}/demos")
//    public ResponseEntity<Void> createDemo(
//            @PathVariable String username, @RequestBody Demo demo){ 
//    
//    //when saving demo details, details contain username. Set username into demo
//        demo.setUsername(username);
//        Demo createdDemo = demoJpaRespository.save(demo);
//        
//        //Location
//        ///users/{username}/demos{id}
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(createdDemo.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }  
    
//    @PostMapping("/users/{username}/demos")
//    public ResponseEntity<String> uploadData(@PathVariable String username, @RequestBody Demo demo, MultipartFile file) throws Exception {
//        if (file == null) {
//            throw new RuntimeException("You must select the a file for uploading");
//        }
//        InputStream inputStream = file.getInputStream();
//        String originalName = file.getOriginalFilename();
//        String name = file.getName();
//        String contentType = file.getContentType();
//        long size = file.getSize();
//        logger.info("inputStream: " + inputStream);
//        logger.info("originalName: " + originalName);
//        logger.info("name: " + name);
//        logger.info("contentType: " + contentType);
//        logger.info("size: " + size);
//        // Do processing with uploaded file data in Service layer
//        return new ResponseEntity<String>(originalName, HttpStatus.OK);
//    }
    
}