        @Override
        public boolean onQueryTextSubmit(String query) {
            searchQuery = query;
            searchView.clearFocus();
            updateData();
            return true;
        }

