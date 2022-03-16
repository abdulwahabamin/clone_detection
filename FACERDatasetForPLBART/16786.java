        @Override
        public void onSearchResult(@NonNull String query, Bundle bundle, @NonNull List<MediaItemWrapper> items) {
            FireLog.d(TAG, "(++) onSearchResult: query=" + query + "items size=" + items.size());
            if (!isDetached())
                searchAdapter.refreshData(items);
        }

