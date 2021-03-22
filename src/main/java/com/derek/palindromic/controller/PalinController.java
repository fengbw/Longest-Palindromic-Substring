package com.derek.palindromic.controller;

import com.derek.palindromic.entity.Palin;
import com.derek.palindromic.service.PalinServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/palin")
public class PalinController {
    PalinServiceImpl palinServiceImpl;

    PalinController(PalinServiceImpl palinServiceImpl) {
        this.palinServiceImpl = palinServiceImpl;
    }

    @GetMapping("/{origin}")
    public Palin getLongestPalindromicSubstring(@PathVariable String origin) {
        return palinServiceImpl.findPalin(origin);
    }

    @GetMapping("/getAll")
    public List<Palin> getAll() {
        return palinServiceImpl.findAll();
    }
}
