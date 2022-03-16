    /**
     * 下一首
     */
    public void nextMusic() {
        if (++currentItem >= songs.size()) {
            currentItem = 0;
        }
        playMusic(songs.get(currentItem).getPath());
    }

