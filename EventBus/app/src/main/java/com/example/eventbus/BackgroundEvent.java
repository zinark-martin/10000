package com.example.eventbus;

public class BackgroundEvent {
    public final String threadInfo;

    public BackgroundEvent(String threadInfo) {
        this.threadInfo = threadInfo;
    }
}
