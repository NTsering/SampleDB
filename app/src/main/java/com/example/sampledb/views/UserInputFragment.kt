package com.example.sampledb.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sampledb.R
import com.example.sampledb.databinding.FragmentUserInputBinding
import com.example.sampledb.db.DatabaseBuilder
import com.example.sampledb.db.User
import com.example.sampledb.repo.DatabaseHelperImpl

class UserInputFragment : Fragment() {

    //    private lateinit var viewModel: UserInputViewModel
    private lateinit var editText: EditText
    private val viewModel: UserInputViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val appDatabase = DatabaseBuilder.getInstance(context)
        val databaseHelperImpl = DatabaseHelperImpl(appDatabase)
        viewModel.databaseHelperImpl = databaseHelperImpl
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // MartianDataBinding binding = DataBindingUtil.inflate(
        //            inflater, R.layout.martian_data, container, false);

        val binding =
            DataBindingUtil.inflate<FragmentUserInputBinding>(
                inflater,
                R.layout.fragment_user_input,
                container,
                false
            )
//        var veiwModel = UserInputViewModel()
        binding.userInputViewModel = viewModel
        binding.lifecycleOwner = this
//        view1 = inflater.inflate(R.layout.fragment_user_input, container, false)
//        view1.findViewById<Button>(R.id.button_next).setOnClickListener {
//            findNavController().navigate(R.id.action_userInputFragment_to_userListFragment)
//        }
//        return view1
        val editText = binding.editTextName

        binding.buttonSubmit.setOnClickListener {
            println("Name:  ${editText.text}")
//            viewModel.changeText(editText.text.toString())
            val user = User(name = editText.text.toString())
            viewModel.insertUser(user)
            editText.text.clear()
//            // findNavController().navigate(R.id.action_userInputFragment_to_userListFragment)
        }

        binding.buttonShowUsers.setOnClickListener {
            findNavController().navigate(R.id.action_userInputFragment_to_userListFragment)
        }
        return binding.root
    }
}
