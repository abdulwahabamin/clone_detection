    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (presenter == null) {
            presenter = new AppFragmentPresenter(this,
                    PackageManagerHelper.getInstance(getActivity().getPackageManager(), getActivity()),
                    AndroidSchedulers.mainThread());
        }
    }

