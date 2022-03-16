        @Override
        public boolean onItemFlingerStart(
                AdapterView<?> parent, View view, int position, long id) {
            try {
                // Response if the item can be removed
                SearchResultAdapter adapter = (SearchResultAdapter)parent.getAdapter();
                SearchResult result = adapter.getItem(position).getSearchResult();
                if (result != null && result.getFso() != null) {
                    if (result.getFso() instanceof ParentDirectory) {
                        // This is not possible ...
                        return false;
                    }
                    return true;
                }
            } catch (Exception e) {
                ExceptionUtil.translateException(SearchActivity.this, e, true, false);
            }
            return false;
        }

