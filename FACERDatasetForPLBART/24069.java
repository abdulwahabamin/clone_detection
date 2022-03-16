    public static void queueNextAndPlayIfNotAlreadyPlaying(Context context, long[] songs) {
         if (isPlaying()) {
             queueNext(context, songs);
         } else {
             queueAndPlayImmediately(context, songs);
         }
    }

