        SimpleItemRecyclerViewAdapter(ItemListActivity parent,
                                      List<SongContent.SongItem> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

