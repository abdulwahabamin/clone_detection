    @Override
    public void onServiceConnected(MediaPlayback s) {
        service = s;

        if (service.getAudioId() != -1) {
            setPauseButtonImage();
            totalTime.setText(MusicUtils.formatDuration(getActivity(), service.duration()));
        }
    }

