    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("boxing")
    public View getView(int position, View convertView, ViewGroup parent) {
        //Recovers the menu item
        MenuItem menuItem1 = getItem(position);
        MenuItem menuItem2 = getItem2(position);

        //Recovery the
        View v = this.mInflater.inflate(R.layout.two_columns_menu_item, parent, false);

        //Set the item1
        TextView tvText1 = (TextView)v.findViewById(R.id.two_columns_menu1_item_text);
        tvText1.setText(menuItem1.getTitle());
        tvText1.setEnabled(menuItem1.isEnabled());
        tvText1.setVisibility(menuItem1.isVisible() ? View.VISIBLE : View.GONE);
        tvText1.setOnClickListener(this);
        tvText1.setOnLongClickListener(this);
        tvText1.setTag(String.format("%d|%d", position, menuItem1.getItemId())); //$NON-NLS-1$

        //Set the item2 if exists
        TextView tvText2 = (TextView)v.findViewById(R.id.two_columns_menu2_item_text);
        if (menuItem2 != null) {
            tvText2.setText(menuItem2.getTitle());
            tvText2.setEnabled(menuItem2.isEnabled());
            tvText2.setVisibility(menuItem2.isVisible() ? View.VISIBLE : View.GONE);
            tvText2.setOnClickListener(this);
            tvText2.setOnLongClickListener(this);
            tvText2.setTag(String.format("%d|%d", position, menuItem2.getItemId())); //$NON-NLS-1$
        } else {
            tvText2.setBackground(null);
            tvText2.setClickable(false);
            tvText2.setOnClickListener(null);
            tvText2.setOnLongClickListener(null);
        }

        // Divider
        TextView divider = (TextView)((ViewGroup)v).getChildAt(1);

        // Apply the current theme
        Theme theme = ThemeManager.getCurrentTheme(this.mContext);
        theme.setBackgroundDrawable(this.mContext, v, "background_drawable"); //$NON-NLS-1$
        theme.setTextColor(this.mContext, tvText1, "text_color"); //$NON-NLS-1$
        theme.setTextColor(this.mContext, tvText2, "text_color"); //$NON-NLS-1$
        theme.setBackgroundDrawable(this.mContext, divider, "vertical_divider_drawable"); //$NON-NLS-1$

        //Return the view
        return v;
    }

