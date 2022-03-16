    public static String saveImageToLocalDirectory(Bitmap bitmap,Context context, String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/"));
        String extStorageDirectory = Environment
                .getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES).toString();
        File folder = new File(extStorageDirectory, getFolderName());
        folder.mkdir();

        if (!folder.exists()) {
            Log.d("database",
                    "Sd card does not exist saving in app directory");
            File mypath = new File(folder, fileName);

            ContextWrapper cw = new ContextWrapper(context);
            folder = cw.getDir("imageDir", Context.MODE_PRIVATE);
        }

        File mypath = new File(folder, fileName);

        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream(mypath);

            // Use the compress method on the BitMap object to write image to
            // the OutputStream
            bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mypath.getAbsolutePath();
    }

