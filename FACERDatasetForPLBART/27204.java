    public void showError() {
        View view = getActivity().findViewById(R.id.viewpager);
        if (view != null) {
            String text = getResources().getString(R.string.error) + ": ";
            text += getResources().getString(R.string.failed_to_load_weather);
            Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
        }
    }

