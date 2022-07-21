package com.example.weatherforecast.fragments

import android.Manifest
import android.os.Build.VERSION_CODES.N
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherforecast.adapters.ViewPagerAdapter
import com.example.weatherforecast.databinding.FragmentMainBinding
import com.example.weatherforecast.isPermissionGranted
import com.google.android.material.tabs.TabLayoutMediator
const val API_KEY = "0fb7f31f833144f5af9132623220207"
class MainFragment : Fragment() {
    private val fList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )
    private val tlist = listOf("HOURS", "DAYS")
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkPermission()
        init()
        requestWeatherData("Odessa")

    }

    private fun init() = with(binding){

        val adapter = ViewPagerAdapter(activity as FragmentActivity, fList)
        vp.adapter = adapter
        TabLayoutMediator(tabLayout, vp){
            tab, pos-> tab.text = tlist[pos]
        }.attach()
    }

    private fun permissionListener(){

        pLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkPermission(){

        if(!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)){
            permissionListener()
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun requestWeatherData(city: String){

        val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY&q=$city&days=3&aqi=no&alerts=no"
        val queue = Volley.newRequestQueue(context)
        val request = StringRequest(
            Request.Method.GET,
            url,
            {
                    result->Log.d("ErrorLog", "Result: $result")
            },
            {
                error->
                Log.d("ErrorLog", "Error: $error")
            }
        )
        queue.add(request)
    }

    companion object {

        @JvmStatic fun
        newInstance() = MainFragment()

    }
}