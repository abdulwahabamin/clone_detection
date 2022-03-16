    /**
     * {@inheritDoc}
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Check to reuse view
        View v = convertView;

        if (v == null) {
            //Create the view holder
            LayoutInflater li =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(this.mItemViewResourceId, parent, false);
            ViewHolder viewHolder = new SearchResultAdapter.ViewHolder();
            viewHolder.mIvIcon = (ImageView) v.findViewById(RESOURCE_ITEM_ICON);
            viewHolder.mTvName = (TextView) v.findViewById(RESOURCE_ITEM_NAME);
            viewHolder.mTvParentDir = (TextView) v.findViewById(RESOURCE_ITEM_PARENT_DIR);
            viewHolder.mWgRelevance = (RelevanceView) v.findViewById(RESOURCE_ITEM_RELEVANCE);
            viewHolder.mMimeType = (TextView) v.findViewById(RESOURCE_ITEM_MIME_TYPE);

            // Apply the current theme
            Theme theme = ThemeManager.getCurrentTheme(getContext());
            theme.setTextColor(
                    getContext(), viewHolder.mTvName, "text_color"); //$NON-NLS-1$
            if (viewHolder.mTvParentDir != null) {
                theme.setTextColor(
                        getContext(), viewHolder.mTvParentDir, "text_color"); //$NON-NLS-1$
            }
            v.setTag(viewHolder);
        }

        //Retrieve data holder
        final SearchActivity.DataHolder dataHolder = getItem(position);

        //Retrieve the view holder
        ViewHolder viewHolder = (ViewHolder) v.getTag();

        //Set the data
        mIconHolder.loadDrawable(viewHolder.mIvIcon,
                dataHolder.getSearchResult().getFso(), dataHolder.getDwIcon());

        viewHolder.mTvName.setText(dataHolder.getName(), TextView.BufferType.SPANNABLE);
        viewHolder.mTvParentDir.setText(dataHolder.getParentDir());
        if (dataHolder.getRelevance() != null) {
            viewHolder.mWgRelevance.setRelevance(dataHolder.getRelevance().floatValue());
        }
        viewHolder.mWgRelevance.setVisibility(
                dataHolder.getRelevance() != null ? View.VISIBLE : View.GONE);
        if (dataHolder.getMimeTypeCategory() != MimeTypeHelper.MimeTypeCategory.NONE) {
            viewHolder.mMimeType.setVisibility(View.VISIBLE);
            viewHolder.mMimeType.setText(dataHolder.getMimeTypeCategory().name());
        } else {
            viewHolder.mMimeType.setVisibility(View.GONE);
        }
        //Return the view
        return v;
    }

