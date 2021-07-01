package org.joychou.controller;

import org.apache.commons.codec.binary.Base64;
import org.joychou.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

@RestController
public class PathTraversal {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * http://localhost:8080/path_traversal/vul?filepath=../../../../../etc/passwd
     */


    @GetMapping("/path_traversal/vul")
    public String getbase64Image(String filepath) throws IOException {
        return getImgBase64(filepath);
    }


    @GetMapping(value = "/path_traversal/vuln", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(String filepath) throws IOException {
    Path path = Paths.get(filepath);
      byte[] data = Files.readAllBytes(path);
    return data;
    }

    //Can lead to Backdoors, RCE
    @GetMapping(value = "/path_traversal/vu", produces = MediaType.TEXT_HTML_VALUE)
    public @ResponseBody byte[] getFile(String filepath) throws IOException {
    Path path = Paths.get(filepath);
      byte[] data = Files.readAllBytes(path);
    return data;
    }


    @GetMapping("/path_traversal/sec")
    public String getImageSec(String filepath) throws IOException {
        if (SecurityUtil.pathFilter(filepath) == null) {
            logger.info("Illegal file path: " + filepath);
            return "Dude Not cool. Illegal file path.";
        }
        return getImgBase64(filepath);
    }

    private String getImgBase64(String imgFile) throws IOException {

        logger.info("Working directory: " + System.getProperty("user.dir"));
        logger.info("File path: " + imgFile);

        File f = new File(imgFile);
        if (f.exists() && !f.isDirectory()) {
            byte[] data = Files.readAllBytes(Paths.get(imgFile));
            return new String(Base64.encodeBase64(data));
        } else {
            return "File doesn't exist or is not a file.";
        }
    }


}