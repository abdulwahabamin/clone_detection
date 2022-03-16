    @Override
    public void onCreate(Bundle icicle) {

        super.onCreate(icicle);
        setContentView(new LinearLayout(this));

        if (getIntent().getAction() != null) {

            if (INTENT_ADD_TO_PLAYLIST.equals(getIntent().getAction())
                    && getIntent().getLongArrayExtra(INTENT_PLAYLIST_LIST) != null) {

                MusicUtils.makePlaylistList(this, false, mAllPlayLists);
                mList = getIntent().getLongArrayExtra(INTENT_PLAYLIST_LIST);
                for (int i = 0; i < mAllPlayLists.size(); i++) {
                    mPlayListNames.add(mAllPlayLists.get(i).get("name"));
                }
                mPlayListPickerDialog = new AlertDialog.Builder(this)
                        .setTitle(R.string.add_to_playlist)
                        .setItems(mPlayListNames.toArray(new CharSequence[mPlayListNames.size()]),
                                this).setOnCancelListener(this).show();
            } else if (getIntent().getAction().equals(Intent.ACTION_CREATE_SHORTCUT)) {
                MusicUtils.makePlaylistList(this, true, mAllPlayLists);
                for (int i = 0; i < mAllPlayLists.size(); i++) {
                    mPlayListNames.add(mAllPlayLists.get(i).get("name"));
                }
                mPlayListPickerDialog = new AlertDialog.Builder(this)
                        .setItems(mPlayListNames.toArray(new CharSequence[mPlayListNames.size()]),
                                this).setOnCancelListener(this).show();
            }
        } else {
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

