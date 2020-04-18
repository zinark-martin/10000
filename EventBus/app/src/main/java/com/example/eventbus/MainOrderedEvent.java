package com.example.eventbus;

public class MainOrderedEvent {
    public final String threadInfo;

    public MainOrderedEvent(String threadInfo) {
        this.threadInfo = threadInfo;
    }
}
