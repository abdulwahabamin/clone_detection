    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case PLAY_SELECTION: {
                long[] list = mCurrentArtistId != null ? MusicUtils.getSongListForArtist(
                        getActivity(), Long.parseLong(mCurrentArtistId)) : MusicUtils
                        .getSongListForAlbum(getActivity(), Long.parseLong(mCurrentAlbumId));
                MusicUtils.playAll(getActivity(), list, 0);
                break;
            }
            case ADD_TO_PLAYLIST: {
                Intent intent = new Intent(INTENT_ADD_TO_PLAYLIST);
                long[] list = mCurrentArtistId != null ? MusicUtils.getSongListForArtist(
                        getActivity(), Long.parseLong(mCurrentArtistId)) : MusicUtils
                        .getSongListForAlbum(getActivity(), Long.parseLong(mCurrentAlbumId));
                intent.putExtra(INTENT_PLAYLIST_LIST, list);
                getActivity().startActivity(intent);
                break;
            }
            case SEARCH: {
                MusicUtils.doSearch(getActivity(), mCursor, mArtistNameIndex);
                break;
            }
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

