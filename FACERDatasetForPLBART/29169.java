    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //Add
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        //String title = null;
        //Add

        if (id == R.id.nav_auth) {
            // Handle the camera action

        } else if (id == R.id.nav_credits) {
            Log.d("test", ">>> credits");
            fragment = new CreditFragment();
            title = "Credits";
        } else if (id == R.id.nav_forecastType) {

        } else if (id == R.id.nav_notificationOptions) {

        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_settings) {

        }

        //Add
        if (fragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_fragment_layout, fragment);
            ft.commit();
        }

        //set the toolbar title
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
        //Add

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

