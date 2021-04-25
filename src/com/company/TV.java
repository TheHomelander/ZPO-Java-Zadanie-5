package com.company;

public class TV {
    private String showPlaying;
    private String channelName;
    protected final String[] availableShows = {"Moda na sukces", "Sprawa dla reportera", "Dlaczego ja", "Pamiętniki z wakacji"};
    protected final String[] availableChannels = {"TVP1", "POLSAT", "TVP2", "TVN"};

    private final int minimumRandomInt = 0;
    private final String label;
    private static int iD = 0;

    TV(String showPlaying, String channelName){
        label = "TV" + iD;
        iD = iD + 1;
        this.channelName = channelName;
        this.showPlaying = showPlaying;
    }

    TV(){
        label = "TV" + iD;
        iD = iD + 1;
        setRandomParameters();
    }

    @Override
    public String toString() {
        return label + ":\n" +
                "SHOW PLAYING: " + showPlaying + "\n" +
                "CHANNEL NAME: " + channelName + "\n";
    }

    protected String getShowPlaying() {
        return showPlaying;
    }

    protected void setShowPlaying(String showPlaying) {
        this.showPlaying = showPlaying;
    }

    protected String getChannelName() {
        return channelName;
    }

    protected void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    private int returnRandomIntInRange(int max, int min)
    {
        int i = (int) (Math.random() * (max - min + 1)) + min;
        return i;
    }

    protected String getRandomShow(){
        return availableShows[returnRandomIntInRange(availableShows.length - 1, minimumRandomInt)];
    }

    protected String getRandomChannel(){
        return availableChannels[returnRandomIntInRange(availableChannels.length - 1, minimumRandomInt)];
    }

    protected boolean setRandomParameters() {
        channelName = getRandomChannel();
        showPlaying = getRandomShow();
        if( channelName != null && showPlaying != null)return true;
        return false;
    }
}
