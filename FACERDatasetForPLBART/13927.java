    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem favorite = menu.findItem(FAVORITE);
        MenuItem search = menu.findItem(SEARCH);
        if (MusicUtils.mService != null && MusicUtils.getCurrentAudioId() != -1) {
            if (MusicUtils.isFavorite(this, MusicUtils.getCurrentAudioId())) {
                favorite.setIcon(R.drawable.butter_holo_light_favorite_selected);
            } else {
                favorite.setIcon(R.drawable.butter_holo_light_favorite_normal);
                // Theme chooser
                ThemeUtils.setActionBarItem(this, favorite, "apollo_favorite_normal");
            }
        }
        // Theme chooser
        ThemeUtils.setActionBarItem(this, search, "apollo_search");
        return super.onPrepareOptionsMenu(menu);
    }

