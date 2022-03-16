    /**
     * Method that sets the selected item
     *
     * @param position The position of the selected item
     */
    public void setSelectedItem(int position) {
        int cc = getCount();
        for (int i = 0; i < cc; i++) {
            getItem(i).mChecked = (i == position);
        }
        notifyDataSetChanged();
    }

