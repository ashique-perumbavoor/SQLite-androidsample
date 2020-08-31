package com.example.sqliteproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*

class searchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        btn_search.setOnClickListener {
            searchFunction()
        }
    }

    fun searchFunction() {

        val databaseHandler: DatabaseHandler = DatabaseHandler(this)

        if (searchByID.text.toString() != "") {
            val emp: List<EmpModelClass> =
                databaseHandler.search(EmpModelClass(Integer.parseInt(searchByID.text.toString()), "", ""))

            val empArrayId = Array<String>(emp.size){"0"}
            val empArrayName = Array<String>(emp.size){"null"}
            val empArrayEmail = Array<String>(emp.size){"null"}
            var index = 0
            for(e in emp){
                empArrayId[index] = e.userId.toString()
                empArrayName[index] = e.userName
                empArrayEmail[index] = e.userEmail
                index++
            }
            //creating custom ArrayAdapter
            val myListAdapter = MyListAdapter(this,empArrayId,empArrayName,empArrayEmail)
            listViewSearch.adapter = myListAdapter
        } else {
            Toast.makeText(this, "Enter any ID to search", Toast.LENGTH_LONG).show()
        }

    }

}