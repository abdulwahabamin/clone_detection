    public void populateRecyclerViewValues(String fileName) {

        Log.i("Steps", "populateRecyleverView");
        listContentArr = new ArrayList<>();
        FileList l = new FileList(fileName);
        String [][] data = l.getFileList();



        for(int i = 0 ;i< data.length;i++) {
            //Creating POJO class object
            FilePOJO pojoObject = new FilePOJO();
            //Values are binded using set method of the POJO class
            pojoObject.setFileName(data[i][0]);
            pojoObject.setDetail(data[i][1]);
            pojoObject.setFileImage(data[i][2]);
            //After setting the values, we add all the Objects to the array
            //Hence, listConentArr is a collection of Array of POJO objects
            listContentArr.add(pojoObject);
        }
        //We set the array to the adapter
        adapter.setListContent(listContentArr);
        //We in turn set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }

