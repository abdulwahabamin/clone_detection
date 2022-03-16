    private void switchWindows()
    {
        if (active_window != 1)
        {
            current_path_second_window = current_path;
            current_path = current_path_first_window;
            active_window = 1;
        }
        else
        {
            current_path_first_window = current_path;
            current_path = current_path_second_window;
            active_window = 2;
        }
        Snackbar.make(findViewById(android.R.id.content), "Current active window is " + active_window, Snackbar.LENGTH_SHORT).show();
        updateList();
    }

