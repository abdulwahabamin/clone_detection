    private void showRefresh() {
        new MaterialTapTargetPrompt.Builder(activity())
                .setTarget(R.id.toolbar)
                .setBackgroundColour(ContextCompat.getColor(context(), R.color.md_light_blue_400))
                .setPrimaryText(getString(R.string.target_refresh_title))
                .setFocalColour(ContextCompat.getColor(context(), R.color.colorAccent))
                .setSecondaryText(getString(R.string.target_refresh_content))
                .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                    @Override
                    public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED || state == MaterialTapTargetPrompt.STATE_DISMISSING)
                            showLocTarget();
                    }
                })
                .show();
    }

