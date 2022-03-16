    private void setupSearchView(SearchView sv) {
        ImageView searchButton = (ImageView) sv.findViewById(R.id.search_mag_icon);
        searchButton.setImageResource(R.drawable.ic_search_white_24dp);
        TextView searchBox = (TextView) sv.findViewById(R.id.search_src_text);
        searchBox.setHint("Search...");
        searchBox.setHintTextColor(getResources().getColor(R.color.white));
        searchBox.setTextColor(getResources().getColor(R.color.white));

        ImageView searchClose = (ImageView) sv.findViewById(R.id.search_close_btn);
        searchClose.setImageResource(R.drawable.ic_clear_white_24dp);

        sv.setIconifiedByDefault(false);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                SearchAdapter searchAdapter = (SearchAdapter) searchList.getAdapter();
                if (searchAdapter != null) {
                    searchAdapter.getFilter().filter(newText);
                }
                return false;
            }
        });
    }

