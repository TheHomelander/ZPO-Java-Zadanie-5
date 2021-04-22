package com.company;

public class TV {
    private String showPlaying;
    private String channelName;
    protected final String[] availableShows = {"Moda na sukces", "Sprawa dla reportera", "Dlaczego ja", "Pamiętniki z wakacji"};
    protected final String[] availableChannels = {"TVP1", "POLSAT", "TVP2", "TVN"};

    private final int minimumRandomInt = 1;
    private final String label;
    private static int iD = 0;

    TV(String showPlaying, String channelName){
        label = "TV" + iD;
        iD = iD + 1;
        this.channelName = channelName;
        this.showPlaying = showPlaying;
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
        return (int) (Math.random() * max + min);
    }

    protected String getRandomShow(){
        return availableShows[returnRandomIntInRange(availableShows.length, minimumRandomInt)];
    }

    protected String getRandomChannel(){
        return availableChannels[returnRandomIntInRange(availableChannels.length, minimumRandomInt)];
    }

}
