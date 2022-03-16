    private static void startCamera(Activity activity) {
        String imagePath = FileUtils.getCameraImagePath(activity);
        File imageFile = new File(imagePath);
        Uri uri = FileUtils.getUriForFile(activity, imageFile);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        activity.startActivityForResult(intent, RequestCode.REQUEST_CAMERA);
    }

