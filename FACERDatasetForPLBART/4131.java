    @Override
    public void onSaveInstanceState(Bundle outState) {
        //BLog.e("SAVE", "SAVE instance state");
        outState.clear();
        State.saveState(outState);
    }

