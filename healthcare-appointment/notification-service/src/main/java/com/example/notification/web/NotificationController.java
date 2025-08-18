package com.example.notification.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/notify")
public class NotificationController {
    private static final Logger log = LoggerFactory.getLogger(NotificationController.class);

    @PostMapping
    public ResponseEntity<String> notifyNow(@RequestBody Map<String, Object> body){
        // simulate async processing
        asyncSend(body);
        return ResponseEntity.accepted().body("Notification queued");
    }

    @Async
    public CompletableFuture<Void> asyncSend(Map<String, Object> body){
        log.info("Sending notification: {}", body);
        return CompletableFuture.completedFuture(null);
    }
}
