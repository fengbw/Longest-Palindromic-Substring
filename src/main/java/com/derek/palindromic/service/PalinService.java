package com.derek.palindromic.service;

public interface PalinService {
    public void savePalin(String origin);
    public String findPalin(String origin);
    public String getLongestPalindromicSubstring(String origin);
}
