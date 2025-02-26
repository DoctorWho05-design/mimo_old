package mimo.Controller.Plugin;

import plugins.Discord.Discord;
import plugins.GenshinImpact.GenshinImpact;
import plugins.NexusChronicals.NexusChronicals;
import plugins.Satisfactory.Satisfactory;
import plugins.Spotify.Spotify;

public class PluginMapFactory {

    private PluginMap mTempMap;

    public PluginMapFactory() {
        mTempMap = new PluginMap();
    }

    public PluginMapFactory editPluginMap(PluginMap mPluginMap) {
        this.mTempMap = mPluginMap;
        return this;
    }

    public PluginMapFactory addSpotify() {
        mTempMap.put("Spotify", new Spotify());
        return this;
    }

    public PluginMapFactory addSatisfactory() {
        mTempMap.put("Satisfactory", new Satisfactory());
        return this;
    }

    public PluginMapFactory addGenshinImpact() {
        mTempMap.put("GenshinImpact", new GenshinImpact());
        return this;
    }

    public PluginMapFactory addNexusChronicals() {
        mTempMap.put("NexusChronicals", new NexusChronicals());
        return this;
    }

    public PluginMapFactory addDiscord() {
        mTempMap.put("Discord", new Discord());
        return this;
    }

    public PluginMap build() {
        return mTempMap;
    }

    public PluginMapFactory addPlugin(String mKey) {
        switch (mKey) {
            case "Spotify":
                this.addSpotify();        
            break;
            
            case "Satisfactory":
                this.addSatisfactory();
            break;

            case "Discord":
                this.addDiscord();
            break;

            case "GenshinImpact":
                this.addGenshinImpact();
            break;

            case "NexusChronicals":
                this.addNexusChronicals();
            break;
        }

        return this;
    }
 
    /* //!Template
    public PluginMapFactory add() {

        return this;
    }
     */
}
