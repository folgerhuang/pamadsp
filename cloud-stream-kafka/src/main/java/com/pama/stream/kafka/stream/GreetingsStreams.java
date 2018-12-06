package com.pama.stream.kafka.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface GreetingsStreams {
    String INPUT = "greetins-in";
    String OUT = "greetings-out";

    @Input(INPUT)
    SubscribableChannel inboundGreatings();

    @Output(OUT)
    MessageChannel outboundGreatings();
}
