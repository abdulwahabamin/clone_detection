    private void onNavigationItemSelectedForFragment(int id) {
        if (id == itemId) {
            return;
        }
        itemId = id;
        Fragment fragment = null;
        String tag = null;

        switch (id) {
            case R.id.nav_header:
                title = getResources().getString(R.string.nav_menu_login);
                fragment = MediaListFragment.newInstance(title, MediaIDHelper.MEDIA_ID_TRACKS);
                unCheckAllMenuItems(navigationView);
                break;
            case R.id.nav_playlist:
                title = getResources().getString(R.string.nav_menu_playlists);
                fragment = CategoryFragment.newInstance(title, MediaIDHelper.MEDIA_ID_PLAYLIST);
                tag = CategoryFragment.TAG;
                break;
            case R.id.nav_tracks:
                title = getResources().getString(R.string.nav_menu_tracks);
                fragment = MediaListFragment.newInstance(title, MediaIDHelper.MEDIA_ID_TRACKS);
                tag = MediaListFragment.TAG;
                break;
            case R.id.nav_albums:
                title = getResources().getString(R.string.nav_menu_albums);
                fragment = CategoryFragment.newInstance(title, MediaIDHelper.MEDIA_ID_ALBUM);
                tag = CategoryFragment.TAG;
                break;
            case R.id.nav_artists:
                title = getResources().getString(R.string.nav_menu_artists);
                fragment = CategoryFragment.newInstance(title, MediaIDHelper.MEDIA_ID_ARTIST);
                tag = CategoryFragment.TAG;
                break;
            case R.id.nav_genres:
                title = getResources().getString(R.string.nav_menu_genre);
                fragment = CategoryFragment.newInstance(title, MediaIDHelper.MEDIA_ID_GENRE);
                tag = CategoryFragment.TAG;
                break;
            case R.id.nav_folders:
                title = getResources().getString(R.string.nav_menu_folders);
                fragment = CategoryFragment.newInstance(title, MediaIDHelper.MEDIA_ID_FOLDER);
                tag = CategoryFragment.TAG;
                break;
        }

        for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
            getSupportFragmentManager().popBackStack();
        }
        // Insert the fragment by replacing any existing fragment
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.flContent, fragment, tag)
                .commit();
    }

