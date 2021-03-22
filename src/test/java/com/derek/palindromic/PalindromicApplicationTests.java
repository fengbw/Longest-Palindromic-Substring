package com.derek.palindromic;

import com.derek.palindromic.controller.PalindromicController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PalindromicApplicationTests {

    @Autowired
    private MockMvc mvc;

    // test longest palindromic substring result for case "aabab"
    @Test
    public void givenInput1_returnPalindromic_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/palindromic/aabab")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.origin").value("aabab"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.longest_palindromic").value("aba"));
    }

    // test longest palindromic substring result for case "babba"
    @Test
    public void givenInput2_returnPalindromic_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/palindromic/babba")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.origin").value("babba"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.longest_palindromic").value("abba"));
    }

    // test /getAll can return correct result
    @Test
    public void getAll_returnAllPalindromic_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/palindromic/aabab"));
        mvc.perform(MockMvcRequestBuilders.get("/palindromic/babba"));
        mvc.perform(MockMvcRequestBuilders
                .get("/palindromic/getAll"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].origin").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].origin").exists());
    }
}
