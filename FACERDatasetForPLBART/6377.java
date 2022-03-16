    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeInt(VERSION_SPLIT_URI);
        DurableUtils.writeNullableString(out, authority);
        DurableUtils.writeNullableString(out, documentId);
        DurableUtils.writeNullableString(out, mimeType);
        DurableUtils.writeNullableString(out, displayName);
        out.writeLong(lastModified);
        out.writeInt(flags);
        DurableUtils.writeNullableString(out, summary);
        out.writeLong(size);
        out.writeInt(icon);
    }

