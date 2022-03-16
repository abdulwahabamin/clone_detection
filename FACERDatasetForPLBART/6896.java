        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            File file=files[position];
            if(file.isFile()){
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri data=Uri.fromFile(file);
                int index=file.getName().lastIndexOf(".");
                String suffix=file.getName().substring(index+1);
                String type= MimeTypeMap.getSingleton().getMimeTypeFromExtension(suffix);
                intent.setDataAndType(data,type);
                startActivity(intent);
            }else{
                nowPathStack.push("/"+file.getName());
                showChanged(getPathString());
            }
        }

