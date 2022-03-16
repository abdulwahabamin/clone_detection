    private static void addFileItem(ZipOutputStream zout, FileItem file) {
        try
        {
            //System.out.println("Adding file " + files[i].getName());

            //create byte buffer
            byte[] buffer = new byte[1024];

            //create object of FileInputStream
            File usefile=file.getAbsoluteFile();
            FileInputStream fin = new FileInputStream(usefile.getAbsoluteFile());

            zout.putNextEntry(new ZipEntry(usefile.getName()));

                        /*
                         * After creating entry in the zip file, actually
                         * write the file.
                         */
            int length;

            while((length = fin.read(buffer)) > 0)
            {
                zout.write(buffer, 0, length);
            }

                        /*
                         * After writing the file to ZipOutputStream, use
                         *
                         * void closeEntry() method of ZipOutputStream class to
                         * close the current entry and position the stream to
                         * write the next entry.
                         */

            zout.closeEntry();

            //close the InputStream
            fin.close();

        }
        catch(IOException ioe)
        {
            //BLog.add("ZIP IOException :" + ioe);
        }
    }

