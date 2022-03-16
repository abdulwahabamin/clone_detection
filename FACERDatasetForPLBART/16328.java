    /**
     * 上一首
     */
    public void prevMusic() {
        if (--currentItem < 0) {
            currentItem = songs.size() - 1;
        }
        playMusic(songs.get(currentItem).getPath());
    }

