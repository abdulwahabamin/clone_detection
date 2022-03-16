        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults filterResults = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                // No filter implemented we return all the list
                filterResults.values = originalSearchResults;
                filterResults.count = originalSearchResults.size();
            } else {
                ArrayList<SearchResult> filteredSongList = new ArrayList<>();
                for (SearchResult result : originalSearchResults) {
                    if (result.getMainTitle().toLowerCase().contains(constraint.toString().toLowerCase())
                            || result.getResultType() == SearchResult.ResultType.HEADER) {
                        filteredSongList.add(result);
                    }
                }
                filterResults.values = filteredSongList;
                filterResults.count = filteredSongList.size();
            }
            return filterResults;
        }

