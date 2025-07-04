package org.example.hogwartssql111.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
    public class InfoController {

        @Value("${server.port}")
        private int port;

        @GetMapping("/port")
        public int getPort() {
            return port;
        }
}
