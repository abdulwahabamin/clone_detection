    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
        handler.removeCallbacksAndMessages(null);
        removePlayerListeners();
    }

