    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        try {
            switch (item.getItemId()) {
                case PARTY_SHUFFLE:
                    int shuffle = MusicUtils.sService.getShuffleMode();
                    if (shuffle == MediaPlaybackService.SHUFFLE_AUTO) {
                        MusicUtils.sService.setShuffleMode(MediaPlaybackService.SHUFFLE_NONE);
                    } else {
                        MusicUtils.sService.setShuffleMode(MediaPlaybackService.SHUFFLE_AUTO);
                    }
                    break;
                    
                case SEARCH_MUSIC: {
                    startSearch("", false, null, false);
                    return true;
                }
            }
        } catch (RemoteException ex) {
        }
        return super.onOptionsItemSelected(item);
    }

