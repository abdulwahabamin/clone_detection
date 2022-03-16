    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterContextMenuInfo mi = (AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()) {
            case PLAY_SELECTION: {
                long[] list = MusicUtils.getSongListForPlaylist(getActivity(),
                        Long.parseLong(mCurrentPlaylistId));
                MusicUtils.playAll(getActivity(), list, 0);
                break;
            }
            case RENAME_PLAYLIST: {
                Intent intent = new Intent(INTENT_RENAME_PLAYLIST);
                intent.putExtra(INTENT_KEY_RENAME, mi.id);
                getActivity().startActivity(intent);
                break;
            }
            case DELETE_PLAYLIST: {
                Uri uri = ContentUris.withAppendedId(
                        MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, mi.id);
                getActivity().getContentResolver().delete(uri, null, null);
                break;
            }
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

