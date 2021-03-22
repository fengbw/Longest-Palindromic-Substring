package com.derek.palindromic.service;

import com.derek.palindromic.entity.Palindromic;
import com.derek.palindromic.repository.PalindromicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PalindromicServiceImpl implements PalindromicService{

    PalindromicRepository palindromicRepository;

    public PalindromicServiceImpl(PalindromicRepository palindromicRepository) {
        this.palindromicRepository = palindromicRepository;
    }

    @Override
    public void savePalindromic(String origin) {
        String longest = getLongestPalindromicSubstring(origin);
        palindromicRepository.save(new Palindromic(origin, longest));
    }

    @Override
    public Palindromic findPalindromic(String origin) {
        Optional<Palindromic> palinOptional = palindromicRepository.findByOrigin(origin);
        if (palinOptional.isPresent()) {
            return palinOptional.get();
        }
        String longest = getLongestPalindromicSubstring(origin);
        Palindromic palinEntity = new Palindromic(origin, longest);
        palindromicRepository.save(palinEntity);
        return palinEntity;
    }

    @Override
    public List<Palindromic> findAll() {
        return palindromicRepository.findAll();
    }

    @Override
    public String getLongestPalindromicSubstring(String origin) {
        String res = "";
        for (int i = 0; i < origin.length(); i++){
            String temp = helper(origin, i, i);
            if (temp.length() > res.length()) res = temp;
            temp = helper(origin, i, i + 1);
            if (temp.length() > res.length()) res = temp;
        }
        return res;
    }

    public String helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
