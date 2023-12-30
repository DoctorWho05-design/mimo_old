package mimo.Controller.Workspace;

import mimo.Controller.Plugin.PluginMap;
import mimo.Controller.Plugin.PluginMapFactory;

public class Workspace {
    private String mWorkspaceName;
    protected PluginMap mPluginMap;

    public Workspace(String mWorkspaceName) {
        initWorksapce(mWorkspaceName);
    }

    private void initWorksapce(String mWorkspaceName) {
        this.mWorkspaceName = mWorkspaceName;
    }

    public String getName() {return mWorkspaceName;}

    public void addPlugin(String mKey) {
        PluginMapFactory mFactory = new PluginMapFactory();
        mFactory.editPluginMap(mPluginMap);
        switch (mKey) {
            case "Spotify":
                mFactory.addSpotify();        
            break;
            
            case "Satisfactory":
                mFactory.addSatisfactory();
            break;

            case "Discord":
                mFactory.addDiscord();
            break;

            case "GenshinImpact":
                mFactory.addGenshinImpact();
            break;

            case "NexusChronicals":
                mFactory.addNexusChronicals();
            break;
        }

        mPluginMap = mFactory.build();
    }
    
}
