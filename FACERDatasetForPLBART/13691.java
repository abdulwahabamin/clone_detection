    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (presenter == null) {
            presenter = new StoragePresenter(this, new StorageUtilHelper(getActivity()), AndroidSchedulers.mainThread());
        }
    }

