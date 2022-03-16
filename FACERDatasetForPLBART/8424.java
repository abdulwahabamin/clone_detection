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
                (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.option_list_item, parent, false);
            ViewHolder viewHolder = new CheckableListAdapter.ViewHolder();
            viewHolder.mTvTitle = (TextView)v.findViewById(RESOURCE_ITEM_NAME);
            viewHolder.mDwCheck = (ImageView)v.findViewById(RESOURCE_ITEM_CHECK);
            v.setTag(viewHolder);

            // Apply theme
            Theme theme = ThemeManager.getCurrentTheme(getContext());
            theme.setBackgroundDrawable(
                    getContext(), v,
                    (this.mIsDialog) ?
                            "selectors_selected_drawable" : //$NON-NLS-1$
                            "selectors_deselected_drawable"); //$NON-NLS-1$
            theme.setTextColor(
                    getContext(), viewHolder.mTvTitle, "text_color"); //$NON-NLS-1$
            theme.setImageDrawable(
                    getContext(), viewHolder.mDwCheck,
                    "popup_checkable_selector_drawable"); //$NON-NLS-1$
        }

        //Retrieve the item
        CheckableListAdapter.CheckableItem item = getItem(position);

        //Retrieve the view holder and fill the views
        ViewHolder viewHolder = (ViewHolder)v.getTag();
        viewHolder.mTvTitle.setText(item.mLabel);
        viewHolder.mDwCheck.setVisibility(item.mCheckable ? View.VISIBLE : View.GONE);
        if (item.mCheckable) {
            viewHolder.mDwCheck.setSelected(item.mChecked);
        }

        return v;
    }

