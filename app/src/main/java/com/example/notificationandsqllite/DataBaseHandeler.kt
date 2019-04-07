package com.example.notificationandsqllite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class DataBaseHandeler(context : Context) : SQLiteOpenHelper(context, "Mydb",null,1){
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $user($id INTEGER,$name TEXT)"
        db?.execSQL(createTable)
    }

    companion object {
        private val user = "User"
        private val id = "id"
        private val name = "name"
    }

    public fun createUser(user1  : User){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(name,user1.name)
        values.put(id,user1.id)
        db.insert(user,null,values)
        db.close()
    }

    public fun fetchUser() : String{
        var display = ""
        val db = readableDatabase
        val query = "SELECT * FROM $user"
        val cursor = db.rawQuery(query, null)
        if(cursor != null){
            if (cursor.moveToFirst()){
                do {
                    var id = cursor.getString(cursor.getColumnIndex(id))
                    var name = cursor.getString(cursor.getColumnIndex(name))
                     display = "$id, $name"
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()

        return display
    }

}