        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results != null && results.count > 0) {
                currentSearchResults = (ArrayList<SearchResult>) results.values;
                SearchAdapter.this.notifyDataSetChanged();
            } else {
                SearchAdapter.this.notifyDataSetChanged();
            }
        }

