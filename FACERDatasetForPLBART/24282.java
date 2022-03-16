    /**
     * Update all active widget instances by pushing changes 
     */
    void performUpdate(nu.staldal.djdplayer.MediaPlaybackService service, int[] appWidgetIds) {
        final Resources res = service.getResources();
        final RemoteViews views = new RemoteViews(service.getPackageName(), R.layout.appwidget);
        
        CharSequence titleName = service.getTrackName();
        CharSequence artistName = service.getArtistName();
        CharSequence genreName = service.getGenreName();
        CharSequence errorState = null;
        
        // Format title string with track number, or show SD card message
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_SHARED) ||
                status.equals(Environment.MEDIA_UNMOUNTED)) {
            errorState = res.getText(R.string.sdcard_busy_title);
        } else if (status.equals(Environment.MEDIA_REMOVED)) {
            errorState = res.getText(R.string.sdcard_missing_title);
        } else if (titleName == null) {
            errorState = res.getText(R.string.emptyplaylist);
        }
        
        if (errorState != null) {
            // Show error state to user
            views.setTextViewText(R.id.title, errorState);
            views.setTextViewText(R.id.artist, "");
            views.setTextViewText(R.id.genre, "");
        } else {
            // No error, so show normal titles
            views.setTextViewText(R.id.title, titleName);
            views.setTextViewText(R.id.artist, artistName);
            views.setTextViewText(R.id.genre, genreName);
        }
        
        // Set correct drawable for pause state
        final boolean playing = service.isPlaying();
        if (playing) {
            views.setImageViewResource(R.id.pause, android.R.drawable.ic_media_pause);
        } else {
            views.setImageViewResource(R.id.pause, android.R.drawable.ic_media_play);
        }

        // Link actions buttons to intents
        linkButtons(service, views, playing);
        
        pushUpdate(service, appWidgetIds, views);
    }

