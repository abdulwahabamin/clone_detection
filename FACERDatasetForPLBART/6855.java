        @Override
        public void onClick(View v) {

            Log.i("Steps","onClick");
            TextView a = (TextView) v.findViewById(R.id.user_name);
            String clicked = a.getText().toString();
            Log.i("CustomError2", clicked);

            if (folderHistory.isEmpty())
                folderHistory = fh.getHistory();
            String history = folderHistory.peek();
            File clickedFile = new File(history, clicked);
            Log.i("CustomError2", clickedFile.toString());

            if (clickedFile.isDirectory()) {
                folderHistory.push(clickedFile.toString());
                activity.populateRecyclerViewValues(clickedFile.toString());
                Log.i("CustomError2", "|Directory");
            } else {
                String ext = getExtension(clickedFile.toString());
                activity.playFile(clickedFile.toString(),ext);
            }
        }

