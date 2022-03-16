    private void showPlayList() {
        try {
            Intent i = new Intent(getApplicationContext(), PlayListActivity.class);
            startActivityForResult(i, REQUEST_PLAYLIST);
        } catch (Exception e) {
            // Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

