    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
         menu.add(0, PARTY_SHUFFLE, 0, R.string.party_shuffle); // icon will be set in onPrepareOptionsMenu()
         menu.add(0, SEARCH_MUSIC, 0, R.string.search_title).setIcon(android.R.drawable.ic_menu_search);
        return true;
    }

