    private void upload() {
        showProgress(getString(R.string.uploading_image));
        BmobFile file = new BmobFile(new File(path));
        file.uploadblock(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    showProgress(getString(R.string.publishing));
                    imageWeather.setImageUrl(file.getFileUrl());
                    imageWeather.setSay(etSay.getText().toString());
                    imageWeather.setTag(tagLayout.getTag());
                    imageWeather.save(new SaveListener<String>() {
                        @Override
                        public void done(String objectId, BmobException e) {
                            if (e == null) {
                                cancelProgress();
                                Toast.makeText(UploadImageActivity.this, getString(R.string.publish_success,
                                        imageWeather.getLocation().getCity()), Toast.LENGTH_SHORT).show();
                                setResult(RESULT_OK);
                                finish();
                            } else {
                                Log.e(TAG, "upload object fail", e);
                                cancelProgress();
                                SnackbarUtils.show(UploadImageActivity.this, getString(R.string.publish_fail, e.getMessage()));
                            }
                        }
                    });
                } else {
                    Log.e(TAG, "upload image fail", e);
                    cancelProgress();
                    SnackbarUtils.show(UploadImageActivity.this, getString(R.string.upload_image_fail, e.getMessage()));
                }
            }
        });
    }

