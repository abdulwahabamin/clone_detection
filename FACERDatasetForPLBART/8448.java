    /**
     * {@inheritDoc}
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Highlight the text
        View v = super.getView(position, convertView, parent);
        if (v != null) {
            Theme theme = ThemeManager.getCurrentTheme(this.mContext);
            TextView tvText = (TextView)v.findViewById(R.id.menu_item_text);
            if (tvText != null) {
                tvText.setTextAppearance(this.mContext, R.style.primary_text_appearance);
                theme.setTextColor(this.mContext, tvText, "text_color"); //$NON-NLS-1$
            }
        }
        //Return the view
        return v;
    }

