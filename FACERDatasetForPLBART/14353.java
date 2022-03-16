    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        if (themePackageName != null && themePackageName.toString().length() > 0) {
            TextView vThemeTitle = (TextView)view.findViewById(R.id.themeTitle);
            vThemeTitle.setText(themeName);
            TextView vThemeDescription = (TextView)view.findViewById(R.id.themeDescription);
            vThemeDescription.setMovementMethod(LinkMovementMethod.getInstance());
            vThemeDescription.setText(Html.fromHtml(themeDescription.toString()));
            ImageView vThemePreview = (ImageView)view.findViewById(R.id.themeIcon);
            if (themePreview != null)
                vThemePreview.setImageDrawable(themePreview);
            else
                vThemePreview.setImageResource(R.drawable.ic_launcher);
            vThemeTitle.setText(themeName);

            Button applyButton = (Button)view.findViewById(R.id.themeApply);
            applyButton.setEnabled(true);
        } else {
            Button applyButton = (Button)view.findViewById(R.id.themeApply);
            applyButton.setEnabled(false);
        }
    }

