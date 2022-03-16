        /**
         * Makes the list to look nicer by setting alternating backgrounds to it's items (rows).
         *
         * @param position city list position
         * @param rowView  a view displaying a single list item
         */
        private void setBackgroundForListRow(int position, View rowView) {
            if (position % 2 == 1) {
                rowView.setBackgroundResource(BaseCityCursorAdapter.BACKGROUND_RESOURCE_ODD);
            } else {
                rowView.setBackgroundResource(BaseCityCursorAdapter.BACKGROUND_RESOURCE_EVEN);
            }
        }

