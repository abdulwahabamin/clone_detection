    /**
     * Queue files in directory to play
     * @param dir Directory
     */
    private void playDirectory(String dir) {
        currentFolderText.setText(dir);
        Intent i = new Intent(this, PlayerService.class);
        i.setAction(PlayerService.ACTION_PLAY_DIRECTORY);
        i.putExtra("directory", dir);
        startService(i);
        playButton.setImageResource(android.R.drawable.ic_media_pause);
        mUpdateProgress = true;
        handler.post(mUpdateRunnable);
    }

