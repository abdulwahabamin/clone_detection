    private void playOrEnqueuFile(String file, long id, boolean enqueue) {
        final long[] list = new long[] {id};
        if (!enqueue) {
            //Remove the actual queue
            MusicUtils.removeAllTracks();
            MusicUtils.playAll(getApplicationContext(), list, 0);
        }
        else {
            MusicUtils.addToCurrentPlaylist(getApplicationContext(), list);
        }

        // Show now playing
        Intent intent = new Intent(this, MusicLibrary.class);
        intent.putExtra("started_from", "NOTIF_SERVICE");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

