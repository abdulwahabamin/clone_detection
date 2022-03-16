        /**
         * Called whenever the floating View is dragged. Float View
         * properties can be changed here. Also, the upcoming location
         * of the float View can be altered by setting
         * <code>location.x</code> and <code>location.y</code>.
         *
         * @param floatView The floating View.
         * @param location The location (top-left; relative to DSLV
         * top-left) at which the float
         * View would like to appear, given the current touch location
         * and the offset provided in {@link DragSortListView#startDrag}.
         * @param touch The current touch location (relative to DSLV
         * top-left).
         * @param pendingScroll 
         */
        public void onDragFloatView(View floatView, Point location, Point touch);

