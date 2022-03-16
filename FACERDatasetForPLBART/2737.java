    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Bundle args = getArguments();

        f = new File(args.getString("path"));

        View v = View.inflate(getActivity(), R.layout.file_rename, null);

        nameInput = (EditText) v.findViewById(R.id.renameEditText);
        nameInput.setText(f.getName());

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Rename");
        builder.setMessage("Enter new name:");
        builder.setView(v);
        builder.setPositiveButton("OK", this);
        builder.setNegativeButton("CANCEL", this);
        return builder.create();
    }

