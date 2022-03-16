    private void setCreateButtonListener() {

        create.setOnClickListener(view -> {
            operationFlag=true;
            Dialog dialog = new Dialog(this);
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawableResource(com.singh.multimeet.quicxplo.R.drawable.curved_back);
            dialog.setContentView(com.singh.multimeet.quicxplo.R.layout.rename_dialog_view);
            TextView title = dialog.findViewById(com.singh.multimeet.quicxplo.R.id.title);
            title.setText("New Folder");
            EditText newName = dialog.findViewById(com.singh.multimeet.quicxplo.R.id.new_name);
            newName.setText("New Folder");
            FloatingActionButton done = dialog.findViewById(com.singh.multimeet.quicxplo.R.id.done);
            done.setOnClickListener(view1 -> {
                if (!newName.getText().toString().equals("")) {
                    File newDir = new File(fileEx.getCurrentDir() + "/" + newName.getText());
                    try {
                        if (!fileEx.getCurrentDir().contains("emulated")) {
                            if (!newDir.exists()) {
                                Uri treeUri = Uri.parse(sharedPreferences.getString(Util.BASE_URI, ""));
                                DocumentFile documentFile = Util.getDocumentFile(this,
                                        Util.getProcessedPath(fileEx.getCurrentDir())
                                        , null, treeUri);
                                documentFile.createDirectory(newName.getText().toString());
                                showOrHideOptions(View.GONE);
                                setOrRefreshAdapter();
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Folder created", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(getApplicationContext(), "Folder already exists!!!", Toast.LENGTH_SHORT).show();
                        } else {
                            if (!newDir.exists()) {
                                showOrHideOptions(View.GONE);
                                setOrRefreshAdapter();
                                newDir.mkdirs();
                                Toast.makeText(getApplicationContext(), "Folder created", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            } else
                                Toast.makeText(getApplicationContext(), "Folder already exists!!!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Something went wrong!!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(getApplicationContext(), "Please give some name", Toast.LENGTH_SHORT).show();
            });
            dialog.show();

        });
    }

