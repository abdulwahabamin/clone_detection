    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_city_list,menu);
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        final MenuItem searchItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        if(searchView == null) return false;
//        searchView.setIconified(false);
        searchView.setQueryHint("�?�索城市，暂�?支�?拼音");
        searchView.setSearchableInfo( searchManager.getSearchableInfo(CityActivity.this.getComponentName()) );
        AutoCompleteTextView textView = (AutoCompleteTextView)searchView.findViewById(R.id.search_src_text);
        if (textView != null){
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
                }
                searchView.clearFocus();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

