package com.simrit.patterns.document.events;

public interface Listener<T extends Event> {
    void onEvent(T event);
}
