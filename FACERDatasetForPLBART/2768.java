    private void showProperties(String path) {
        Bundle args = new Bundle();
        args.putString("path", path);
        DialogFragment propsFragment = new FilePropsDialogFragment();
        propsFragment.setArguments(args);
        propsFragment.show(getSupportFragmentManager(), "props");
    }

