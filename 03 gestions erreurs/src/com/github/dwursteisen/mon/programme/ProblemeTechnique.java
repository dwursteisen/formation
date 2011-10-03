package com.github.dwursteisen.mon.programme;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 03/10/11
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 */
public class ProblemeTechnique extends Exception {

    ProblemeTechnique(Throwable ex) {
        super(ex);
    }

    public ProblemeTechnique(String msg) {
        super(msg);
    }

    ProblemeTechnique(String msg, Throwable ex) {
        super(msg, ex);
    }
}
