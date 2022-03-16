    private boolean parseIntent(Intent intent, boolean onCreate) {
        if (Intent.ACTION_VIEW.equals(intent.getAction())
                && intent.getData() != null
                && intent.getType() != null && intent.getType().startsWith(MusicUtils.AUDIO_X_MPEGURL)) {
            new ImportPlaylistTask(getApplicationContext()).execute(intent.getData());
            songToPlay = -1;
            uri = null;
            title = null;
            searchResult = false;
            MusicUtils.setStringPref(this, SettingsActivity.ACTIVE_TAB, PlaylistFragment.class.getCanonicalName());
        } else if (Intent.ACTION_VIEW.equals(intent.getAction())
                && intent.getData() != null
                && intent.getData().toString().startsWith(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.toString())
                && MusicUtils.isLong(intent.getData().getLastPathSegment())) {
            songToPlay = ContentUris.parseId(intent.getData());
            if (!onCreate) return false;
            uri = null;
            title = null;
            searchResult = false;
        } else if (Intent.ACTION_VIEW.equals(intent.getAction())
                && intent.getData() != null
                && intent.getData().getScheme().equals("file")) {
            songToPlay = fetchSongIdFromPath(intent.getData().getPath());
            if (!onCreate) return false;
            uri = null;
            title = null;
            searchResult = false;
        } else if ((Intent.ACTION_VIEW.equals(intent.getAction()) || Intent.ACTION_PICK.equals(intent.getAction()))
                && intent.getData() != null) {
            songToPlay = -1;
            uri = fixUri(intent.getData());
            title = MusicProvider.calcTitle(this, uri);
            searchResult = false;
        } else if (Intent.ACTION_SEARCH.equals(intent.getAction())
                || MediaStore.INTENT_ACTION_MEDIA_SEARCH.equals(intent.getAction())) {
            songToPlay = -1;
            uri = null;
            title = getString(R.string.search_results, intent.getStringExtra(SearchManager.QUERY));
            searchResult = true;
        } else {
            songToPlay = -1;
            uri = null;
            title = null;
            searchResult = false;
        }

        if (title == null) {
            enterCategoryMode();
        } else {
            enterSongsMode();
        }

        return true;
    }

