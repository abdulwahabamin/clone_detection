    /**
     * to get visitable list from mediaitem list
     * @param itemList input mediaitem list
     * @return converted visitable list
     */
    private List<BaseVisitable> getVisitableList(List<MediaBrowserCompat.MediaItem> itemList) {
        List<BaseVisitable> visitableList = new ArrayList<>();
        String currentItemType = "";
        for (MediaBrowserCompat.MediaItem item : itemList) {

            String itemType = item.getDescription()
                    .getExtras()
                    .getString(MusicProviderSource.CUSTOM_METADATA_KEY_SEARCH_ITEM_TYPE);

            if (itemType == null) {
                Log.w(TAG, "getVisitableList:item type is null");
                continue;
            }

            if (!currentItemType.equals(itemType)) {
                currentItemType = itemType;
                visitableList.add(new SearchItemTypeTitleVisitable(itemType));
            }

            BaseVisitable visitable = null;

            switch (itemType) {
                case MusicProviderSource.SEARCH_RESULT_ITEM_TYPE_SONG:
                    visitable = new SongSearchResultVisitable(item);
                    visitable.setOnClickListener(mSongSearchResultOnClickListener);
                    break;
                case MusicProviderSource.SEARCH_RESULT_ITEM_TYPE_ALBUM:
                    visitable = new AlbumSearchResultVisitable(item);
                    visitable.setOnClickListener(mAlbumSearchResultOnClickListener);
                    break;
                case MusicProviderSource.SEARCH_RESULT_ITEM_TYPE_ARTIST:
                    visitable = new ArtistSearchResultVisitable(item);
                    visitable.setOnClickListener(mArtistSearchResultOnClickListener);
                    break;
            }

            if (visitable != null) {
                visitableList.add(visitable);
            } else {
                Log.w(TAG, "getVisitableList:item type is invalid");
            }

        }

        return visitableList;
    }

