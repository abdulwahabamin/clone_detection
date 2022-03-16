    public static void interleave(Context context, long[] list, int currentCount, int newCount) {
        if (sService == null) {
            return;
        }
        sService.interleave(list, currentCount, newCount);
        String message = context.getResources().getQuantityString(
                R.plurals.NNNtrackstoplayqueue, list.length, list.length);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

