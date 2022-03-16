    public static void addSongToPlaylist(AppCompatActivity activity){
        List<Playlist> playlists = MusicDataUtility.getPlayists(activity);

        if(playlists.size() == 0){
            showAddPlaylistDialog(activity);
        } else {
            String[] playlistNames = new String[playlists.size()];
            for (int i = 0; i < playlistNames.length; i++) {
                playlistNames[i] = playlists.get(i).getPlaylistName();
            }
            FragmentManager manager = activity.getSupportFragmentManager();
            PlaylistSelectDialog dialog = new PlaylistSelectDialog();
            Bundle args = new Bundle();
            args.putStringArray("playlistNames", playlistNames);
            dialog.setArguments(args);
            dialog.show(manager, "dialog");
        }
    }

