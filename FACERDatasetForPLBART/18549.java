	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

		parentActivity = getActivity();
		dialog = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        String title = getArguments().getString("TITLE");
        String text = getArguments().getString("TEXT");
        
        View progressView = parentActivity.getLayoutInflater().inflate(R.layout.determinate_progress_dialog, null);
        progressText = (TextView) progressView.findViewById(R.id.determinate_progress_dialog_text);
        progressText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
        progressText.setPaintFlags(progressText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        progressText.setText(text);
        
        progressBar = (ProgressBar) progressView.findViewById(R.id.determinate_progress_dialog_bar);
        
        builder.setTitle(title);
        builder.setView(progressView);

        return builder.create();
    }

