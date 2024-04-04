package com.dicoding.picodiploma.githubuserapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Users>()
    private lateinit var binding: ActivityMainBinding

    private fun showSelectedUser(users: Users) {
        val moveIntent = Intent(this@MainActivity, DetailOfUser::class.java)
        moveIntent.putExtra(DetailOfUser.EXTRA_USERS,users)

        startActivity(moveIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGithubusers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }


    private val listUsers: ArrayList<Users>
        get() {
            val dataName = resources.getStringArray(R.array.fullname)
            val dataUsers = resources.getStringArray(R.array.username)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)

            val listUsers = ArrayList<Users>()
            for (i in dataName.indices) {
                val user = Users(dataName[i], dataUsers[i], dataPhoto.getResourceId(i, -1),
                    dataLocation[i], dataRepository[i], dataCompany[i], dataFollowers[i], dataFollowing[i])
                listUsers.add(user)
            }
            return listUsers
        }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvGithubusers.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvGithubusers.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        binding.rvGithubusers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Users) {
                showSelectedUser(data)
            }
        })

    }
}