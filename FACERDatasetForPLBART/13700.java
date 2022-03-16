    @Override
    public void onAdapterItemDeleteClicked(View view, int position) {
        FileModel fileModel = adapter.getItem(position);

        presenter.performFileDeletion(fileModel);
    }

