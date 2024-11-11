package com.microservices;
//
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//
import com.microservices.ChatApplication.ChatMessage;
import com.microservices.ChatApplication.MessageType;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class WebScoketEventListener {
//
//    private final SimpMessageSendingOperations messagingTemplate;
//
//    @EventListener
//    //chat disconnect event
////    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
////        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
////        String username = (String) headerAccessor.getSessionAttributes().get("username");
////        if (username != null) {
////        log.info("user disconnected: {}", username);	
////           var chatMessage = ChatMessage.builder()  //ChatMessage.builder()	
////        		   .type(MessageType.LEAVE)
////        	.sender(username)
////                    .build();
////            messagingTemplate.convertAndSend("/topic/public", chatMessage);
////        }
////    }
//   
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//        if (username != null) {
//            log.info("user disconnected: {}", username);
//            var chatMessage = ChatMessage.builder()
//                    .type(MessageType.LEAVE)
//                    .sender(username)
//                    .build();
//            messagingTemplate.convertAndSend("/topic/public", chatMessage);
//        }
//    }
//
//}




//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class WebScoketEventListener {
//
//    private final SimpMessageSendingOperations messagingTemplate;
//
//    @EventListener
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//        if (username != null) {
//            log.info("user disconnected: {}", username);
//            var chatMessage = ChatMessage.builder()
//                    .type(MessageType.LEAVE)
//                    .sender(username)
//                    .build();
//            messagingTemplate.convertAndSend("/topic/public", chatMessage);
//        }
//    }
//
//}
//

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebScoketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            log.info("user disconnected: {}", username);
            var chatMessage = ChatMessage.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }

}

