    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = new LinearLayout(parent.getContext());
        }

        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1f / mColumns;

        final LinearLayout row = (LinearLayout) convertView;
        final int first = position * mColumns;
        final int last = mWrapped.getCount() - 1;

        for (int i = 0; i < mColumns; i++) {
            View convertItem = null;
            if (i < row.getChildCount()) {
                convertItem = row.getChildAt(i);
            }

            final int pos = first + i;
            final int validPos = Math.min(pos, last);
            final View item = mWrapped.getView(validPos, convertItem, row);
            item.setTag(validPos);
            item.setOnClickListener(mItemListener);
            item.setFocusable(true);

            if (pos == validPos) {
                item.setVisibility(View.VISIBLE);
            } else {
                item.setVisibility(View.INVISIBLE);
            }

            if (convertItem == null) {
                row.addView(item, params);
            }
        }

        return convertView;
    }

