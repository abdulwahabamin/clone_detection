            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                final TextView textView = new TextView(getActivity());
                int padding = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
                textView.setPadding(padding, padding, padding, padding);
                textView.setLineSpacing(0, 1.2f);
                textView.setLinkTextColor(ContextCompat.getColor(getActivity(), R.color.link_color));
                textView.setText(R.string.licenses);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                return new AlertDialog.Builder(getActivity())
                        .setTitle("Open source licenses")
                        .setView(textView)
                        .setPositiveButton(android.R.string.ok, null)
                        .create();
            }

