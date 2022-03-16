    private void openFile(String file) throws RemoteException {
        // Stop, load and play
        MusicUtils.mService.stop();
        MusicUtils.mService.openFile(file);
        MusicUtils.mService.play();

        // Show now playing
        Intent nowPlayingIntent = new Intent(this, MusicLibrary.class)
        							.putExtra("started_from", "NOTIF_SERVICE");
        startActivity(nowPlayingIntent);
    }

