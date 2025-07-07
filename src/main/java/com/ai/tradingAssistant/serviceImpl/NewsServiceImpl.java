package com.ai.tradingAssistant.serviceImpl;

import com.ai.tradingAssistant.service.NewsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

@Slf4j
@Service
public class NewsServiceImpl implements NewsService {

    @Value("${api_key}")
   String API_KEY ;
    private final String BASE_URL = "https://newsapi.org/v2/everything";

    public List<String> getNewsHeadlines(String symbol) {
        List<String> headlines = new ArrayList<>();
        try {
            String url = BASE_URL + "?q=" + symbol + "&apiKey=" + API_KEY;
            log.info("url is" +url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info("response is"+ response.toString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());
            JsonNode articles = root.path("articles");

            for (int i = 0; i < Math.min(5, articles.size()); i++) {
                headlines.add(articles.get(i).get("title").asText());
            }
        } catch (Exception e) {
            headlines.add("Failed to fetch news: " + e.getMessage());
        }
        return headlines;
    }
}
