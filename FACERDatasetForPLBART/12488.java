    private void setTitle() {
        String terms = "";
        if (this.mSearchQuery != null) {
            terms = this.mSearchQuery.getTerms();
        }
        mTitle = FileManagerApplication.getInstance().getResources().getString(
                R.string.search_result_name, terms);
    }

