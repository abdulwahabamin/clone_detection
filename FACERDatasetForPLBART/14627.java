    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case PLAY_SELECTION:
                long[] list = MusicUtils.getSongListForGenre(getActivity(),
                        Long.parseLong(mCurrentGenreId));
                MusicUtils.playAll(getActivity(), list, 0);
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

