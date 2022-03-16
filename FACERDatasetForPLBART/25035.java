    @Override
    public int getItemViewType(int position) {
        int viewType;
        if (currentSearchResults.get(position).getResultType() == SearchResult.ResultType.ARTIST) {
            viewType = TYPE_ARTIST;
        } else if (currentSearchResults.get(position).getResultType() == SearchResult.ResultType.ALBUM) {
            viewType = TYPE_ALBUM;
        } else if (currentSearchResults.get(position).getResultType() == SearchResult.ResultType.SONG) {
            viewType = TYPE_SONG;
        } else {
            viewType = TYPE_HEADER;
        }
        return viewType;
    }

