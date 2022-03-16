        @Override
        public boolean onQueryTextChange(String query) {
            searchQuery = query;
            updateData();
            return true;
        }

