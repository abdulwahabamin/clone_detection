    /**
     * Set the play and pause image
     */
    private void setPauseButtonImage() {
        try {
            if (MusicUtils.mService != null && MusicUtils.mService.isPlaying()) {
                mPlay.setImageResource(R.drawable.apollo_holo_light_pause);
            } else {
                mPlay.setImageResource(R.drawable.apollo_holo_light_play);
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

