    /**
     * {@inheritDoc}
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Recovers the menu item
        Theme theme = ThemeManager.getCurrentTheme(this.mContext);
        MenuItem menuItem = getItem(position);

        //Is a separator?
        View v = null;
        if (menuItem.getTitle() == null || menuItem.getTitle().length() == 0) {
            v = this.mInflater.inflate(R.layout.menu_item_separator, parent, false);
        } else {
            v = this.mInflater.inflate(R.layout.menu_item, parent, false);
        }
        theme.setBackgroundDrawable(
                this.mContext, v,
                "selectors_deselected_drawable"); //$NON-NLS-1$

        //Set the text if has title
        if (menuItem.getTitle() != null && menuItem.getTitle().length() > 0) {
            TextView tvText = (TextView)v.findViewById(R.id.menu_item_text);
            tvText.setText(menuItem.getTitle());
            theme.setTextColor(this.mContext, tvText, "text_color"); //$NON-NLS-1$

            ImageView vCheck = (ImageView)v.findViewById(R.id.menu_item_check);
            vCheck.setVisibility(menuItem.isCheckable() ? View.VISIBLE : View.GONE);
            if (!mMultiSelect) {
                theme.setImageDrawable(
                        this.mContext, vCheck, "popup_checkable_selector_drawable"); //$NON-NLS-1$
            } else {
                theme.setImageDrawable(
                        this.mContext, vCheck, "menu_checkable_selector_drawable"); //$NON-NLS-1$
            }
            if (menuItem.isCheckable()) {
                vCheck.setSelected(menuItem.isChecked());
            }
        }
        v.setEnabled(menuItem.isEnabled());
        v.setVisibility(menuItem.isVisible() ? View.VISIBLE : View.GONE);

        //Return the view
        return v;
    }

