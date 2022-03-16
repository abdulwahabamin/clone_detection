    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (service != null) {
            String clickOnSong = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(
                    SettingsActivity.CLICK_ON_SONG, SettingsActivity.PLAY_NEXT);
            if (clickOnSong.equals(SettingsActivity.PLAY_NOW)) {
                service.setQueuePosition(position);
            } else {
                if (!service.isPlaying()) {
                    service.setQueuePosition(position);
                }
            }
        }
    }

