package com.filip.springboot.workhours.controller.api;

import com.filip.springboot.workhours.dto.response.Response;
import com.filip.springboot.workhours.repository.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/products")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    public ResponseEntity product() {
        logger.info("productcontroller class");
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping(value = "/productsuser")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    public ResponseEntity productuser() {
        logger.info("productcontroller for user class");
        return ResponseEntity.ok(productRepository.findAll());
    }
}
