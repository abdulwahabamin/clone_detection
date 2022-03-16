    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeInt(VERSION_ADD_ROOT);
        if (root != null) {
            out.writeBoolean(true);
            root.write(out);
        } else {
            out.writeBoolean(false);
        }
        final int size = size();
        out.writeInt(size);
        for (int i = 0; i < size; i++) {
            final DocumentInfo doc = get(i);
            doc.write(out);
        }
    }

