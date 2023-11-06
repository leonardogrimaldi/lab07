package it.unibo.inner.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

import it.unibo.inner.api.IterableWithPolicy;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    final private T elements[];

    public IterableWithPolicyImpl(final T elements[]) {
        this.elements = elements;
    }

    @Override
    public Iterator iterator() {
        return new Inner();
    }

    @Override
    public void setIterationPolicy(Predicate filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }

    private class Inner implements Iterator<T> {

        private int current;

        @Override
        public boolean hasNext() {
            return this.current < Objects.requireNonNull(elements).length - 1 ? true : false;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                this.current++;
                return elements[this.current];
            }
            return null;
        }
        
    } 
    
}
