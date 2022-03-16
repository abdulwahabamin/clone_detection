    @Override public void handleMessage(final Message msg) {
      switch (msg.what) {
        case CACHE_HIT:
          stats.performCacheHit();
          break;
        case CACHE_MISS:
          stats.performCacheMiss();
          break;
        case BITMAP_DECODE_FINISHED:
          stats.performBitmapDecoded(msg.arg1);
          break;
        case BITMAP_TRANSFORMED_FINISHED:
          stats.performBitmapTransformed(msg.arg1);
          break;
        case DOWNLOAD_FINISHED:
          stats.performDownloadFinished((Long) msg.obj);
          break;
        default:
          Picasso.HANDLER.post(new Runnable() {
            @Override public void run() {
              throw new AssertionError("Unhandled stats message." + msg.what);
            }
          });
      }
    }

