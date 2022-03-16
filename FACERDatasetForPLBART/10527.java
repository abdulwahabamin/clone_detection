    /**
     * Method that creates and returns the title of the dialog.
     *
     * @param context The current context
     * @param icon The icon resource
     * @param title The resource identifier of the title of the alert dialog
     * @param allCaps If the title must have his text in caps or not
     * @return The title view
     */
    private static View createTitle(Context context, int icon, String title, boolean allCaps) {
        //Inflate the dialog layouts
        LayoutInflater li =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View lyTitle = li.inflate(R.layout.dialog_title, null);
        ImageView vIcon = (ImageView)lyTitle.findViewById(R.id.dialog_title_icon);
        if (icon != 0) {
            vIcon.setBackgroundResource(icon);
        } else {
            vIcon.setVisibility(View.GONE);
        }
        TextView vText = (TextView)lyTitle.findViewById(R.id.dialog_title_text);
        if (allCaps) {
            vText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        }
        vText.setText(title);

        // Apply the current theme
        Theme theme = ThemeManager.getCurrentTheme(context);
        theme.setBackgroundDrawable(context, lyTitle, "background_drawable"); //$NON-NLS-1$
        theme.setTextColor(context, vText, "dialog_text_color"); //$NON-NLS-1$

        return lyTitle;
    }

