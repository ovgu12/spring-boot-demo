package com.example.feature.net;

import lombok.extern.slf4j.Slf4j;

import java.net.Socket;

@Slf4j
public class SocketClient {

    public static void main(String[] args) {
        try (var client = new Socket("localhost", 9999);
             var out = client.getOutputStream()) {
            out.write("abc".getBytes());
        } catch (Exception e) {
            log.debug("Error", e);
        }
    }

}
