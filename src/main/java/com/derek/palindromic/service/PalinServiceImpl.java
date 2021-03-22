package com.derek.palindromic.service;

import com.derek.palindromic.entity.Palin;
import com.derek.palindromic.repository.PalinRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PalinServiceImpl implements PalinService{

    PalinRepository palinRepository;

    public PalinServiceImpl(PalinRepository palinRepository) {
        this.palinRepository = palinRepository;
    }

    @Override
    public void savePalin(String origin) {
        String longest = getLongestPalindromicSubstring(origin);
        palinRepository.save(new Palin(origin, longest));
    }

    @Override
    public String findPalin(String origin) {
        Optional<Palin> palinOptional = palinRepository.findByOrigin(origin);
        if (palinOptional.isPresent()) {
            return palinOptional.get().getLongestpalin();
        }
        String longest = getLongestPalindromicSubstring(origin);
        Palin palinEntity = new Palin(origin, longest);
        palinRepository.save(palinEntity);
        return longest;
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
