package com.kayden.tamagotchipetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast



class MainActivity2 : AppCompatActivity() {

    private var hungerLevel = 50
    private var cleanlinessLevel = 50
    private var healthLevel = 100

    private lateinit var hungerProgressBar: ProgressBar
    private lateinit var cleanlinessProgressBar: ProgressBar
    private lateinit var healthProgressBar: ProgressBar
    private lateinit var petImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initialize progress bars and image view
        hungerProgressBar = findViewById(R.id.hungerProgressBar)
        cleanlinessProgressBar = findViewById(R.id.cleanlinessProgressBar)
        healthProgressBar = findViewById(R.id.healthProgressBar)
        petImageView = findViewById(R.id.petview)

        updateProgressBars()
    }

    // Code when pet is hungry
    fun feedPet(view: View) {
        hungerLevel -= 10
        if (hungerLevel < 100) hungerLevel = 100
        updateProgressBars()
        // Update pet image here
        petImageView.setImageResource(R.drawable.pet_happy)
        Toast.makeText(this, "You fed your pet!", Toast.LENGTH_SHORT).show()
    }

    // Code when pet wants to play
    fun playWithPet(view: View) {
        healthLevel += 10
        if (healthLevel > 100) healthLevel = 100
        cleanlinessLevel -= 5
        if (cleanlinessLevel < 0) cleanlinessLevel = 0
        updateProgressBars()
        // Update pet image here
        petImageView.setImageResource(R.drawable.pet_playing)
        Toast.makeText(this, "You played with your pet!", Toast.LENGTH_SHORT).show()
    }

    // When pet wants to play
    fun cleanPet(view: View) {
        cleanlinessLevel += 10
        if (cleanlinessLevel > 100) cleanlinessLevel = 100
        updateProgressBars()
        // Update pet image here
        petImageView.setImageResource(R.drawable.pet_clean)
        Toast.makeText(this, "You cleaned your pet!", Toast.LENGTH_SHORT).show()
    }

    // Method to update progress bars
    private fun updateProgressBars() {
        hungerProgressBar.progress = hungerLevel
        cleanlinessProgressBar.progress = cleanlinessLevel
        healthProgressBar.progress = healthLevel
    }
}
