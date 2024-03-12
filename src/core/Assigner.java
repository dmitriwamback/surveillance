package core;

import core.profiler.Profile;

public class Assigner {

    public enum Trust {
        Dishonor,
        Inferiority,
        Incompetent,
        Imperfection,
        Dissatisfaction,
    Neutral,
        Good,
        Satisfactory,
        Merit,
        Excellence,
        Honored,
    }
    
    public void assignUserStatus(int userUniqueId, String inputPrivateKey) {

        Profile profile = UserControlPanel.administrator.getProfileByUniqueID(userUniqueId, inputPrivateKey);
    }
}
