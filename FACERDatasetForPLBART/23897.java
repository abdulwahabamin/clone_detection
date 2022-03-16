    private void notifyMainActivity(String status) {
        Log.d(TAG, "notifyMainActivity(" + status + ") entry.");
        // Let the Main Activity know we are playing the song.
        Intent playingIntent = new Intent(status);
        int trackIndex = 0;
        if (playingIndexInfo != null)
            trackIndex = playingIndexInfo.getTrackIndex();
        playingIntent.putExtra("songIndex", trackIndex);
        LocalBroadcastManager.getInstance(this).sendBroadcast(playingIntent);
    }

