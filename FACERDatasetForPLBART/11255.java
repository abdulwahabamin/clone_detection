    /**
     * Method that inflates the menu.
     *
     * @param menuResourceId The resource identifier of the menu to be inflated
     */
    private void inflateMenu(int menuResourceId) {
        MenuInflater inflater = new MenuInflater(this.mContext);
        inflater.inflate(menuResourceId, this.mMenu);
    }

