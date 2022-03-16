    public void renameFile(String path) {
        Bundle args = new Bundle();
        args.putString("path", path);
        DialogFragment renameFragment = new FileRenameDialogFragment();
        renameFragment.setArguments(args);
        renameFragment.show(getSupportFragmentManager(), "rename");
    }

