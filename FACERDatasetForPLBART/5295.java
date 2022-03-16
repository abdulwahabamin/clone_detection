    void setDetailButtonListener() {
        details.setOnClickListener(view -> {
            if (selectedList.size() == 0) {
                successDialog("Select a file!!!", CDConstants.WARNING, CDConstants.MEDIUM);
                return;
            }
            if (selectedList.size() == 1) {
                operationFlag=true;
                Dialog propertiesDialog = new Dialog(this);
                propertiesDialog.setCancelable(true);
                propertiesDialog.getWindow().setBackgroundDrawableResource(com.singh.multimeet.quicxplo.R.drawable.curved_back);
                propertiesDialog.setContentView(com.singh.multimeet.quicxplo.R.layout.properties_dialog);

                TextView path = propertiesDialog.findViewById(com.singh.multimeet.quicxplo.R.id.path);
                TextView size = propertiesDialog.findViewById(com.singh.multimeet.quicxplo.R.id.size);
                TextView lastModified = propertiesDialog.findViewById(com.singh.multimeet.quicxplo.R.id.lastModified);
                TextView type = propertiesDialog.findViewById(com.singh.multimeet.quicxplo.R.id.type);

                // Font setting
                path.setTypeface(AppController.getTypeface());
                size.setTypeface(AppController.getTypeface());
                lastModified.setTypeface(AppController.getTypeface());
                type.setTypeface(AppController.getTypeface());

                // ok button listener
                Button ok = propertiesDialog.findViewById(com.singh.multimeet.quicxplo.R.id.ok);
                ok.setOnClickListener(view1 -> {
                    propertiesDialog.dismiss();
                });

                // setting data for properties
                path.setText(String.format(Locale.US, getResources()
                        .getString(com.singh.multimeet.quicxplo.R.string.path), selectedList.get(0).getPath()));
                size.setText(String.format(Locale.US, getResources()
                        .getString(com.singh.multimeet.quicxplo.R.string.size), selectedList.get(0).getSize()));

                if (selectedList.get(0).getFileOrDir() == FileDirectory.DIR) {
                    type.setText(String.format(Locale.US, getResources()
                            .getString(com.singh.multimeet.quicxplo.R.string.type), "Folder"));
                } else {
                    String ext = MimeTypeMap.getFileExtensionFromUrl(selectedList.get(0).getName().replace(" ", ""));
                    type.setText(String.format(Locale.US, getResources()
                            .getString(com.singh.multimeet.quicxplo.R.string.type), ext));
                }
                lastModified.setText(String.format(Locale.US, getResources()
                        .getString(com.singh.multimeet.quicxplo.R.string.lastModified), selectedList.get(0).getDate()));
                propertiesDialog.show();
            }
        });
    }

