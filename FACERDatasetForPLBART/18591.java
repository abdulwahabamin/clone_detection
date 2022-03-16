	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		parentActivity = getActivity();
		dialogFragment = (DialogFragment) getFragmentManager().findFragmentByTag("licensesDialog");
		
		rootView = (View) parentActivity.getLayoutInflater().inflate(R.layout.licenses_dialog_layout, null);
		
		creativeCommonsLink = (TextView) rootView.findViewById(R.id.creative_commons_link);
		creativeCommonsLink.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		creativeCommonsLink.setText(Html.fromHtml("<a href=\"http://creativecommons.org/licenses/by-sa/3.0/legalcode\">Creative Commons ShareALike 3.0 License</a> "));
		creativeCommonsLink.setMovementMethod(LinkMovementMethod.getInstance());
		
		creativeCommonsInfo = (TextView) rootView.findViewById(R.id.licenses_text);
		creativeCommonsInfo.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Set the dialog title.
        builder.setTitle(R.string.licenses);
        builder.setView(rootView);
        builder.setPositiveButton(R.string.done, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				dialogFragment.dismiss();
				getActivity().finish();
				
			}
        	
        });

        return builder.create();
    }

