    public Flowable<Integer> copyOrMoveFile(String inputPath, String inputFile, String outputPath, DocumentFile pickedDir, int select) {

        return Flowable.create(new FlowableOnSubscribe<Integer>() {

            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                InputStream in = null;
                OutputStream out = null;
                try {
                    //create output directory if it doesn't exist
                    File dir = new File(outputPath);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }

                    long size = new File(inputPath).length();
                    size /= 1024;
                    long total = 0;

                    Uri uri = Uri.fromFile(new File(inputPath));
                    MIME_TYPE = MimeTypeMap.getSingleton()
                            .getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()));
                    in = new FileInputStream(new File(inputPath + inputFile));

                    DocumentFile file = pickedDir.createFile(MIME_TYPE, outputPath);
                    out = getContentResolver().openOutputStream(file.getUri());

                    byte[] buffer = new byte[1024];
                    int read;
                    while ((read = in.read(buffer)) != -1) {
                        total += read / 1024;
                        if (e != null)
                            e.onNext((int) ((total / (double) size) * 100));
                        out.write(buffer, 0, read);
                    }

                    if (select == MOVE) {
                        file.delete();
                        Log.e(TAG, "moved!!!");
                    } else
                        Log.e(TAG, "copied!!!");
                    e.onComplete();
                    in.close();
                    out.flush();
                    out.close();

                } catch (Exception exp) {
                    exp.printStackTrace();
                    Log.e(TAG, exp.getMessage());
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

