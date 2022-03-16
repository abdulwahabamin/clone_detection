    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        HashMap<String, String> props;
        Bundle args = getArguments();
        View v;
        AlertDialog.Builder builder;
        String msg;

        v = View.inflate(getActivity(), R.layout.file_props, null);

        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Properties");

        props = FileHelpers.getProperties(getContext(), args.getString("path"));

        msg = "";
        for (LinkedHashMap.Entry<String, String> entry : props.entrySet()) {
           msg += entry.getKey() + ": \t" + entry.getValue() + "\n";
        }

        builder.setMessage(msg);
        builder.setView(v);
        builder.setPositiveButton("OK", this);

        return builder.create();
    }

