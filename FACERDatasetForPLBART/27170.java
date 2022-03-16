    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog builder = new Dialog(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_about, null);
        TextView title = (TextView) view.findViewById(R.id.about_title_text);
        if (null != title) {
            title.setText(getString(R.string.about));
        }
        TextView message = (TextView) view.findViewById(R.id.dialog_message);
        if (null != message) {
            message.setText(fromHtml(getString(R.string.about_content)));
        }
        Button btnOk = (Button) view.findViewById(R.id.button_ok);
        if (null != btnOk) {
            btnOk.setOnClickListener(this);
        }
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        builder.setCanceledOnTouchOutside(false);
        builder.setCancelable(false);
        builder.setContentView(view);
        return  builder;
    }

