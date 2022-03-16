    private void closeSearch() {
        searchQueryEt.setText("");
        searchViewParentLl.setVisibility(View.GONE);

        // hide soft keyboard
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchQueryEt.getWindowToken(), 0);
    }

