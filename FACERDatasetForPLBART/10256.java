    /**
     * Method that shows the configuration view.
     */
    public void showConfigurationView() {
        //Transition
        setInAnimation(getContext(), R.anim.translate_to_left_in);
        setOutAnimation(getContext(), R.anim.translate_to_left_out);
        showNext();
    }

