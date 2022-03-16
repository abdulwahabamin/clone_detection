    void createStorageChooser() {
        dialog = new Dialog(this);
        dialog.setCancelable(false);
        dialog.setOnDismissListener(dialogInterface -> {
            options.setImageResource(R.drawable.options);
        });
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(com.singh.multimeet.quicxplo.R.drawable.curved_back);
        dialog.setContentView(com.singh.multimeet.quicxplo.R.layout.storage_chooser_dialog);
        RecyclerView chooser = dialog.findViewById(com.singh.multimeet.quicxplo.R.id.chooser);
        chooser.setLayoutManager(new LinearLayoutManager(this));
        chooser.setHasFixedSize(true);
        storageChooserAdapter = new StorageChooserAdapter(storageSelectionList);
        chooser.setAdapter(storageChooserAdapter);
        dialog.show();
    }

