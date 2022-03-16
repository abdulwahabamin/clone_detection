    public static boolean copy(String[] paths)
    {
        InputStream in;
        OutputStream out;
        File src, dst;
        String srcPath, dstPath;

        try {
            dstPath = paths[paths.length - 1];
            dst = new File(dstPath);

            for (int i = 0; i < paths.length - 1; i++) {
                srcPath = paths[i];
                src = new File(srcPath);

                if (src.isDirectory()) {
                    if (!dst.exists()) {
                        dst.mkdirs();
                    }

                    String[] files = src.list();
                    // recursively copy all sub-items
                    for (int j = 0; j < files.length; j++) {
                        copy(new File(src, files[j]).getCanonicalPath(), new File(dst, files[j]).getCanonicalPath());
                    }
                } else {
                    in = new FileInputStream(srcPath);

                    if (new File(dstPath).isDirectory()) {
                        dstPath += File.separator + src.getName();
                    }

                    if (new File(dstPath).exists()) {
                        dstPath = renameCopy(dstPath);
                    }

                    out = new FileOutputStream(dstPath);

                    byte[] buffer = new byte[1024];
                    int read;
                    while ((read = in.read(buffer)) != -1) {
                        out.write(buffer, 0, read);
                    }

                    in.close();
                    out.flush();
                    out.close();
                }
            }
            return true;
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

