    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity(), R.style.RhythmAlertDialog);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View dialogView = inflater.inflate(R.layout.dialog_add_playlist, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.playlist_input);

        dialogBuilder.setTitle("Add a Playlist");
        dialogBuilder.setMessage("Playlist Name:");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                MusicDataUtility.createPlaylist(edt.getText().toString(), getActivity());
                if(getActivity() instanceof PlaylistAddCallback){
                    PlaylistAddCallback playlistAddCallback = (PlaylistAddCallback) getActivity();
                    playlistAddCallback.playlistAdded();
                }
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });

        return dialogBuilder.create();
    }

