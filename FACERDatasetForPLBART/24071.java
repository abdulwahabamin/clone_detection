    public static void queue(Context context, long[] list) {
        if (sService == null) {
            return;
        }
        sService.enqueue(list, MediaPlayback.LAST);
        String message = context.getResources().getQuantityString(
                R.plurals.NNNtrackstoplayqueue, list.length, list.length);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

