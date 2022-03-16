	public synchronized boolean ensureTable(Context context) {
		boolean ensured=false;
		//BLog.e("DBT", "-"+TABLE_NAME);
		if(open()) {
		
        //db.setVersion(1);
	        if(TABLE_NAME!=null) {


                boolean hasTable=false;
                Cursor checkcursor = db.rawQuery("SELECT * FROM sqlite_master WHERE name=\""+TABLE_NAME+"\"",null);//+TABLE_NAME+" LIMIT 1", null);;
                if(checkcursor!=null) {
                    checkcursor.moveToFirst();
                    if (checkcursor.getCount() > 0) {
                        do {
                            hasTable=true;
                            //BLog.e("DBO",checkcursor.getString(checkcursor.getColumnIndex("name")));
                        } while (checkcursor.moveToNext());
                    }
                }

                // below is sql to select all tables, use this to check for table and create  if not there, want to do silent style.
                // SELECT * FROM sqlite_master;
                if(!hasTable) {
                    createTable();
                }

                Cursor cursor = null;



	        	if(hasTable) {
                    try {
                        cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" LIMIT 1", null);
                    } catch(Exception e) {
                        // no table exists, create it and done.
                        //createTable();
                        //ensured=true;
                    }
		        	if(cursor!=null) {
		            	// test columns
		            	ArrayList<DbField> noncolumns=new ArrayList<DbField>();
		            	
		            	String [] cols = cursor.getColumnNames();
		            	for(int i=0; i<TABLE_FIELDS.length; i++) {
		            		boolean found=false;
		            		DbField f= TABLE_FIELDS[i];
		            		for(int j=0; j<cols.length; j++) {
		            			if(cols[j].equals(f.getName())) {
		            				found=true; 
		            				break;
		            			}
		            		}
		            		// if it gets here no field found
		            		if(!found)
		            			noncolumns.add(f);
		            	}
		            	if(!noncolumns.isEmpty())
		            		modifyTableAddColums(noncolumns);
		        	} else {
		        		BLog.add("DB error ensureTable() "+TABLE_NAME+" cursor returned as NULL");
		        	}
	        	}
	        	if(cursor!=null)
	        		cursor.close();
	        } else {
	        	BLog.add("DB error ensureTable() NULL TABLE_NAME");
	        }
		}
		return ensured;
	}

