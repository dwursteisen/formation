package com.github.dwursteisen.generics.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.TimerTask;

/**
 * User: Wursteisen David
 * Date: 23/10/11
 * Time: 14:18
 */
public class MaitreDuTemps {

    final Collection<java.util.Timer> task = new ArrayList<java.util.Timer>();
    final Collection<MethodInformation> methods = new ArrayList<MethodInformation>();

    public void analyse(Object... objects) {
        for (Object obj : objects) {
            if (obj == null) {
                continue;
            }

            MethodInformation[] methodInformations = trouveMethods(obj);
            methods.addAll(Arrays.asList(methodInformations));
        }

    }

    public void demarrage() {

        for (MethodInformation method : methods) {
            TimerTask t = creationTimer(method.getMethod(), method.getParent());
            java.util.Timer timer = new java.util.Timer();
            timer.schedule(t, 0, method.getFrequence());
            task.add(timer);
        }

        methods.clear();
    }

    public void arret() {
        for (java.util.Timer timer : task) {
            timer.cancel();
        }
    }


    MethodInformation[] trouveMethods(Object obj) {
        Method[] methods = obj.getClass().getMethods();
        Collection<MethodInformation> methodAvecAnnotation = new ArrayList<MethodInformation>();

        for (Method method : methods) {
            Timer annotation = method.getAnnotation(Timer.class);
            if (annotation == null) {
                continue;
            }
            MethodInformation m = new MethodInformation(obj, method, annotation.frequence());
            methodAvecAnnotation.add(m);
        }
        return methodAvecAnnotation.toArray(new MethodInformation[methodAvecAnnotation.size()]);
    }

    TimerTask creationTimer(final Method method, final Object parent) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    method.invoke(parent);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (InvocationTargetException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

        };
        return task;
    }

    static class MethodInformation {
        private Object parent;
        private Method method;
        private int frequence;

        public MethodInformation(Object parent, Method m, int frequence) {
            this.parent = parent;
            this.method = m;
            this.frequence = frequence;
        }

        public Object getParent() {
            return parent;
        }

        public Method getMethod() {
            return method;
        }

        public int getFrequence() {
            return frequence;
        }
    }
}
