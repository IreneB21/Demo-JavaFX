module com.formation.basefx {
    requires javafx.controls;
    requires java.desktop;

    exports com.formation.basefx;
    exports com.formation.basefx.exercices;
    exports com.formation.basefx.layout;
    exports com.formation.basefx.event;
    exports com.formation.basefx.event.transition;
    exports com.formation.basefx.composant;
    exports com.formation.basefx.mvvm;
    exports com.formation.basefx.mvvm.model;
    exports com.formation.basefx.mvvm.view;
    exports com.formation.basefx.mvvm.viewmodel;
    exports com.formation.basefx.vvm;
}