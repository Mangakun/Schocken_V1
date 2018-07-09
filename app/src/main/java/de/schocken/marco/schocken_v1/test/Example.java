package de.schocken.marco.schocken_v1.test;

public class Example {

    private Delegate delegate;

    Example(Delegate delegate) {
        this.delegate = delegate;
    }

    public void doIt() {
        delegate.execute();
    }
}
