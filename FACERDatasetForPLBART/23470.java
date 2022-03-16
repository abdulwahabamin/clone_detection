    private void updateMenu() {
        try {
            if (MusicUtils.sService != null && MusicUtils.sService.getAudioId() != -1) {
                makeNowPlayingView();
                mNowPlayingView.setVisibility(View.VISIBLE);
                return;
            }
        } catch (RemoteException ex) {
        }
        mNowPlayingView.setVisibility(View.INVISIBLE);
    }

