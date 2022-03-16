    private void addAddToPlaylistAction(NotificationCompat.Builder builder) {
        Log.d(TAG, "addToPlaylistAction");

        String label;
        int icon;
        PendingIntent intent = mAddToPlaylistIntent;

        if (mPlaybackState
                .getExtras()
                .getBoolean(PlaylistsSource.PLAYBACK_STATE_EXTRA_IS_IN_FAVORITES)) {
            label = "in_favourites";
            icon = R.drawable.ic_heart_solid_light_pink_24dp;
        } else {
            label = "not_in_favourites";
            icon = R.drawable.ic_heart_outline_white_24dp;
        }

        builder.addAction(icon, label, intent);

    }

