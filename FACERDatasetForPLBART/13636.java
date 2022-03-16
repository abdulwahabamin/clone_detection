    @Override
    public void onAppUnInstallClicked(View view, int position) {
        AppModel appModel = adapter.getItem(position);

        // Performing app uninstall operation
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + appModel.getPackageName()));
        startActivity(intent);
    }

