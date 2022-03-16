    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.now_playing, menu);

        showEqualizerActionBar(menu);
        return super.onCreateOptionsMenu(menu);
    }

