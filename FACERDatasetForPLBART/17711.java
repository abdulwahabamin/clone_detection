    private void showSearch() {
        searchViewParentLl.setVisibility(View.VISIBLE);

        searchQueryEt.requestFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(searchQueryEt, 0);
    }

