package core;

import administrator.Administrator;
import core.profiler.Profile;

public class UserControlPanel {
    public static Administrator administrator;

    public void run() {
        administrator = Administrator.createAdministrator();
        Profile p = new Profile();
    }
}
