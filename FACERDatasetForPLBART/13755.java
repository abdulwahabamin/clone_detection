    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_downloaded) {
            // Replace the fragment with downloaded files fragment
            replaceFragment(new DownloadsFragment());
        } else if (id == R.id.nav_favorites) {
            // Replace the fragment with favorites fragment
            replaceFragment(new FavoritesFragment());
        } else if (id == R.id.nav_settings) {
            // Open app settings activity
            settings();
        } else if (id == R.id.nav_share) {
            shareApp(); //share the app url with friends
        } else if (id == R.id.nav_rate) {
            rateApp();  //rate the app in play store
        } else if (id == R.id.nav_exit) {
            exit();   //exit confirmation alert dialog
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

