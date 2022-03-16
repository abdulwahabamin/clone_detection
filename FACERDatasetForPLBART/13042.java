    /**
     * Method that resets the view flipper positioning the current view
     * in the breadcrumb view.
     */
    public void restoreView() {
        if (getCurrentView().getId() != R.id.tb_breadcrumb) {
            hideConfigurationView();
        }
    }

