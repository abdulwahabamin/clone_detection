        @Override
        public void onSearchResultClick(MediaBrowserCompat.MediaItem item) {

            searchQueryEt.setText("");
            searchViewParentLl.setVisibility(View.GONE);

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(searchQueryEt.getWindowToken(), 0);

            mPresenter.onAlbumSearchResultClick(item);
        }

