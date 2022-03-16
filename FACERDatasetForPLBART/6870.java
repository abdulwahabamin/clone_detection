    public void playFile(String clickedFile,String type)
    {
        File file = new File(clickedFile);
        Intent target = new Intent(Intent.ACTION_VIEW);
        if(type.compareTo("pdf")==0)
            target.setDataAndType(Uri.fromFile(file),"application/pdf");
        else if(type.compareTo("mp3")==0)
            target.setDataAndType(Uri.fromFile(file),"audio/*");
        else if(type.compareTo("txt")==0)
            target.setDataAndType(Uri.fromFile(file),"text/plain");
        else
            target.setDataAndType(Uri.fromFile(file),"image/*");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(target, "Open File");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Instruct the user to install a PDF reader here, or something
        }
    }

