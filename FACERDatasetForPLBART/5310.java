    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            dir = intent.getStringExtra(getResources().getString(com.singh.multimeet.quicxplo.R.string.dir_reference));
        }

        if (isExternalAvailable() && dir != null) {
            fileEx = FileEx.newFileManager(dir, this);
            loadDirectories();
            breadCrumbsAdapter = new BreadCrumbsAdapter(fileEx.getCurrentDir(), crumbs);
            breadCrumbsAdapter.setCrumbList(fileEx.getCurrentDir());
            crumbs.setAdapter(breadCrumbsAdapter);
        }
    }

