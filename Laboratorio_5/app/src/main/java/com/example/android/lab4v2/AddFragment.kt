package com.example.android.lab4v2

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.android.lab4v2.databinding.FragmentAddBinding
import com.example.android.lab4v2.databinding.FragmentInvitedBinding
import com.example.android.lab4v2.game.GameViewModel

/**
 * A simple [Fragment] subclass.
 */
class AddFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentAddBinding>(inflater,
            R.layout.fragment_add, container, false)

        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        (activity as AppCompatActivity).supportActionBar?.title = "Agregar Invitado"
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.save_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_button -> {
                viewModel.namelist.value = "AHORA SI PERRO"
                view?.findNavController()?.navigate(R.id.action_addFragment_to_invitedFragment)
            }



        }
        return super.onOptionsItemSelected(item)
    }


}
