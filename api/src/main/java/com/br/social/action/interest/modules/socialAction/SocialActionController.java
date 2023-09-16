package com.br.social.action.interest.modules.socialAction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/social-actions")
public class SocialActionController {

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(name = "name", required = false, defaultValue = "") String name) {
        return ResponseEntity.ok("Hello World! " + name);
    }}
