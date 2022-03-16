    private boolean writeToFile(ResponseBody body, long startSet, long mDownedSet) {
        try {
            File tmpFile = new File(saveFileName);
            if (!tmpFile.exists()) {
                if (!tmpFile.createNewFile()) {
                    return false;
                }
            }
            RandomAccessFile savedFile = new RandomAccessFile(tmpFile, "rwd");
            savedFile.seek(startSet + mDownedSet);
            InputStream inputStream = null;
            try {
                byte[] fileReader = new byte[4096];

                inputStream = body.byteStream();

                while (fileSizeDownloaded < needDownSize) {
                    int read = inputStream.read(fileReader);
                    if (read == -1) {
                        break;
                    }
                    savedFile.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    if (fileSizeDownloaded >= CALL_BACK_LENGTH) {
                        onDownLoading(fileSizeDownloaded);
                        needDownSize -= fileSizeDownloaded;
                        fileSizeDownloaded = 0;
                    } else {
                        if (needDownSize < CALL_BACK_LENGTH) {
                            if (fileSizeDownloaded - 1 == needDownSize) {
                                onDownLoading(fileSizeDownloaded);
                                break;
                            }
                        }
                    }
                }
                return true;
            } finally {

                savedFile.close();

                if (inputStream != null) {
                    inputStream.close();
                }
            }

        } catch (IOException e) {
            if (e instanceof InterruptedIOException && !(e instanceof SocketTimeoutException)) {
                onCancel();
            } else {
                onError(e);
            }
            return false;
        }
    }

