    public static void showQueuedSnackBar(View v, String s, int length)
    {
        Snackbar snackbar = Snackbar.make(v, s, length);
        snackbar.setCallback(new Snackbar.Callback()
        {
            @Override
            public void onDismissed(Snackbar currentSnackbar, int event)
            {
                super.onDismissed(currentSnackbar, event);
                snackBarList.remove(currentSnackbar);
                if (snackBarList.size() > 0)
                {
                    snackBarList.get(0).show();
                }
            }
        });
        snackBarList.add(snackbar);
        if (snackBarList.size() == 1)
        {
            snackBarList.get(0).show();
        }
    }

