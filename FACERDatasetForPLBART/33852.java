        /**
         * Return the floating View for item at <code>position</code>.
         * DragSortListView will measure and layout this View for you,
         * so feel free to just inflate it. You can help DSLV by
         * setting some {@link ViewGroup.LayoutParams} on this View;
         * otherwise it will set some for you (with a width of FILL_PARENT
         * and a height of WRAP_CONTENT).
         *
         * @param position Position of item to drag (NOTE:
         * <code>position</code> excludes header Views; thus, if you
         * want to call {@link ListView#getChildAt(int)}, you will need
         * to add {@link ListView#getHeaderViewsCount()} to the index).
         *
         * @return The View you wish to display as the floating View.
         */
        public View onCreateFloatView(int position);

