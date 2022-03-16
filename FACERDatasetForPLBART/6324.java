    public void copyFile(Uri input, Uri output) throws IOException {
        OutputStream os = getContentResolver().openOutputStream(output);
        InputStream is = getContentResolver().openInputStream(input);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
    }

