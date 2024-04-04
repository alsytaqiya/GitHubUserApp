package com.dicoding.picodiploma.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.picodiploma.githubuserapp.databinding.ActivityDetailOfUserBinding

class DetailOfUser : AppCompatActivity() {
    private lateinit var binding: ActivityDetailOfUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailOfUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = intent.getParcelableExtra<Users>(EXTRA_USERS) as Users


        binding.imgItemPhoto.setImageResource(users.avatar)
        binding.tvUsername.setText(users.username)
        binding.tvFullname.text = StringBuilder("Fullname: ").append(users.fullname)
        binding.tvLocation.text = StringBuilder("Location: ").append(users.location)
        binding.repository.text = StringBuilder("Repository: ").append(users.repository)
        binding.company.text = StringBuilder("Company: ").append(users.company)
        binding.followers.text = StringBuilder("Followers: ").append(users.followers)
        binding.following.text = StringBuilder("Following: ").append(users.following)

    }

    companion object {
        const val EXTRA_USERS = "extra_person"
    }
}