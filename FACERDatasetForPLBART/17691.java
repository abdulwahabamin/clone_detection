    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        Log.d(TAG, "onOptionsItemSelected:called");

        switch (id) {

            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.search:
                Log.d(TAG, "onOptionsItemSelected:called for search");
                showSearch();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

