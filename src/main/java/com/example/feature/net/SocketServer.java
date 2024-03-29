package com.example.feature.net;

import lombok.extern.slf4j.Slf4j;

import java.net.ServerSocket;

@Slf4j
public class SocketServer {

    public static void main(String[] args) {
        try (var server = new ServerSocket(9999);
             var client = server.accept();
             var in = client.getInputStream()) {
            log.info("Incoming " + new String(in.readAllBytes()));
        } catch (Exception e) {
            log.debug("Error", e);
        }
    }

}
