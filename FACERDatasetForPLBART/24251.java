    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.create_playlist, null);
        mPlaylist = (EditText) view.findViewById(R.id.playlist);

        String defaultName = savedInstanceState != null ? savedInstanceState.getString("defaultname") : makePlaylistName();

        mPlaylist.setText(defaultName);
        mPlaylist.setSelection(defaultName.length());

        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.create_playlist_create_text_prompt)
                .setView(view)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CreatePlaylist.this.getDialog().cancel();
                    }
                })
                .setPositiveButton(R.string.create_playlist_create_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = mPlaylist.getText().toString();
                        if (name.length() > 0) {
                            if (MusicUtils.playlistExists(getActivity(), name)) {
                                Toast.makeText(getActivity(), R.string.playlist_already_exists, Toast.LENGTH_SHORT).show();
                            } else {
                                Uri uri = MusicUtils.createPlaylist(getActivity(), name);
                                long[] songs = getArguments().getLongArray("songs");
                                if (songs != null) {
                                    MusicUtils.addToPlaylist(getActivity(), songs, Integer.valueOf(uri.getLastPathSegment()));
                                }
                            }
                        }
                        CreatePlaylist.this.getDialog().dismiss();
                    }
                }).create();
    }

