package it.unibo.inner.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

import it.unibo.inner.api.IterableWithPolicy;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    final private T elements[];

    public IterableWithPolicyImpl(final T elements[]) {
        this.elements = elements;
    }

    @Override
    public Iterator<T> iterator() {
        return new Inner();
    }

    @Override
    public void setIterationPolicy(Predicate filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }

    public String toString() {
        return Arrays.toString(elements);
    }

    private class Inner implements Iterator<T> {

        private int current;

        @Override
        public boolean hasNext() {
            return this.current < Objects.requireNonNull(elements).length ? true : false;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                final T element = elements[this.current];
                this.current++;
                return element;
            }
            throw new NoSuchElementException();
        }
        
    } 
    
}
