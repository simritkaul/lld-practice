package com.simrit.patterns.document.events;

import java.util.HashSet;
import java.util.Set;

public class Publisher<T extends Event> {
    private final Set<Listener<T>> listeners;
    public Publisher() {
        this.listeners = new HashSet<>();
    }

    public void register(Listener<T> listener) {
        if (listener == null) throw new IllegalArgumentException("Listener cannot be null");
        listeners.add(listener);
    }

    public void remove(Listener<T> listener) {
        if (listener == null) throw new IllegalArgumentException("Listener cannot be null");
        listeners.remove(listener);
    }

    public void notify(T event) {
        if (event == null) throw new IllegalArgumentException("Event cannot be null");
        for (Listener<T> listener : listeners) {
            listener.onEvent(event);
        }
    }
}
