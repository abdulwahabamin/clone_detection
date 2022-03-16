    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();

        path = args.getString("path");

        newFileType = (FileType) args.getSerializable("mode");

        View v = View.inflate(getActivity(), R.layout.file_rename, null);
        nameInput = (EditText) v.findViewById(R.id.renameEditText);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        switch (newFileType) {
            case REG:
                builder.setTitle("New file");
                builder.setMessage("File will be created in " + path);
                break;
            case DIR:
                builder.setTitle("New folder");
                builder.setMessage("Folder will be created in " + path);
                break;
        }
        builder.setView(v);
        builder.setPositiveButton("OK", this);
        builder.setNegativeButton("CANCEL", this);
        return builder.create();
    }

