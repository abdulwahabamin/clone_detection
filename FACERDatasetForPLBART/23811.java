        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "musicConnection.onServiceConnected() entry.");
            MusicBinder binder = (MusicBinder) service;
            //get service
            musicSrv = binder.getService();
            musicSrv.setShuffle(displayInfo.shuffle);
            musicSrv.setShuffleSeed(displayInfo.shuffleSeed);
            shuffleSpinner.setSelection(displayInfo.shuffle);
            initializeMusicServerPlaylist(playingInfo);
        }

