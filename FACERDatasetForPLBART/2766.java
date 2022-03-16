    private void createFile(FileType ftype)
    {
        Bundle args = new Bundle();
        try {
            args.putString("path", currentDir.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        args.putSerializable("mode", ftype);
        DialogFragment mkFileFragment = new FileCreateDialogFragment();
        mkFileFragment.setArguments(args);
        mkFileFragment.show(getSupportFragmentManager(), "newitem");
    }

