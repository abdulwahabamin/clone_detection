        /**
         * Method invoke when a row item was flingered.
         *
         * @param responder The responder to the flinging action. You MUST be invoke one
         * the option methods of this interface (accept or cancel).
         * @param parent The AbsListView where the flinging happened
         * @param view The view within the AbsListView that was flingered
         * @param position The position of the view in the list
         * @param id The row id of the item that was flingered
         */
        void onItemFlingerEnd(
                OnItemFlingerResponder responder,
                AdapterView<?> parent, View view, int position, long id);

