    @Override
    public void read(DataInputStream in) throws IOException {
        final int version = in.readInt();
        switch (version) {
            case VERSION_INIT:
                throw new ProtocolException("Ignored upgrade");
            case VERSION_SPLIT_URI:
                authority = DurableUtils.readNullableString(in);
                documentId = DurableUtils.readNullableString(in);
                mimeType = DurableUtils.readNullableString(in);
                displayName = DurableUtils.readNullableString(in);
                lastModified = in.readLong();
                flags = in.readInt();
                summary = DurableUtils.readNullableString(in);
                size = in.readLong();
                icon = in.readInt();
                deriveFields();
                break;
            default:
                throw new ProtocolException("Unknown version " + version);
        }
    }

