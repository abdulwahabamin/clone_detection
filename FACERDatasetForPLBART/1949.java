    public static String takeImageFromCameraAndSave(Context ctx,String filename,int requestCode) throws IOException
    {
        File file= getOutputMediaFile(ctx,filename);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, getFileProviderUri(file));
        }else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        }

        if (ctx instanceof Activity)
            ((Activity) ctx).startActivityForResult(intent,requestCode);


        return file.getPath();
    }

