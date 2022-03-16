    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, FAVORITE, 0, R.string.cd_favorite).setShowAsAction(
                MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, SEARCH, 0, R.string.cd_search).setIcon(R.drawable.butter_holo_light_search)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.overflow_now_playing, menu);
        return super.onCreateOptionsMenu(menu);
    }

