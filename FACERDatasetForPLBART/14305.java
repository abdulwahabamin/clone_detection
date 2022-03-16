    @Override
    public void onCreate(Bundle icicle) {

        super.onCreate(icicle);
        setContentView(new LinearLayout(this));

        action = getIntent().getAction();

        mRenameId = icicle != null ? icicle.getLong(INTENT_KEY_RENAME) : getIntent().getLongExtra(
                INTENT_KEY_RENAME, -1);
        mList = icicle != null ? icicle.getLongArray(INTENT_PLAYLIST_LIST) : getIntent()
                .getLongArrayExtra(INTENT_PLAYLIST_LIST);
        if (INTENT_RENAME_PLAYLIST.equals(action)) {
            mOriginalName = nameForId(mRenameId);
            mDefaultName = icicle != null ? icicle.getString(INTENT_KEY_DEFAULT_NAME)
                    : mOriginalName;
        } else if (INTENT_CREATE_PLAYLIST.equals(action)) {
            mDefaultName = icicle != null ? icicle.getString(INTENT_KEY_DEFAULT_NAME)
                    : makePlaylistName();
            mOriginalName = mDefaultName;
        }

        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();

        mPlaylistDialog = new AlertDialog.Builder(this).create();
        mPlaylistDialog.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        if (action != null && mRenameId >= 0 && mOriginalName != null || mDefaultName != null) {

            mPlaylist = new EditText(this);
            mPlaylist.setSingleLine(true);
            mPlaylist.setText(mDefaultName);
            mPlaylist.setSelection(mDefaultName.length());
            mPlaylist.addTextChangedListener(this);

            mPlaylistDialog.setIcon(android.R.drawable.ic_dialog_info);
            String promptformat;
            String prompt = "";
            if (INTENT_RENAME_PLAYLIST.equals(action)) {
                promptformat = getString(R.string.rename_playlist);
                prompt = String.format(promptformat, mOriginalName, mDefaultName);
            } else if (INTENT_CREATE_PLAYLIST.equals(action)) {
                promptformat = getString(R.string.new_playlist);
                prompt = String.format(promptformat, mDefaultName);
            }

            mPlaylistDialog.setTitle(prompt);
            mPlaylistDialog.setView(mPlaylist, (int)(8 * dm.density), (int)(8 * dm.density),
                    (int)(8 * dm.density), (int)(4 * dm.density));
            if (INTENT_RENAME_PLAYLIST.equals(action)) {
                mPlaylistDialog.setButton(Dialog.BUTTON_POSITIVE, getString(R.string.save),
                        mRenamePlaylistListener);
                mPlaylistDialog.setOnShowListener(this);
            } else if (INTENT_CREATE_PLAYLIST.equals(action)) {
                mPlaylistDialog.setButton(Dialog.BUTTON_POSITIVE, getString(R.string.save),
                        mCreatePlaylistListener);
            }
            mPlaylistDialog.setButton(Dialog.BUTTON_NEGATIVE, getString(android.R.string.cancel),
                    new OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            finish();
                        }
                    });
            mPlaylistDialog.setOnCancelListener(this);
            mPlaylistDialog.show();
        } else {
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
            finish();
        }

    }

