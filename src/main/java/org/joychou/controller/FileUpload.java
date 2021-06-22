package org.joychou.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * File upload.
 *
 * 
 */
@Controller
@RequestMapping("/file")
public class FileUpload {


    private static String OS = System.getProperty("os.name").toLowerCase();
    
    // Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D:\\";
    // private static String UPLOADED_FOLDER = "/tmp/";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index() {
        return "upload"; // return upload.html page
    }

    @GetMapping("/pic")
    public String uploadPic() {
        return "uploadPic"; // return uploadPic.html page
    }

    @PostMapping("/upload/picture")
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            // 赋值给uploadStatus.html里的动态参数message
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            System.out.println("Empty File");
            return "Please select a file to upload";
        }
        if(OS.indexOf("win") >= 0)
            {
                UPLOADED_FOLDER = "D:\\";
            }
            else if (OS.indexOf("mac") >= 0 || OS.indexOf("nix") >= 0
            || OS.indexOf("nux") >= 0
            || OS.indexOf("aix") > 0)
            {
                UPLOADED_FOLDER = "/usr/local/tomcat/temp/";
            }
            else
            {
                UPLOADED_FOLDER = "/tmp/";
            }

        try {
            // Get the file and save it somewhere
            
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + UPLOADED_FOLDER + file.getOriginalFilename() + "'");
          logger.info("[+] You successfully uploaded:" + UPLOADED_FOLDER + file.getOriginalFilename());

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "upload failed");
            e.printStackTrace();
            return "upload failed to"+UPLOADED_FOLDER+" due to Exception "+ e.getMessage();
        }

     //return "Uploaded to /tmp/";
       return "You successfully uploaded '" + UPLOADED_FOLDER + file.getOriginalFilename() + "'";
    }






}

