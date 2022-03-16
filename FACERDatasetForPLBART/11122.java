        @Override
        public void onItemFlingerEnd(OnItemFlingerResponder responder,
                AdapterView<?> parent, View view, int position, long id) {

            try {
                // Response if the item can be removed
                SearchResultAdapter adapter = (SearchResultAdapter)parent.getAdapter();
                SearchResult result = adapter.getItem(position).getSearchResult();
                if (result != null && result.getFso() != null) {
                    DeleteActionPolicy.removeFileSystemObject(
                            SearchActivity.this,
                            result.getFso(),
                            null,
                            SearchActivity.this,
                            responder);
                    return;
                }

                // Cancels the flinger operation
                responder.cancel();

            } catch (Exception e) {
                ExceptionUtil.translateException(SearchActivity.this, e, true, false);
                responder.cancel();
            }
        }

