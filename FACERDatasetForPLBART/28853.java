    @Override
    public void onDetach() {
        ViewUpdater.removeSubsriber(this);

        super.onDetach();
    }

