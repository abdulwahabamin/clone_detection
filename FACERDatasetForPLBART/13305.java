    /**
     * Method that creates a new {@link AlertDialog} for choice between single options.
     *
     * @param context The current context
     * @param title The resource identifier of the title of the alert dialog
     * @param options An array with the options
     * @param defOption The default option
     * @param onSelectChoiceListener The listener for user choice
     * @return AlertDialog The alert dialog reference
     */
    public static AlertDialog createSingleChoiceDialog(
            Context context, int title,
            String[] options, int defOption,
            final OnSelectChoiceListener onSelectChoiceListener) {
        //Create the alert dialog
        final StringBuffer item = new StringBuffer().append(defOption);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCustomTitle(createTitle(context, 0, context.getString(title), false));

        // Create the adapter
        List<CheckableListAdapter.CheckableItem> items =
                new ArrayList<CheckableListAdapter.CheckableItem>(options.length);
        int cc = options.length;
        for (int i = 0; i < cc; i++) {
            boolean checked = (i == defOption);
            items.add(new CheckableListAdapter.CheckableItem(options[i], true, checked));
        }
        final CheckableListAdapter adapter = new CheckableListAdapter(context, items, true);

        // Create the list view and set as view
        final ListView listView = new ListView(context);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        listView.setLayoutParams(params);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item.delete(0, item.length());
                item.append(position);
                adapter.setSelectedItem(position);
            }
        });
        adapter.setSelectedItem(defOption);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        builder.setView(listView);

        // Apply the current theme
        Theme theme = ThemeManager.getCurrentTheme(context);
        theme.setBackgroundDrawable(context, listView, "background_drawable"); //$NON-NLS-1$
        listView.setDivider(
                theme.getDrawable(context, "horizontal_divider_drawable")); //$NON-NLS-1$

        builder.setNegativeButton(context.getString(R.string.cancel), new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onSelectChoiceListener.onNoSelectChoice();
                dialog.cancel();
            }
        });
        builder.setPositiveButton(context.getString(R.string.ok), new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onSelectChoiceListener.onSelectChoice(Integer.parseInt(item.toString()));
                dialog.dismiss();
            }
        });
        return builder.create();
    }

