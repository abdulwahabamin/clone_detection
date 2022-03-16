        /**
         * Method invoke when a row item is going to be flinging.
         *
         * @param parent The AbsListView where the flinging happened
         * @param view The view within the AbsListView that was flingered
         * @param position The position of the view in the list
         * @param id The row id of the item that was flingered
         * @return boolean If the flinging operation must continue
         */
        boolean onItemFlingerStart(AdapterView<?> parent, View view, int position, long id);

