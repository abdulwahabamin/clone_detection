    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSelectCity) {
            onSelectCity = (OnSelectCity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

