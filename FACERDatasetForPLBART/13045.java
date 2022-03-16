    /**
     * Method that returns if the breadcrumb view is visible.
     *
     * @return boolean If the breadcrumb view is visible
     */
    public boolean isConfigurationViewShowing() {
        return getCurrentView().getId() != R.id.tb_breadcrumb;
    }

