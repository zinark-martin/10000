package com.example.eventbus;

public class AsyncEvent {
    public final String threadInfo;

    public AsyncEvent(String threadInfo) {
        this.threadInfo = threadInfo;
    }
}
