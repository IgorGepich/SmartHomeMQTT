package observer;

public interface IObserved {
	void addObserver(IObserver o);
	void removeObserver(IObserver o);
	void notifyObservers();
}
