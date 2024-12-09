package com.formation.basefx.mvvm;

import com.formation.basefx.mvvm.model.Person;
import com.formation.basefx.mvvm.view.MainView;
import com.formation.basefx.mvvm.viewmodel.PersonViewModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Person person = new Person("Jean", "Dutronc");
        PersonViewModel viewModel = new PersonViewModel(person);
        MainView view = new MainView(viewModel);

        view.start(stage);
    }
}
