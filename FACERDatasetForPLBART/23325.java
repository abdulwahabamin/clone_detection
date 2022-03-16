    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        try {
        	Log.i("MediaPlaybackActivity", "ITEM SELECTED: " + item.getItemId());
            switch (item.getItemId()) {
                case GOTO_START:
                    intent = new Intent();
                    intent.setClass(this, MusicBrowserActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    break;
                case USE_AS_RINGTONE: {
                    // Set the system setting to make this the current ringtone
                    if (mService != null) {
                        MusicUtils.setRingtone(this, mService.getAudioId());
                    }
                    return true;
                }
                case PARTY_SHUFFLE:
                    if (mService != null) {
                        int shuffle = mService.getShuffleMode();
                        if (shuffle == MediaPlaybackService.SHUFFLE_AUTO) {
                            mService.setShuffleMode(MediaPlaybackService.SHUFFLE_NONE);
                        } else {
                            mService.setShuffleMode(MediaPlaybackService.SHUFFLE_AUTO);
                        }
                    }
                    setShuffleButtonImage();
                    break;

                case NEW_PLAYLIST: {
                    intent = new Intent();
                    intent.setClass(this, CreatePlaylist.class);
                    startActivityForResult(intent, NEW_PLAYLIST);
                    return true;
                }

                case PLAYLIST_SELECTED: {
                    int [] list = new int[1];
                    list[0] = MusicUtils.getCurrentAudioId();
                    int playlist = item.getIntent().getIntExtra("playlist", 0);
                    MusicUtils.addToPlaylist(this, list, playlist);
                    return true;
                }

                case DELETE_ITEM: {
                    if (mService != null) {
                        int [] list = new int[1];
                        list[0] = MusicUtils.getCurrentAudioId();
                        Bundle b = new Bundle();
                        b.putString("description", getString(R.string.delete_song_desc,
                                mService.getTrackName()));
                        b.putIntArray("items", list);
                        intent = new Intent();
                        intent.setClass(this, DeleteItems.class);
                        intent.putExtras(b);
                        startActivityForResult(intent, -1);
                    }
                    return true;
                }
                case MENU_ITEM_SEND_BT: {
                    Uri uri = Uri.parse(mService.getPath());
                    doBluetoothDeviceTransfer(uri);
                    return true;
                } // MENU_ITEM_SEND_BT
            }
        } catch (RemoteException ex) {
        }
        return super.onOptionsItemSelected(item);
    }

