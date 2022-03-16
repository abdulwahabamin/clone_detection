    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.open:
                openFileDialog(info.position);
                return true;
            case R.id.edit:
                try
                {
                    File file = new File(current_path, files[info.position]);
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    StringBuilder stringBuilder = new StringBuilder();
                    String file_content;
                    while ((file_content = bufferedReader.readLine()) != null)
                    {
                        stringBuilder.append(file_content);
                    }
                    bufferedReader.close();
                    editFileDialog(stringBuilder.toString(), file);
                }catch (Exception ex)
                {
                    Snackbar.make(findViewById(android.R.id.content), ex.getMessage(), Snackbar.LENGTH_SHORT).show();
                    finish();
                }
                return true;
            case R.id.copy:
                File file_from_active_window;
                File file_from_other_window;
                try
                {
                    if (active_window == 1)
                    {
                        file_from_active_window = new File(current_path, files[info.position]);
                        file_from_other_window = new File(current_path_second_window, files[info.position]);
                    }
                    else
                    {
                        file_from_active_window = new File(current_path, files[info.position]);
                        file_from_other_window = new File(current_path_first_window, files[info.position]);
                    }
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file_from_active_window));
                    StringBuilder stringBuilder = new StringBuilder();
                    String file_content;
                    while ((file_content = bufferedReader.readLine()) != null)
                    {
                        stringBuilder.append(file_content);
                    }
                    bufferedReader.close();
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_from_other_window));
                    bufferedWriter.write(stringBuilder.toString());
                    bufferedWriter.close();
                }catch (Exception ex)
                {
                    Snackbar.make(findViewById(android.R.id.content), ex.getMessage(), Snackbar.LENGTH_SHORT).show();
                    finish();
                }
                Snackbar.make(findViewById(android.R.id.content), "Successfully created copy of " + files[info.position], Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.move:
                if (active_window == 1)
                {
                    file_from_active_window = new File(current_path, files[info.position]);
                    file_from_other_window = new File(current_path_second_window, files[info.position]);
                }
                else
                {
                    file_from_active_window = new File(current_path, files[info.position]);
                    file_from_other_window = new File(current_path_first_window, files[info.position]);
                }
                file_from_active_window.renameTo(file_from_other_window);
                Snackbar.make(findViewById(android.R.id.content), "Successfully moved " + files[info.position], Snackbar.LENGTH_SHORT).show();
                updateList();
                return true;
            case R.id.rename:
                renameFileDialog(list.getItemAtPosition(info.position).toString(), info.position);
                return true;
            case R.id.delete:
                deleteFileDialog(info.position);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

