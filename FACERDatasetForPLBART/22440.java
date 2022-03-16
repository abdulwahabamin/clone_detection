    private void setupToolbar() {

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        if (MusicPlayer.getTrackName() != null) {
            ab.setTitle(MusicPlayer.getTrackName());
        }
    }

