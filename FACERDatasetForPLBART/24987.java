    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        } else if (i == R.id.search_menu_item) {
            startActivity(SearchActivity.getIntent(this));
            return true;
        } else if (i == R.id.repeat_mode) {
            updateMenu(PlayBackUtil.getUpdateCurrentPlayMode(REPEAT));
        } else if (i == R.id.shuffle_mode) {
            updateMenu(PlayBackUtil.getUpdateCurrentPlayMode(SHUFFLE));
        }
        return super.onOptionsItemSelected(item);
    }

