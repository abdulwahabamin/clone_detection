    /**
     * Method that hides the configuration view.
     */
    public void hideConfigurationView() {
        //Check history
        if (this.mOnHistoryListener != null) {
            this.mOnHistoryListener.onCheckHistory();
        }

        //Transition
        setInAnimation(getContext(), R.anim.translate_to_right_in);
        setOutAnimation(getContext(), R.anim.translate_to_right_out);
        showPrevious();
    }

