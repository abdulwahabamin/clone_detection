    void setShareButtonListener() {


        share.setOnClickListener(view -> {
            if (selectedList.size() == 0) {
                successDialog("Select a file!!!", CDConstants.WARNING, CDConstants.MEDIUM);
                return;
            }
            if (selectedList.size() > 0) {
                operationFlag=true;
                ArrayList<Uri> uris = new ArrayList<>();

                for (FileDirectory file : selectedList) {
                    uris.add(Uri.fromFile(new File(file.getPath())));
                }
                final Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                intent.setType("*/*");
                intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                startActivity(Intent.createChooser(intent, "Send"));
            } else {
                Toast.makeText(getApplicationContext(), "Please select some file.", Toast.LENGTH_SHORT).show();
            }
        });
    }

