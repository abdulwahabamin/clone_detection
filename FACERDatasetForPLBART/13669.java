    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        CURRENT_TAG = TAG_DEFAULT;
        if (id == R.id.nav_sd0) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_SD0;
        } else if (id == R.id.nav_sd1) {
            navItemIndex = 1;
            CURRENT_TAG = TAG_SD1;
        } else if (id == R.id.nav_sd2) {
            navItemIndex = 2;
            CURRENT_TAG = TAG_SD2;
        } else if (id == R.id.nav_sd3) {
            navItemIndex = 3;
            CURRENT_TAG = TAG_SD3;
        } else if (id == R.id.nav_sd4) {
            navItemIndex = 4;
            CURRENT_TAG = TAG_SD4;
        } else if (id == R.id.nav_root) {
            navItemIndex = 5;
            CURRENT_TAG = TAG_ROOT;
        } else if (id == R.id.nav_apps) {
            navItemIndex = 6;
            CURRENT_TAG = TAG_APP;
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);

        loadHomeFragment();
        return true;
    }

