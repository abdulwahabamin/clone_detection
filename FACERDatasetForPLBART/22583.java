    private static int readOgg(byte[] buf, InputStream in, int bytesinpage, int skip) throws IOException {
        int toread = skip != -1 ? skip : buf.length;
        int offset = 0;
        while (toread > 0) {
            if (bytesinpage == 0) {
                byte magic[] = new byte[4];
                in.read(magic);
                if (!Arrays.equals(magic, new byte[]{'O', 'g', 'g', 'S'})) {
                    in.close();
                    throw new IOException();
                }
                byte header[] = new byte[23];
                in.read(header);
                int count = header[22] & 0xFF;
                while (count-- > 0) {
                    bytesinpage += in.read();
                }
            }
            int read = toread;
            if (bytesinpage - toread < 0) read = bytesinpage;
            if (skip != -1)
                in.skip(read);
            else
                in.read(buf, offset, read);
            offset += read;
            toread -= read;
            bytesinpage -= read;
        }
        return bytesinpage;
    }

