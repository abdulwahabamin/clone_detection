    public boolean isPlayingMusic() {
        try {
            if (getCurrentMediaPlayer().isPlaying())
                return true;
            else
                return false;

        } catch (Exception e) {

            return false;
        }

    }

