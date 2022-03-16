    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mResult.setText(null);
        String result = "resultCode=" + resultCode + ", data=" + String.valueOf(data);

        if (requestCode == CODE_READ) {
            final Uri uri = data != null ? data.getData() : null;
            if (uri != null) {
                if (DocumentsContract.isDocumentUri(this, uri)) {
                    result += "; DOC_ID";
                }
                try {
                    getContentResolver().takePersistableUriPermission(
                            uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                } catch (SecurityException e) {
                    result += "; FAILED TO TAKE";
                    Log.e(TAG, "Failed to take", e);
                }
                InputStream is = null;
                try {
                    is = getContentResolver().openInputStream(uri);
                    final int length = Streams.readFullyNoClose(is).length;
                    result += "; read length=" + length;
                } catch (Exception e) {
                    result += "; ERROR";
                    Log.e(TAG, "Failed to read " + uri, e);
                } finally {
                    IoUtils.closeQuietly(is);
                }
            } else {
                result += "no uri?";
            }
        } else if (requestCode == CODE_WRITE) {
            final Uri uri = data != null ? data.getData() : null;
            if (uri != null) {
                if (DocumentsContract.isDocumentUri(this, uri)) {
                    result += "; DOC_ID";
                }
                try {
                    getContentResolver().takePersistableUriPermission(
                            uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                } catch (SecurityException e) {
                    result += "; FAILED TO TAKE";
                    Log.e(TAG, "Failed to take", e);
                }
                OutputStream os = null;
                try {
                    os = getContentResolver().openOutputStream(uri);
                    os.write("THE COMPLETE WORKS OF SHAKESPEARE".getBytes());
                } catch (Exception e) {
                    result += "; ERROR";
                    Log.e(TAG, "Failed to write " + uri, e);
                } finally {
                    IoUtils.closeQuietly(os);
                }
            } else {
                result += "no uri?";
            }
        }

        Log.d(TAG, result);
        mResult.setText(result);
    }

