package com.ai.tradingAssistant.controller;


import com.ai.tradingAssistant.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TradingAssistantController {

    @Autowired
    private NewsService newsService;
    @GetMapping("/news")
    public List<String> getNews(@RequestParam String symbol) {

        return newsService.getNewsHeadlines(symbol);
    }

    @GetMapping("/summary")
    public String getSummary(@RequestParam String symbol) {
        return "Summary for " + symbol;
    }

    @GetMapping("/performance")
    public String getPerformance(@RequestParam String symbol) {
        return "Performance for " + symbol;
    }

    @GetMapping("/explain")
    public String explainTerm(@RequestParam String term) {
        return "Explanation for " + term;
    }
}
