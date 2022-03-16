    private void showTargets() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new MaterialTapTargetPrompt.Builder(activity())
                        .setTarget(R.id.fab)
                        .setBackgroundColour(ContextCompat.getColor(context(), R.color.md_light_blue_400))
                        .setFocalColour(ContextCompat.getColor(context(), R.color.colorAccent))
                        .setPrimaryText(getString(R.string.target_search_title))
                        .setSecondaryText(getString(R.string.target_search_content))
                        .setIconDrawableColourFilter(ContextCompat.getColor(context(), R.color.md_black_1000))
                        .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                            @Override
                            public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED || state == MaterialTapTargetPrompt.STATE_DISMISSING)
                                    showRefresh();
                            }
                        })
                        .show();
            }
        }, 4500);
    }

