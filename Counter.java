public class Counter {

    // instance variables

    int count;

    // constructor, creates counter with given initial count
    public Counter(int initialCount) {
        this.setCount(initialCount);
    }

    // methods

    // increments the count
    public void increment() {
        this.count++;
    }

    // returns the current count number
    public int getCount() {
        return this.count;
    }

    // sets a new count
    public void setCount(int newCount) {
        this.count = newCount;
    }
}
