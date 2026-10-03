package com.example.feature.net;

import com.example.boot.cloud.TypicodePost;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

@Slf4j
public class NetApplication {

    public static void main(String[] args) {
        try {
            var url = new URL("https://jsonplaceholder.typicode.com/posts/");
            var connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            var mapper = new ObjectMapper();
            try (var ins = new BufferedInputStream(connection.getInputStream())) {
                var result = mapper.readTree(new String(ins.readAllBytes()));
                var posts = mapper.treeToValue(result, TypicodePost[].class);
                Arrays.stream(posts).findAny().ifPresent(p -> log.info("{}", p.getBody()));
            }

        } catch (MalformedURLException mfe) {
            log.error("URl is malformed", mfe);
            throw new RuntimeException(mfe);
        } catch (IOException e) {
            log.error("No connection", e);
            throw new RuntimeException(e);
        }
    }

}
