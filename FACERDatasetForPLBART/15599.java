    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case PLAY_SELECTION:
                int position = mSelectedPosition;
                MusicUtils.playAll(getActivity(), mCursor, position);
                getActivity().finish();
                break;
            case REMOVE:
                removePlaylistItem(mSelectedPosition);
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

