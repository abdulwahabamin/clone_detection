    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        dismiss();
        PlaylistCallback mListener = (PlaylistCallback) getActivity();
        mListener.playlistChosen(position);
    }

