package com.example.sampledb.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sampledb.R
import com.example.sampledb.databinding.FragmentUserListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment() {
    private lateinit var binding: FragmentUserListBinding
    private val viewModel: UserListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_user_list,
                container,
                false
            )
        binding.userListViewModel = viewModel
        binding.lifecycleOwner = this
        observeData()

//        return inflater.inflate(R.layout.fragment_user_list, container, false)
        return binding.root
    }

    private fun observeData() {
        viewModel.users.observe(viewLifecycleOwner) {
            binding.textDetails.text = it.toString()
        }
    }
}
