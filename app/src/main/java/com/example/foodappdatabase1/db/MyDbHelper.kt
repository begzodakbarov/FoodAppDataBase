package com.example.foodappdatabase1.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.foodappdatabase1.models.Food

class MyDbHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null ,DB_VERSION), MyDbInterface {
    companion object{
        val DB_NAME = "food_db"
        val DB_VERSION = 1

        val TABLE_NAME="foof_table"
        val FOOD_ID="id"
        val FOOD_NAME="name"
        val FOOD_PRODUCT="product"
        val FOOD_INSTRUCTION="instruction"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table $TABLE_NAME($FOOD_ID integer not null primary key autoincrement unique, $FOOD_NAME text not null, $FOOD_PRODUCT text not null, $FOOD_INSTRUCTION text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    override fun addFood(food: Food) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(FOOD_NAME, food.nomi)
        contentValues.put(FOOD_PRODUCT, food.mahsulotlar)
        contentValues.put(FOOD_INSTRUCTION, food.tartibi)
        database.insert(TABLE_NAME, null,contentValues)
        database.close()
    }

    override fun getAllFood(): List<Food> {
        val database = this.writableDatabase
        val list = ArrayList<Food>()
        val query = "select * from $TABLE_NAME"
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                var food = Food(
                    id = cursor.getInt(0),
                    nomi = cursor.getString(1),
                    mahsulotlar = cursor.getString(2),
                    tartibi = cursor.getString(3)
                )
                list.add(food)
            } while (cursor.moveToNext())
        }
        return list
        }
    }