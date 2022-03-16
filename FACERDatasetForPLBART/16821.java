    private void onNavigationItemSelected(final int id) {
        FireLog.d(TAG, "(++) onNavigationItemSelected, id=" + id);
        drawer.closeDrawer(GravityCompat.START);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (id) {
                    case R.id.nav_header:
                    case R.id.nav_playlist:
                    case R.id.nav_tracks:
                    case R.id.nav_albums:
                    case R.id.nav_artists:
                    case R.id.nav_genres:
                    case R.id.nav_folders:
                        onNavigationItemSelectedForFragment(id);
                        break;
                }
            }
        }, 300);
    }

