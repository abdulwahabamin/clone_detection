    private String buildPlayQueueWhereClause(long[] playQueue) {
        StringBuilder where = new StringBuilder();
        where.append(MediaStore.Audio.AudioColumns._ID + " IN (");
        for (int i = 0; i < playQueue.length; i++) {
            where.append(playQueue[i]);
            if (i < playQueue.length - 1) {
                where.append(",");
            }
        }
        where.append(")");
        return where.toString();
    }

