package Garage;

public interface ISubject {
    public void AttachObserver(IObserver observer);
    public void UnsubscribeObserver(IObserver observer);
    public void notifyObservers(Imessage imessage);
}
