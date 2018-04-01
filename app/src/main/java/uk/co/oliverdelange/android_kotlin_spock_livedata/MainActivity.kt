package uk.co.oliverdelange.android_kotlin_spock_livedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.oliverdelange.android_kotlin_spock_livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.vm = viewModel

        viewModel.nameError.observe(this, Observer { t ->
            name_input_layout.error = binding.vm?.nameError?.value
        })
    }
}
