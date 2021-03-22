package com.derek.palindromic.service;

import com.derek.palindromic.entity.Palindromic;

import java.util.List;

public interface PalindromicService {
    void savePalindromic(String origin);
    Palindromic findPalindromic(String origin);
    List<Palindromic> findAll();
    String getLongestPalindromicSubstring(String origin);
}
