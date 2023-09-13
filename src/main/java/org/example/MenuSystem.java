package org.example;

public class MenuSystem implements MenuState{

    private static MenuState activeMenu;
    private final static MenuSystem menuSystem = new MenuSystem();

    private MenuSystem(){
        activeMenu = new MainMenu();

    }

    public static MenuSystem getInstance(){
        return menuSystem;
    }

    public static void setState(MenuState selectedMenu){
        activeMenu = selectedMenu;
    }

    @Override
    public void execute() {
        activeMenu.execute();
    }
}
