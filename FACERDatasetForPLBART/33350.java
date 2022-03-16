    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onCityNamesListItemClickedListener = (OnCityNamesListItemClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnCityNamesListItemClickedListener");
        }
    }

