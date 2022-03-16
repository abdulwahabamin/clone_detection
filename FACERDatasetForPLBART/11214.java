    /**
     * {@inheritDoc}
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check to reuse view
        View v = convertView;
        Theme theme = ThemeManager.getCurrentTheme(getContext());

        if (v == null) {
            //Create the view holder
            LayoutInflater li =
                    (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(this.mItemViewResourceId, parent, false);
            ViewHolder viewHolder = new FileSystemObjectAdapter.ViewHolder();
            viewHolder.mIvIcon = (ImageView)v.findViewById(RESOURCE_ITEM_ICON);
            viewHolder.mTvName = (TextView)v.findViewById(RESOURCE_ITEM_NAME);
            viewHolder.mTvSummary = (TextView)v.findViewById(RESOURCE_ITEM_SUMMARY);
            viewHolder.mTvSize = (TextView)v.findViewById(RESOURCE_ITEM_SIZE);
            if (!this.mPickable) {
                viewHolder.mBtCheck = (ImageButton)v.findViewById(RESOURCE_ITEM_CHECK);
                viewHolder.mBtCheck.setOnClickListener(this);
            } else {
                viewHolder.mBtCheck = (ImageButton)v.findViewById(RESOURCE_ITEM_CHECK);
                viewHolder.mBtCheck.setVisibility(View.GONE);
            }
            v.setTag(viewHolder);
        }

        //Retrieve the view holder
        ViewHolder viewHolder = (ViewHolder)v.getTag();
        if (this.mPickable) {
            theme.setBackgroundDrawable(getContext(), v, "background_drawable"); //$NON-NLS-1$
        }

        FileSystemObject fso = getItem(position);

        Drawable dwIcon = this.mIconHolder.getDrawable(
                MimeTypeHelper.getIcon(getContext(), fso, true));
        mIconHolder.loadDrawable(viewHolder.mIvIcon, fso, dwIcon);

        viewHolder.mTvName.setText(fso.getName());
        theme.setTextColor(getContext(), viewHolder.mTvName, "text_color"); //$NON-NLS-1$
        if (viewHolder.mTvSummary != null) {
            StringBuilder sbSummary = new StringBuilder();
            if (fso instanceof ParentDirectory) {
                sbSummary.append(getContext().getResources().getString(R.string.parent_dir));
            } else {
                sbSummary.append(
                        FileHelper.formatFileTime(
                                getContext(), fso.getLastModifiedTime()));
                sbSummary.append("   "); //$NON-NLS-1$
                sbSummary.append(fso.toRawPermissionString());
            }
            viewHolder.mTvSummary.setText(sbSummary);
            theme.setTextColor(getContext(), viewHolder.mTvSummary, "text_color"); //$NON-NLS-1$
        }
        if (viewHolder.mTvSize != null) {
            viewHolder.mTvSize.setText(FileHelper.getHumanReadableSize(fso));
            theme.setTextColor(getContext(), viewHolder.mTvSize, "text_color"); //$NON-NLS-1$
        }
        if (!this.mPickable) {
            viewHolder.mBtCheck.setVisibility(
                    TextUtils.equals(fso.getName(), FileHelper.PARENT_DIRECTORY) ?
                            View.INVISIBLE : View.VISIBLE);

            boolean selected = mSelectedItems.contains(fso);
            Drawable dwCheck;
            if (selected) {
                dwCheck = theme.getDrawable(getContext(), "checkbox_selected_drawable"); //$NON-NLS-1$
            } else {
                dwCheck = theme.getDrawable(getContext(), "checkbox_deselected_drawable"); //$NON-NLS-1$
            }
            viewHolder.mBtCheck.setImageDrawable(dwCheck);
            viewHolder.mBtCheck.setTag(position);

            if (viewHolder.mHasSelectedBg == null
                    || viewHolder.mHasSelectedBg != selected) {
                String drawableId = selected
                        ? "selectors_selected_drawable" //$NON-NLS-1$
                        : "selectors_deselected_drawable"; //$NON-NLS-1$

                theme.setBackgroundDrawable(getContext(), v, drawableId);
                viewHolder.mHasSelectedBg = selected;
            }
        }

        //Return the view
        return v;
    }

