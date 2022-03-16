    private void initDependencies(){
        final Preference buildDepend = findPreference(BUILD_DEPENDS);
        buildDepend.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(final Preference preference) {
            	
            	final WebView webView = new WebView(mContext);
                webView.loadUrl("file:///android_asset/licenses.html");
                new AlertDialog.Builder(mContext)
                        .setTitle(R.string.dependencies_title)
                        .setView(webView)
                        .setPositiveButton(android.R.string.ok, null)
                        .create()
                        .show();
                return true;
            }
        });
    }

