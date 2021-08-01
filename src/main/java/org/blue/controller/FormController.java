package org.blue.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Blue
 * @date 2021/8/1
 */
@Controller
@Log4j2
public class FormController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     *
     * @param email
     * @param username
     * @param headerImage
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email, @RequestParam("username") String username,
                         @RequestPart("headerImage") MultipartFile headerImage,@RequestPart("photos") MultipartFile[] photos){
        log.info("email={},username={},headerImage={},photos={}",email,username,headerImage.getSize(),photos.length);
        if(!headerImage.isEmpty()){
            String originalFilename = headerImage.getOriginalFilename();
            try {
                headerImage.transferTo(new File("D:\\temp\\"+originalFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (MultipartFile photo : photos) {
            if(!photo.isEmpty()){
                String originalFilename = photo.getOriginalFilename();
                try {
                    photo.transferTo(new File("D:\\temp\\"+originalFilename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "index";
    }

}
