package core;

import core.profiler.Profile;

public class Assigner {
    
    public void assignUserStatus(int userUniqueId, String inputPrivateKey) {

        Profile profile = UserControlPanel.administrator.getProfileByUniqueID(userUniqueId, inputPrivateKey);
    }
}
