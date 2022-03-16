  private void initSearchView() {
    searchView.setVoiceSearch(false);
    searchView.setHint(getString(R.string.search_label));
    searchView.setCursorDrawable(R.drawable.custom_curosr);
    searchView.setEllipsize(true);
    searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        requestWeather(query, true);
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        return false;
      }
    });
  }

