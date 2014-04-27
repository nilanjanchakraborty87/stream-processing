package com.github.mperry.streams;

import fj.F;
import fj.P1;
import fj.data.Stream;

/**
 * Created by MarkPerry on 27/04/2014.
 *
 * Halt indicates to the driver that no more elements should be read from the input stream
 * or emitted to the output.
 */
public class Halt<I, O> extends Process<I, O> {

    public Halt() {
    }

    public Stream<O> apply(Stream<I> s) {
        return Stream.<O>nil();
    }

    @Override
    public <O2> Process<I, O2> map(F<O, O2> f) {
        return new Halt<>();
    }

    @Override
    public Process<I, O> append(P1<Process<I, O>> p) {
        return p._1();
    }

    @Override
    public <O2> Process<I, O2> flatMap(F<O, Process<I, O2>> f) {
        return new Halt<>();
    }

}
