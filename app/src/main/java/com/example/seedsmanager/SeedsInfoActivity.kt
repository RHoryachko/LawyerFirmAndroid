package com.example.seedsmanager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SeedsInfoActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SeedAdapter
    private val dataSet = arrayListOf<SeedModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seeds_info)

        val finish=findViewById<Button>(R.id.button_finish)

        finish.setOnClickListener{
            finish()
        }

        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = SeedAdapter(dataSet){position->
            showUpdateDialog(position = position, seedModel = dataSet[position] )
        }
        recyclerView.adapter = adapter

        dataSet.addAll(arrayListOf(
            SeedModel("Emily Johnson", " emily.johnson@example.com", "+1 (555) 123-4567", " 123 Main Street, Anytown"),
            SeedModel("Ethan Smith", "ethan.smith@example.com", "+1 (555) 987-6543", "456 Elm Street, Otherville"),
            SeedModel("Olivia Garcia", "olivia.garcia@example.com", "+1 (555) 567-8901", "ak Avenue, Anycity,"),
            SeedModel("Liam Martinez", "liam.martinez@example.com", "+1 (555) 234-5678", "101 Pine Road, Anytown"),
            SeedModel("Ava Brown", "ava.brown@example.com", "+1 (555) 876-5432", "Maple Lane, Otherville"),
            SeedModel("Noah Rodriguez", "noah.rodriguez@example.com", "+1 (555) 345-6789", "333 Birch Street, Anycity"),
            SeedModel("Isabella Wilson", "isabella.wilson@example.com", "+1 (555) 654-3210", "555 Spruce Court, Otherville"),
            SeedModel("James Lee", "james.lee@example.com", "+1 (555) 789-0123", "54 Silent Court, Otherville"),
            SeedModel("Mia Thompson", "mia.thompson@example.com", " +1 (555) 432-1098", "666 Oak Avenue, Anycity"),
            SeedModel("Alexander Harris", "alexander.harris@example.com", "+1 (555) 210-9876", "12 Birch Street, Anycity")
            ))


    }

    @SuppressLint("NotifyDataSetChanged", "SetTextI18n")


    private fun showUpdateDialog(position: Int, seedModel: SeedModel) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.seed_info_dialog, null)

        val start = dialogView.findViewById<TextView>(R.id.start_month)
        val end = dialogView.findViewById<TextView>(R.id.end_month)
        val time = dialogView.findViewById<TextView>(R.id.time)

        start.text="Email:"
        end.text=seedModel.startMonth+". Phone: "+seedModel.endMonth
        time.text="Adress: "+seedModel.timeToGrow

        builder.setView(dialogView)
            .setTitle(seedModel.name)
            .setNegativeButton("Back") { dialog, which ->
                dialog.cancel()
            }
            .show()
    }

}
