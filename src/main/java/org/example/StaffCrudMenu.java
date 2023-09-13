package org.example;

import java.util.List;

public class StaffCrudMenu extends Menu {


    public StaffCrudMenu() {
        super("Employee CRUD menu ");
        menuOptions = List.of(
                new MenuOption(1, "Add a new staff.", () -> MenuSystem.setState(new StaffAddition()) ),
                new MenuOption(2, "Delete a staff.", () -> MenuSystem.setState(new StaffDeletion()) ),
                new MenuOption(3, "Modify staff details.", () -> MenuSystem.setState(new StaffModification()) ),
                new MenuOption( 4, "Go to main menu.", () -> MenuSystem.setState(new MainMenu()))
        );
    }



}
