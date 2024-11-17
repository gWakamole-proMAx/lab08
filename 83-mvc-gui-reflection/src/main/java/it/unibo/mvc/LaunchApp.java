package it.unibo.mvc;

import java.util.List;

import it.unibo.mvc.api.DrawNumber;
import it.unibo.mvc.api.*;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberStdoutView;
import it.unibo.mvc.view.DrawNumberSwingView;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws Exception {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        //app.addView(new DrawNumberSwingView());
        //app.addView(new DrawNumberStdoutView());

        for (String string : List.of("Swing", "Stdout")) {
            final var clazz = Class.forName("it.unibo.mvc.view.DrawNumber" + string + "View");

            for (var constructor : clazz.getConstructors()) {
                final var instance = constructor.newInstance();

                for (int i = 0; i < 3; i++) {
                    if(DrawNumberView.class.isAssignableFrom(instance.getClass())) {
                    app.addView((DrawNumberView) instance);
                    }
                    else {
                        throw new IllegalStateException(instance.getClass() + "does not implement " + DrawNumberView.class + "interface");
                    }
                }
            }
        }
    }
}
