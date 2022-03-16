    /**
     * Performing copy file operation
     *
     * @param srcFile
     * @param destDir
     * @return true -> success, false -> fail
     */
    public boolean copyFile(File srcFile, File destDir) throws IOException {
        InputStream in = null;
        OutputStream out = null;

        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        in = new FileInputStream(srcFile);
        out = new FileOutputStream(destDir.getPath() + File.separator + srcFile.getName());

        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
        in.close();
        in = null;

        // write the output file (You have now copied the file)
        out.flush();
        out.close();
        out = null;

        return true;
    }

