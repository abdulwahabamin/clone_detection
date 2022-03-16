    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case PLAY_SELECTION: {
                // play the track
                int position = mSelectedPosition;
                MusicUtils.playAll(this, mTrackCursor, position);
                return true;
            }

            case QUEUE: {
                int [] list = new int[] { (int) mSelectedId };
                MusicUtils.addToCurrentPlaylist(this, list);
                return true;
            }

            case NEW_PLAYLIST: {
                Intent intent = new Intent();
                intent.setClass(this, CreatePlaylist.class);
                startActivityForResult(intent, NEW_PLAYLIST);
                return true;
            }

            case PLAYLIST_SELECTED: {
                int [] list = new int[] { (int) mSelectedId };
                int playlist = item.getIntent().getIntExtra("playlist", 0);
                MusicUtils.addToPlaylist(this, list, playlist);
                return true;
            }

            case USE_AS_RINGTONE:
                // Set the system setting to make this the current ringtone
                MusicUtils.setRingtone(this, mSelectedId);
                return true;

            case DELETE_ITEM: {
                int [] list = new int[1];
                list[0] = (int) mSelectedId;
                Bundle b = new Bundle();
                String f = getString(R.string.delete_song_desc);
                String desc = String.format(f, mCurrentTrackName);
                b.putString("description", desc);
                b.putIntArray("items", list);
                Intent intent = new Intent();
                intent.setClass(this, DeleteItems.class);
                intent.putExtras(b);
                startActivityForResult(intent, -1);
                return true;
            }

            case REMOVE:
                removePlaylistItem(mSelectedPosition);
                return true;

            case SEARCH:
                doSearch();
                return true;

            case MENU_ITEM_SEND_BT: {
                Uri uri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, mSelectedId);
                doBluetoothDeviceTransfer(uri);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

