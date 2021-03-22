package com.derek.palindromic.service;

import com.derek.palindromic.entity.Palin;

import java.util.List;

public interface PalinService {
    void savePalin(String origin);
    Palin findPalin(String origin);
    List<Palin> findAll();
    String getLongestPalindromicSubstring(String origin);
}
