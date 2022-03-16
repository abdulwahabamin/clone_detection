    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_library) {
            mainFragmentSwitcher.switchTo(libraryFragment, LIBRARY_FRAGMENT_TAG);
        } else if (id == R.id.connectivity){
            mainFragmentSwitcher.switchTo(connectivityFragment, CONNECTIVITY_FRAGMENT_TAG);
        } else if (id == R.id.nav_settings) {
            Toast.makeText(this,"Settings coming soon(ish)", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(this, AboutActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

