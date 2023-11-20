package Observer;

import java.util.HashSet;
import java.util.Set;

public class NotificationManager implements Observed {
    private Set<Observer> observers = new HashSet<>();
    private String message;

    public Set<Observer> getObservers() {
        return observers;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : getObservers()) {
            observer.handleMessage(message);
        }
    }
}
