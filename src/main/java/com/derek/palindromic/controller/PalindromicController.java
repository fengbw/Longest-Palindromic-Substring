package com.derek.palindromic.controller;

import com.derek.palindromic.entity.Palindromic;
import com.derek.palindromic.service.PalindromicServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/palindromic")
public class PalindromicController {
    PalindromicServiceImpl palindromicServiceImpl;

    PalindromicController(PalindromicServiceImpl palindromicServiceImpl) {
        this.palindromicServiceImpl = palindromicServiceImpl;
    }

    // make input as path parameter since it is required
    @GetMapping("/{origin}")
    public Palindromic getLongestPalindromicSubstring(@PathVariable String origin) {
        return palindromicServiceImpl.findPalindromic(origin);
    }

    // use /getAll to access all results in database
    @GetMapping("/getAll")
    public List<Palindromic> getAll() {
        return palindromicServiceImpl.findAll();
    }
}
