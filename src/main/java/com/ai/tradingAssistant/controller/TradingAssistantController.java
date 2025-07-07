package com.ai.tradingAssistant.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TradingAssistantController {

    @GetMapping("/news")
    public String getNews(@RequestParam String symbol) {
        return "News for " + symbol;
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
