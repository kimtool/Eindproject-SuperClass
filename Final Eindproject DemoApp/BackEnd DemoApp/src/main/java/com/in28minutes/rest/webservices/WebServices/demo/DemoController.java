package com.in28minutes.rest.webservices.WebServices.demo;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Gebruiker
 */

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class DemoController {   
    
    private final DemoJpaRespository demoRepository;
    
    public DemoController(DemoJpaRespository fileEntityRepository){this.demoRepository = fileEntityRepository; }
    
    @GetMapping("/users/{userId}/demos")
    public List<Demo> getAllDemos(@PathVariable Long userId){
        return demoRepository.findByUserId(userId);
        //return demoService.findAll();
    }    
    @GetMapping("/users/{userId}/demos/{id}")
    public Demo getDemo(@PathVariable Long userId, @PathVariable long id){
        return demoRepository.findById(id).get();
        //return demoService.findById(id);
    } 
    
    //DELETE /users/{username}/demos/{id}
    @DeleteMapping("/users/{userId}/demos/{id}")
    public ResponseEntity<Void> deleteDemo(@PathVariable Long userId, @PathVariable long id){
        demoRepository.deleteById(id);
        
        return ResponseEntity.noContent().build();           
    }
    
//    //Edit/Update a Demo
    @PutMapping("/users/{userId}/demos/{id}")
    public ResponseEntity<Demo> updateDemo(
            @PathVariable Long userId, 
            @PathVariable long id, @RequestBody Demo demo){
//        demo.setUsername(username);
        Demo demoUpdated = demoRepository.save(demo);
        return new ResponseEntity<Demo>(demo, HttpStatus.OK); //gives more options in the future if you want to return other statusses
    }

    //Create a new Demo
    @PostMapping("/users/{userId}/demos")
    public ResponseEntity<String> uploadDemo (@PathVariable Long userId, Demo demo, @NotNull @RequestParam("trackname") String trackname,@RequestParam("file") MultipartFile multipartFile){
        String status="";
        if (!multipartFile.isEmpty()) {
            try {
                Demo file = new Demo(multipartFile.getOriginalFilename(), multipartFile.getContentType(), 
                        demo.getUser(), demo.getDescription(), multipartFile.getBytes());
                file.setTrackName(trackname);

                demoRepository.save(file);

                status = status +  " Successfully uploaded file=" + multipartFile.getOriginalFilename();
            } catch (Exception e) {
                status = status +  "Failed to upload " + multipartFile.getOriginalFilename()+ " " + e.getMessage();
            }
        }
        return ResponseEntity.ok(status);
    }
    
}