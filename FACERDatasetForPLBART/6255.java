    @Override
    public void close() {
        IoUtils.closeQuietly(cursor);
        ContentProviderClient.releaseQuietly(client);
        cursor = null;
        client = null;
    }

