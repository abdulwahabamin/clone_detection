    void setOptionsButtonListener(){
        // share button listener
        share.setOnClickListener(view -> {
            if(selectionList.size()>0){
                ArrayList<Uri> uris = new ArrayList<>();

                for (FileDirectory file : selectionList) {
                    uris.add(Uri.fromFile(new File(file.getPath())));
                }

                final Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                intent.setType("*/*");
                intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                startActivity(Intent.createChooser(intent, "Send"));
            }
        });


    }

