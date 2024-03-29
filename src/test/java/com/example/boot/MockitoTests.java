package com.example.boot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTests {

    @Mock
    List<String> tests;

    @Spy
    Map<String, String> mappings;

    @Test
    void test_mappings_ok() {
        when(tests.size()).thenReturn(2);
        assertEquals(2, tests.size());
        mappings.put("test", "me");
        verify(mappings).put("test", "me");
    }

    @Test
    void test_json_write_ok() throws JsonProcessingException {
        var mapper = new ObjectMapper();

        @Data
        @AllArgsConstructor
        class Dummy {
            private Long id;
            @JsonIgnore
            private String title;
        }
        var jsonDummy = mapper.writeValueAsString(new Dummy(1L, "hello"));

        assertEquals("{\"id\":1}", jsonDummy, "null");
    }

    @Test
    void test_httpclient_get_ok() throws URISyntaxException, IOException, InterruptedException {
        var httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
        var request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/todos/1"))
                .GET()
                .build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        var mapper = new ObjectMapper();
        var jsonNode = mapper.readTree(response.body());

        assertEquals(1, jsonNode.get("id").asInt());
    }

}
