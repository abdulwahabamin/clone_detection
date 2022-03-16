    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        if (icicle != null) {
            currentId = icicle.getLong(CURRENT_PLAYLIST);
            playlistName = icicle.getString(CURRENT_PLAYLIST_NAME);
        }

        createShortcut = (getActivity() instanceof PlaylistShortcutActivity);
    }

