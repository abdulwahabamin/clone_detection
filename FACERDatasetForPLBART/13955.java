    private void openFile(String file) throws RemoteException {
        // Stop, load and play
        MusicUtils.mService.stop();
        MusicUtils.mService.openFile(file);
        MusicUtils.mService.play();

        // Show now playing
        Intent nowPlayingIntent = new Intent(this, AudioPlayerHolder.class);
        startActivity(nowPlayingIntent);
    }

